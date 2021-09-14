package com.systemdesigns.lrucache;

public interface LRUCacheService {
    void put(int key, String value);
    String get(int key);
}
