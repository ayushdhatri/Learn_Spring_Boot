package com.cachetodo.strategy;

import java.util.Set;

public interface EvictionPolicy<K> {
    // called every time a key is access or added so that we can insert the data into our eviction policy ds
    void keyAccessed(K key);

    K evict();// this returns the key to be evicted

    void hydrate(Set<K> keys);// when we change the policy this is used to transfer to new policy

    // Needed for TTL so the Sweeper/Guard can drop expired keys from the tracking list
    void remove(K key);
}