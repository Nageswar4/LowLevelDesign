package com.cache.lru;

public class Node<K, V> {

	K key;
	V value;
	Node next;
	Node prev;

	public Node(K key, V value) {
		this.key = key;
		this.value = value;
		this.next = null;
		this.prev = null;
	}
}
