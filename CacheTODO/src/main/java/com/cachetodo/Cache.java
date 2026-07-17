package com.cachetodo;


import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.cachetodo.strategy.EvictionPolicy;

public class Cache<K, V> {

    private class CacheEntry<K>{
        V value;
        long expiryTimeMillis;

        CacheEntry(V value, long ttlMillis){
            this.value = value;
            this.expiryTimeMillis = System.currentTimeMillis() + ttlMillis;
        }

        boolean isExpired(){
            return  System.currentTimeMillis() >= expiryTimeMillis;
        }

    }
    private EvictionPolicy<K> evictionPolicies;
    private final Map<K, CacheEntry<V>> storage;
    private final int capacity;

    public Cache(int capacity, EvictionPolicy<K> initialPolicy){
        this.capacity = capacity;
        this.evictionPolicies = initialPolicy;
        this.storage = new ConcurrentHashMap<>();
    }

    public void put(K key, V value){
        // eviction policy is used when storage reaches its capacity
        if(capacity == 0) return ;
        if(!storage.containsKey(key)){
            if(storage.size() == capacity){
                K keyToEvict = evictionPolicies.evict();
                if(keyToEvict != null){
                    storage.remove(keyToEvict);
                }
            }
        }
        storage.put(key, value);
        evictionPolicies.keyAccessed(key);
    }

    public V get(K key){
        // if you get the keys, respective evictino policy keyset should be updated regarding its access
        if(!storage.containsKey(key)){
            return null;
        }
        this.evictionPolicies.keyAccessed(key);
        return storage.get(key);
    }

    public void setEvicitionPolicy(EvictionPolicy<K> newPolicy){
        this.evictionPolicies = newPolicy;
        // we need to hydrate the data as well
        this.evictionPolicies.hydrate(storage.keySet());
    }

    public int size(){
        return storage.size();
    }


}
