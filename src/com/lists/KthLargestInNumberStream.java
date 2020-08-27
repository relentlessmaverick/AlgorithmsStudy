package com.lists;

import java.util.PriorityQueue;

public class KthLargestInNumberStream {
	private int[] source;
	private int k;
	private PriorityQueue<Integer> pq;

	public KthLargestInNumberStream(int[] source, int k) {
		this.source = source;
		this.k = k;

		pq = new PriorityQueue<>();
		for (int i = 0; i < source.length; i++) {
			pq.offer(source[i]);
			if (pq.size() > k) {
				pq.remove();
			}
		}
	}
	
//	public PriorityQueue<Integer> getPq() {
//		return pq;
//	}

	// store num & return kth largest number
	public int add(int num) {
		pq.offer(num);
		if (pq.size() > k) {
			pq.remove();
		}
		System.out.println(pq.peek());
		return pq.peek();
	}

	public static void main(String[] args) {
		KthLargestInNumberStream kthLargest = new KthLargestInNumberStream(new int[] { 4, 5, 8, 2 }, 3);
		
//		Iterator on pq : for demo : inputs 4, 5, 8
//		Iterator<Integer> iter = kthLargest.getPq().iterator();
//		while(iter.hasNext()) {
//			System.out.println(iter.next());
//		}
		
		kthLargest.add(3);   // returns 4
		kthLargest.add(5);   // returns 5
		kthLargest.add(10);  // returns 5
		kthLargest.add(9);   // returns 8
		kthLargest.add(4);   // returns 8
	}
}
