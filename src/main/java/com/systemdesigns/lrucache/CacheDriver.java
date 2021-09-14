package com.systemdesigns.lrucache;

public class CacheDriver {
    public static void main(String[] args) {
        int cacheSize = 3;
        InMemoryCache memoryCache = new InMemoryCache(cacheSize);
        LRUCacheService cacheService = new LRUCacheServiceImpl(memoryCache);

        cacheService.put(1, "one");
        cacheService.put(2, "two");
        cacheService.put(3, "three");
        cacheService.put(4, "four");
        cacheService.get(2);

    }
}
