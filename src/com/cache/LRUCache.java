package com.cache;

import java.util.HashMap;
import java.util.Map;
//TODO: eliminate redundancy
public class LRUCache {

	private Map<Integer, Node> cache;
	private int capacity;
	private int size;
	private Node head;
	private Node tail;

	static class Node {
		int val;
		int data;
		Node next;
		Node prev;

		Node(int val, int data) {
			this.val = val;
			this.data = data;
		}
	}

	LRUCache(int capacity) {
		this.size = 0;
		this.capacity = capacity;
		cache = new HashMap<>();

		head = new Node(-1, -1);
		tail = new Node(-1, -1);

		head.next = tail;
		tail.prev = head;
	}

	public void put(int key, int value) {

		if (!cache.containsKey(key)) {
			Node newNode = new Node(key, value);
			Node tempNode = head.next;

			head.next = newNode;
			newNode.prev = head;

			newNode.next = tempNode;
			tempNode.prev = newNode;

			cache.put(key, newNode);
			++size;
			if (size > capacity) {
				Node lastItem = tail.prev;

				tail.prev = lastItem.prev;
				lastItem.prev.next = tail;
				--size;

				cache.remove(lastItem.val);
			}
		} else {
			Node node = cache.get(key);
			remove(node);
			
			cache.remove(key);
			--size;
			put(key, value);
			
			//addNode
//			Node newNode = new Node(key, node.data);
//			Node tempNode = head.next;
//
//			head.next = newNode;
//			newNode.prev = head;
//
//			newNode.next = tempNode;
//			tempNode.prev = newNode;
		}
	}

	private void remove(Node node) {
		Node prevNode = node.prev;
		Node nextNode = node.next;

		prevNode.next = nextNode;
		nextNode.prev = prevNode;
	}

	public int get(int key) {
		Node node = cache.get(key);
		
		if (node == null) {
			return -1;
		}
		
		
		remove(node);
		//original version works with below 3 lines
//		cache.remove(key);
//		--size;
//		put(key, node.data);

		
		//addNode
		//TODO: understand why this does not work & below snippet works
//		Node newNode = new Node(key, node.data);
//		Node tempNode = head.next;
//
//		head.next = newNode;
//		newNode.prev = head;
//
//		newNode.next = tempNode;
//		tempNode.prev = newNode;
		
		//addNode
		Node tempNode = head.next;

		head.next = node;
		node.prev = head;

		node.next = tempNode;
		tempNode.prev = node;

		return node.data;
	}

	public static void main(String[] args) {
		LRUCache lruCache = new LRUCache(2);

		lruCache.put(1, 1);
		lruCache.put(2, 2);
		System.out.println(lruCache.get(1)); // returns 1
		lruCache.put(3, 3); // evicts key 2
		System.out.println(lruCache.get(2)); // returns -1 (not found)
		lruCache.put(4, 4); // evicts key 1
		System.out.println(lruCache.get(1)); // returns -1 (not found)
		System.out.println(lruCache.get(3)); // returns 3
		System.out.println(lruCache.get(4)); // returns 4

	}
}
