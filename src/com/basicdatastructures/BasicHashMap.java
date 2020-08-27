package com.basicdatastructures;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * HashMap Implementation with O(1) get, O(1) put operations
 * w/o generics
 * @author vikrantmathure
 *
 */
public class BasicHashMap {
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < bucketarray.length; i++) {
			LinkedList<Node> list = bucketarray[i];
			Iterator<Node> iter = list.iterator();
			while(iter.hasNext()) {
				Node node = iter.next();
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

	LinkedList<Node>[] bucketarray;
	int capacity;
	int size;

	private class Node {

		int key;
		int value;

		public Node(int key, int value) {
			super();
			this.key = key;
			this.value = value;
		}
	}

	public BasicHashMap(int capacity) {
		bucketarray = new LinkedList[capacity];
		this.capacity = capacity;
		this.size = 0;

		for (int i = 0; i < bucketarray.length; i++) {
			bucketarray[i] = new LinkedList<>();
		}
	}

	public int get(int key) {
		int hashVal = hash(key);
		LinkedList<Node> list = bucketarray[hashVal];

		Iterator<Node> iter = list.iterator();

		while (iter.hasNext()) {
			Node n = iter.next();
			if (key == n.key) {
				return n.value;
			}
		}
		return -1;
	}

	public void put(int key, int value) {
		if (size >= 0.8 * capacity) {
			System.out.println("capacity full .... rehashing ....");
			doubleMapAndRehash(key, value);
		}
		size++;
		int hashVal = hash(key);
		Node n = new Node(key, value);
		bucketarray[hashVal].addFirst(n);
	}

	private int hash(int key) {
		return key % capacity;

	}

	private void doubleMapAndRehash(int key, int value) {
		LinkedList<Node>[] tempArray = bucketarray;
		capacity = 2 * capacity;
		bucketarray = new LinkedList[capacity];
		size=0;
		
		for (int i = 0; i < bucketarray.length; i++) {
			bucketarray[i] = new LinkedList<>();
		}
		
		for(int i = 0; i < tempArray.length; i++) {
			LinkedList<Node> list = tempArray[i];
			Iterator<Node> iter = list.iterator();
			while(iter.hasNext()) {
				Node node = iter.next();
				int hashVal = node.key % capacity;
				bucketarray[hashVal].addFirst(new Node(node.key, node.value));
			}
		}
	}

	public static void main(String[] args) {
		BasicHashMap map = new BasicHashMap(8);
		map.put(1, 100);
		map.put(16, 200);
		map.put(3, 300);
		map.put(24, 400);
		map.put(5, 500);
		map.put(6, 7500);
		map.put(7, 8500);
		System.out.println(map);
		map.put(10, 89);
//		map.put(12, 85);
		System.out.println(map);
		System.out.println(map.get(3));
		System.out.println(map.get(24));
		System.out.println(map.get(16));
		System.out.println(map.get(234));
	}

}
