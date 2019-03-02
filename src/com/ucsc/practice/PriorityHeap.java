package com.ucsc.practice;

import java.util.Arrays;

/**
 * Node class for individual node in a Heap
 * 
 * @author vikrantmathure
 *
 */
class HeapNode {
	private int iData;

	public HeapNode(int key) {
		iData = key;
	}

	public int getKey() {
		return iData;
	}

	@Override
	public String toString() {
		return "HeapNode [iData=" + iData + "]";
	}
}

/**
 * This is priority heap implementation based on an array
 * The class implements typical operations of a Priority Heap
 * @author vikrantmathure
 *
 */
public class PriorityHeap {

	private int maxSize;
	private int currentSize = 0;
	private HeapNode[] heapArray;
	
	public PriorityHeap(int maxSize) {
		this.maxSize = maxSize;
		heapArray = new HeapNode[maxSize];
	}
	
	/*	Removes the highest priority node */
	public HeapNode remove() {
		HeapNode root = heapArray[0];
		heapArray[0] = heapArray[--currentSize];
		trickleDown(0);
		return root;
	}
	/* Trickles the node down the heap */
	private void trickleDown(int index) {

		HeapNode top = heapArray[index];
		int largerChildIndex;

		while (index < currentSize / 2) {

			int leftChildIndex = (2 * index) + 1;
			int rightChildIndex = leftChildIndex + 1;

			if (rightChildIndex < currentSize && // (rightChild exists?)
					heapArray[leftChildIndex].getKey() < heapArray[rightChildIndex].getKey()) {
				largerChildIndex = rightChildIndex;
			} else {
				largerChildIndex = leftChildIndex;
			}
			// top >= largerChild?
			if (top.getKey() >= heapArray[largerChildIndex].getKey()) {
				break;
			}
			heapArray[index] = heapArray[largerChildIndex]; // shift child up
			index = largerChildIndex; // go down
		}
		heapArray[index] = top; // index <- root
	}
	
	/* Inserts node into the heap */
	public boolean insert(int key) {
		if (currentSize == maxSize) {
			return false;
		}
		HeapNode node = new HeapNode(key);
		heapArray[currentSize] = node;
		trickleUp(currentSize++);
		return true;
	}

	/* Trickles the node to the top */
	private void trickleUp(int index) {
		int parent = (index - 1) / 2;
		HeapNode bottom = heapArray[index];
		while (index > 0 && (heapArray[parent].getKey() < bottom.getKey())) {
			heapArray[index] = heapArray[parent];
			index = parent;
			parent = (parent - 1) / 2;
		}
		heapArray[index] = bottom;
	}

	@Override
	public String toString() {
		return "PriorityHeap [heapArray=" + Arrays.toString(heapArray) + "]";
	}

	/* O(n) Solution */
	public static int findKthHighestElement(int[] nums, int k) {
		PriorityHeap priorityHeap = new PriorityHeap(nums.length);
		int result = 0;

		// build priority heap
		for (int key : nums) {
			priorityHeap.insert(key);
		}
		
		for (int i = 0; i < k; i++) {
			result = priorityHeap.remove().getKey();
		}
		return result;
	}
	
	// Driver Program
	public static void main(String[] args) {
		// int nums[] = new int[]{82,70,51,63,55,37,10,43,27,30,34};
		int nums[] = new int[] { 70, 82, 51, 63, 55, 10, 37, 43, 27, 34, 30 };
		System.out.println(findKthHighestElement(nums, 3));
	}
}
