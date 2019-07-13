package com.maps;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * This LRU Cache is backed by a LinkedHashMap
 * @author vikrantmathure
 *
 */
public final class LRUCacheSingleton {

	private Map<Integer, Integer> cache;
	private int capacity;
	private static volatile LRUCacheSingleton cacheInstance;
	
	/**
	 * ThreadSafe getInstance()
	 * @param capacity
	 * @return
	 */
	public static LRUCacheSingleton getInstance(int capacity) {
		if(cacheInstance == null) {
			synchronized(LRUCacheSingleton.class) {
				if (cacheInstance == null) {
					cacheInstance = new LRUCacheSingleton(capacity);
				}
			}	
		}	
	return cacheInstance;
	}
	
	/**
	 * private Constructor
	 * @param capacity
	 */
	private LRUCacheSingleton(int capacity) {
		cache = new LinkedHashMap<>();
		this.capacity = capacity;
	}

	public Map<Integer, Integer> getCache() {
		return cache;
	}
	
	/**
	 * Retrives from cache
	 * @param key
	 * @return
	 */
	public int get(int key) {
		if (cache.containsKey(key)) {
			int value = cache.get(key);
			cache.remove(key);
			cache.put(key, value);
			return value;
		} else {
			return -1;
		}
	}
	
	/**
	 * Add keys to cache
	 * @param key
	 * @param value
	 */
	public void put(int key, int value) {

		if (cache.size() == capacity) {
			if (cache.containsKey(key)) {
				cache.remove(key);
				cache.put(key, value);
			} else {
				int firstElement = cache.keySet().iterator().next();
				cache.remove(firstElement);
				cache.put(key, value);
			}
		} else {
			cache.remove(key);
			cache.put(key, value);
		}
	}

	public static void main(String[] args) {
		LRUCacheSingleton lruCache = LRUCacheSingleton.getInstance(10);
		System.out.println(lruCache.get(2)); 
		lruCache.put(2, 6);
		System.out.println(lruCache.get(1)); 
		lruCache.put(1, 5); 
		lruCache.put(1, 2);
		System.out.println(lruCache.get(1)); 
		System.out.println(lruCache.get(2));
		lruCache.put(3, 10); 
		lruCache.put(4, 10);
		System.out.println(lruCache.getCache());
	}
}