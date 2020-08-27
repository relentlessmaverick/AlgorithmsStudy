package com.basicdatastructures;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * HashMap Implementation with O(1) get, O(1) put operations
 * Uses Generics
 * @author vikrantmathure
 *
 */
public class BasicHashMapv2<K, V> {

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < bucketarray.length; i++) {
			LinkedList<Node<K, V>> list = bucketarray[i];
			Iterator<Node<K, V>> iter = list.iterator();
			while (iter.hasNext()) {
				Node<K, V> node = iter.next();
				sb.append("bucketIndex=");
				sb.append(i);
				sb.append(" | ");
				sb.append(node.key);
				sb.append("=");
				sb.append(node.value);
				sb.append(" , ");
				sb.append("\n");
			}
		}
		return "BasicHashMap [bucketarray=> " + "\n" + sb.toString().substring(0, sb.length() - 3) + "]";
	}

	LinkedList<Node<K, V>>[] bucketarray;
	int capacity;
	int size;

	private static class Node<K, V> {

		K key;
		V value;

		public Node(K key, V value) {
			super();
			this.key = key;
			this.value = value;
		}
	}

	public BasicHashMapv2(int capacity) {
		bucketarray = new LinkedList[capacity];
		this.capacity = capacity;
		this.size = 0;

		for (int i = 0; i < bucketarray.length; i++) {
			bucketarray[i] = new LinkedList<>();
		}
	}

	public V get(K key) {
		int hashVal = getBucketIndex(key);
		LinkedList<Node<K, V>> list = bucketarray[hashVal];

		Iterator<Node<K, V>> iter = list.iterator();

		while (iter.hasNext()) {
			Node<K, V> n = iter.next();
			if (key == n.key) {
				return n.value;
			}
		}
		return null;
	}

	public <K, V> void put(K key, V value) {
		//assuming load factor of 0.8
		if (size >= 0.8 * capacity) {
			System.out.println("\ncapacity full .... rehashing ....\n");
			doubleMapAndRehash();
		}
		size++;
		int hashVal = getBucketIndex(key);
		bucketarray[hashVal].add(new Node(key, value));
	}

	// object hashcode can be negative
	private <K> int getBucketIndex(K key) {
		int hashCode = key.hashCode();
		int index = Math.abs(hashCode % capacity);
		return index;
	}
	
	/**
	 * rehashing & doubling the size of the bucketArray
	 */
	private <K, V> void doubleMapAndRehash() {
		LinkedList[] tempArray = bucketarray;
		capacity = 2 * capacity;
		bucketarray = new LinkedList[capacity];
		size = 0;

		for (int i = 0; i < bucketarray.length; i++) {
			bucketarray[i] = new LinkedList<>();
		}

		for (int i = 0; i < tempArray.length; i++) {
			LinkedList<Node<K, V>> list = tempArray[i];
			Iterator<Node<K, V>> iter = list.iterator();
			while (iter.hasNext()) {
				Node<K, V> node = iter.next();
				int hashVal = getBucketIndex(node.key);
				bucketarray[hashVal].add(new Node(node.key, node.value));
			}
		}
	}
	
	/**
	 * driver
	 * @param args
	 */
	public static void main(String[] args) {
		BasicHashMapv2<Integer, Integer> map = new BasicHashMapv2<>(8);
		map.put(1, 100);
		map.put(16, 200);
		map.put(3, 300);
		map.put(24, 400);
		map.put(5, 500);
		map.put(6, 7500);
		map.put(7, 8500);
		System.out.println(map);
		map.put(10, 89);

		System.out.println(map);
		System.out.println(map.get(3));
		System.out.println(map.get(24));
		System.out.println(map.get(16));
		System.out.println(map.get(234));
		
		BasicHashMapv2<String, Integer> stringMap = new BasicHashMapv2<>(4);
		stringMap.put("Sydney", 6);
		stringMap.put("SanJose", 7);
		stringMap.put("SanFrancisco", 12);
		stringMap.put("Summerland", 10);
		stringMap.put("Sealand", 7);
		stringMap.put("Sitarampur", 10);
		stringMap.put("Somalia", 7);
		stringMap.put("Sweden", 6);
		System.out.println(stringMap);
		System.out.println(stringMap.get("awesome"));
		System.out.println(stringMap.get("Summerland"));
		
	}

}
