package com.cachetodo;


package com.cachetodo;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;
import com.cachetodo.strategy.EvictionPolicy;

public class CacheSystem
        <K, V> {

    // 1. The Wrapper to track Time-To-Live
    private static class CacheEntry<V> {
        V value;
        long expiryTimeMillis;

        CacheEntry(V value, long ttlMillis) {
            this.value = value;
            this.expiryTimeMillis = System.currentTimeMillis() + ttlMillis;
        }

        boolean isExpired() {
            return System.currentTimeMillis() >= expiryTimeMillis;
        }
    }

    private EvictionPolicy<K> evictionPolicies;
    // Upgraded to ConcurrentHashMap for thread safety
    private final Map<K, CacheEntry<V>> storage;
    private final int capacity;

    // Concurrency controls
    private final ReentrantLock lock = new ReentrantLock();
    private final ScheduledExecutorService sweeperThread;

    public Cache(int capacity, EvictionPolicy<K> initialPolicy, long sweeperIntervalSeconds) {
        this.capacity = capacity;
        this.evictionPolicies = initialPolicy;
        this.storage = new ConcurrentHashMap<>();

        // 2. THE SWEEPER (Active Expiration)
        this.sweeperThread = Executors.newSingleThreadScheduledExecutor(runnable -> {
            Thread thread = new Thread(runnable, "Cache-Sweeper-Daemon");
            thread.setDaemon(true); // Ensures this thread doesn't block app shutdown
            return thread;
        });

        this.sweeperThread.scheduleAtFixedRate(
                this::performBackgroundCleanup,
                sweeperIntervalSeconds,
                sweeperIntervalSeconds,
                TimeUnit.SECONDS
        );
    }

    // Notice we added ttlMillis to the put method
    public void put(K key, V value, long ttlMillis) {
        if (capacity == 0) return;

        lock.lock();
        try {
            if (!storage.containsKey(key)) {
                if (storage.size() == capacity) {
                    K keyToEvict = evictionPolicies.evict();
                    if (keyToEvict != null) {
                        storage.remove(keyToEvict);
                    }
                }
            }

            // Wrap the value and store it
            storage.put(key, new CacheEntry<>(value, ttlMillis));
            evictionPolicies.keyAccessed(key);
        } finally {
            lock.unlock();
        }
    }

    public V get(K key) {
        CacheEntry<V> entry = storage.get(key);

        if (entry == null) {
            return null;
        }

        // 3. THE GUARD (Lazy Expiration)
        if (entry.isExpired()) {
            removeInternal(key); // Safely drop it
            return null;
        }

        lock.lock();
        try {
            this.evictionPolicies.keyAccessed(key);
        } finally {
            lock.unlock();
        }
        return entry.value;
    }

    // Helper method to safely remove from both the map and the policy
    private void removeInternal(K key) {
        lock.lock();
        try {
            storage.remove(key);
            evictionPolicies.remove(key);
        } finally {
            lock.unlock();
        }
    }

    // The method executed by the Daemon Thread
    private void performBackgroundCleanup() {
        // Iterate over the thread-safe map
        for (Map.Entry<K, CacheEntry<V>> entry : storage.entrySet()) {
            if (entry.getValue().isExpired()) {
                removeInternal(entry.getKey());
            }
        }
    }

    public void setEvicitionPolicy(EvictionPolicy<K> newPolicy) {
        lock.lock();
        try {
            this.evictionPolicies = newPolicy;
            this.evictionPolicies.hydrate(storage.keySet());
        } finally {
            lock.unlock();
        }
    }

    public int size() {
        return storage.size();
    }

    // Call this gracefully when shutting down the server
    public void shutdown() {
        sweeperThread.shutdown();
    }
}