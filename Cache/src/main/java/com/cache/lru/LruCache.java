package com.cache.lru;

import java.util.HashMap;
import java.util.Map;

public class LruCache<K, V> {

	private int capacity;
	private int size;
	Map<K, Node> map;
	Node head;
	Node tail;

	public LruCache(int capacity) {
		this.capacity = capacity;
		this.size = 0;
		this.map = new HashMap<>();
		this.head = null;
		this.tail = head;
	}

	public V get(K k) {
		Node node = map.get(k);
		if (node == null) {
			return null;
		}
		moveToHead(node);

		return (V) node.value;
	}

	private void moveToHead(Node node) {
		if (node == head) {
			return;
		}
		if (node.next != null) {
			node.next.prev = node.prev;
		}
		if (node.prev != null) {
			node.prev.next = node.next;
		}
		if (tail == node) {
			tail = node.prev;
		}

		node.prev = null;
		node.next = head;
		if (head != null) {
			head.prev = node;
		}
		head = node;

	}

	private void removeNode(Node node) {

		if (node.prev != null) {
			node.prev.next = node.next;
		} else {
			/*
			 * Node was head
			 */
			head = node.next;
		}

		if (node.next != null) {
			node.next.prev = node.prev;
		} else {
			/*
			 * Node was tail
			 */
			tail = node.prev;
		}

	}

	public void removeTail() {
		this.map.remove(tail.key);
		removeNode(tail);
	}

	public void add(K k, V value) {
		Node node = map.get(k);

		if (node != null) {
			/*
			 * Update existing node
			 */
			node.value = value;
			moveToHead(node);
		} else {
			/*
			 * Create new node
			 */
			Node newNode = new Node(k, value);

			/*
			 * Add to map
			 */
			map.put(k, newNode);

			/*
			 * Insert at head
			 */
			newNode.next = head;
			if (head != null) {
				head.prev = newNode;
			}
			head = newNode;

			if (tail == null) {
				tail = newNode;
			}
			size++;

			/*
			 * If over capacity, remove tail
			 */
			if (size > capacity) {
				map.remove(tail.key);
				removeNode(tail);
				size--;
			}
		}
	}

}
