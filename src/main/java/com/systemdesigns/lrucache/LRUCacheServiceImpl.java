package com.systemdesigns.lrucache;

public class LRUCacheServiceImpl implements LRUCacheService {

    private final InMemoryCache inMemoryCache;

    public LRUCacheServiceImpl(InMemoryCache cache) {
        inMemoryCache = cache;
    }

    @Override
    public void put(int key, String value) {
        inMemoryCache.put(key, value);
    }

    @Override
    public String get(int key) {
        return inMemoryCache.get(key);
    }
}
