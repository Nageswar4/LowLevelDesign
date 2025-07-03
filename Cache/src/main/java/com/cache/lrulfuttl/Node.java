package com.cache.lrulfuttl;

public class Node<K, V> {

	K key;
	V value;
	long recentlyAccessTime;
	int frequencyCount;
	Node<K, V> next;
	Node<K, V> prev;

	public Node(K key, V value) {
		this.key = key;
		this.value = value;
		this.frequencyCount = 1;
		this.recentlyAccessTime = System.currentTimeMillis();
	}

}
