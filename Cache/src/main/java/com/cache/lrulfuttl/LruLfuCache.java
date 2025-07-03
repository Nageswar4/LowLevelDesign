package com.cache.lrulfuttl;

import java.time.Duration;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class LruLfuCache {
	long ttl;
	int size;
	int capacity;
	Map<Integer, Cache> linkedHashMap;
	Map<Integer, Map<Integer, Cache>> frequencyMap;
	/*
	 * Here i am using LinkedHashMap to maintain data in insertion order and
	 * frequencyMap as TreeMap to store data in sorting manner based on key and
	 * internally aslo i am using LinkedHashMap only to maintain insertion order
	 * based on frequency
	 */

	/*
	 * In Cache class we have key ,value ,frequency and recentlyAccessTime frequency
	 * -> No of times it is accessed recentlyAccessTime -> last time when it is used
	 * or updated frequency is required for LFU recentlyAccessTime is required for
	 * LRU
	 */

	class Cache {
		int key;
		int value;
		int frequency;
		long recentlyAccessTime;

		public Cache(int key, int value) {
			this.key = key;
			this.value = value;
			this.frequency = 1;
			this.recentlyAccessTime = System.currentTimeMillis();
		}
	}

	public LruLfuCache(int capacity, long ttl) {
		this.capacity = capacity;
		this.linkedHashMap = new LinkedHashMap<>();
		this.frequencyMap = new TreeMap<>();
		this.ttl = ttl;

	}
	/*
	 * In get method we will check if key is present or not. If not we are going to
	 * return -1 In case if key is present we are checking based on current system
	 * time and recentlyAccessTime of the cache Node we will check wheather it is
	 * less than TTL or not if not we are going removing that from our LinkedHashMap
	 * and frequencyMap and return -1;
	 * 
	 * if time is valid then we are updating that node frquency by 1 and
	 * recentlyAccessTime of that node
	 * 
	 * finally we will return it's value
	 * 
	 */

	public int getValue(int key) {
		Cache cache;
		if (!linkedHashMap.containsKey(key)) {
			return -1;
		}
		cache = linkedHashMap.get(key);
		if (!isValid(cache)) {
			removeCache(cache);
			return -1;
		}
		update(cache);
		return cache.value;

	}
	/*
	 * In removeCache method we need to remove cacheNode from both LinkedHashMap and
	 * frequencyMap and after removing both i am checking here if cache.frequency do
	 * we have any data or not. If not i am removing that internal map of
	 * frequencyMap
	 * 
	 */

	private void removeCache(Cache cache) {
		linkedHashMap.remove(cache.key);
		int frequency = cache.frequency;
		Map<Integer, Cache> freqeuncyLinkedHashMap = frequencyMap.get(frequency);
		freqeuncyLinkedHashMap.remove(cache.key);
		if (freqeuncyLinkedHashMap.isEmpty()) {
			frequencyMap.remove(frequency);
		}

	}
	/*
	 * Condition 1: checking if capacity size is lessthan equal to zero if yes then
	 * i am returning Condition 2: checking if same key is exist in the map or not
	 * if yes i need to update cacheNode cacheNode value with new Value and updating
	 * Cache Condition 3: if key is not exist then i am checking if size of
	 * LinkedHashMap is greater than equal to capacity I am checking first in LRU
	 * cache if first value is valid or not if it is not valid i am removing it. if
	 * it is valid i am removing first element in from frequency map Condition 4: if
	 * it is new element i am creating new Cache Node and adding in both
	 * LinkedHashMap and FrequencyMap
	 * 
	 */

	public void put(int key, int value) {
		if (capacity <= 0)
			return;
		Cache cache;
		if (linkedHashMap.containsKey(key)) {
			cache = linkedHashMap.get(key);
			cache.value = value;
			update(cache);
			return;
		}

		if (linkedHashMap.size() >= capacity) {
			Map.Entry<Integer, Cache> map = linkedHashMap.entrySet().iterator().next();
			if (!isValid(map.getValue())) {
				removeCache(map.getValue());
			} else {
				Cache leastFrequencyNode = null;
				for (Map.Entry<Integer, Map<Integer, Cache>> treeMap : frequencyMap.entrySet()) {
					Map<Integer, Cache> linkedHash = treeMap.getValue();
					Map.Entry<Integer, Cache> cacheMap = linkedHash.entrySet().iterator().next();
					leastFrequencyNode = cacheMap.getValue();
					break;
				}
				if (leastFrequencyNode != null)
					removeCache(leastFrequencyNode);
			}
		}

		cache = new Cache(key, value);
		addInCache(cache);
	}
	/*
	 * In update function first i am removing in both LinkedHashMap and frequencyMap
	 * again adding data in LinkedHashMap and frequencyMap with increased frequency
	 */

	private void update(Cache cache) {
		removeCache(cache);
		cache.frequency = cache.frequency + 1;
		cache.recentlyAccessTime = System.currentTimeMillis();
		addInCache(cache);
	}
	/*
	 * In addInCache method i am just adding in both LinkedHashMap and frequencyMap
	 */

	private void addInCache(Cache cache) {
		linkedHashMap.put(cache.key, cache);
		Map<Integer, Cache> freqeuncyLinkedHashMap = frequencyMap.getOrDefault(cache.frequency, new LinkedHashMap<>());
		freqeuncyLinkedHashMap.put(cache.key, cache);
		frequencyMap.put(cache.frequency, freqeuncyLinkedHashMap);
	}

	/*
	 * In isValid method we are going to check wheather that cacheNode is valid
	 * based on TTL
	 */
	private boolean isValid(Cache cache) {
		if (System.currentTimeMillis() - cache.recentlyAccessTime >= ttl) {
			return false;
		}

		return true;
	}

	public static void main(String[] arg) {
		long ttlInDays = 2;

		// Convert days to Duration
		Duration ttlDuration = Duration.ofDays(ttlInDays);

		// Get the TTL in milliseconds
		long ttlInMillis = ttlDuration.toMillis();
		LruLfuCache cache = new LruLfuCache(4, ttlInMillis);
		cache.put(1, 1);
		cache.put(2, 2);
		cache.put(3, 3);
		cache.put(4, 4);
		System.out.println("size of map is " + cache.linkedHashMap.size());
		cache.put(5, 4);
		System.out.println("size of map is " + cache.linkedHashMap.size());

	}

}
