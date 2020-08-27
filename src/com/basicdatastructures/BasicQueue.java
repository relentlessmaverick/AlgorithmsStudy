package com.basicdatastructures;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
/**
 * queue implementation with constant order operations
 * @author vikrantmathure
 *
 */
public class BasicQueue {
	private Node head;
	private Node tail;

	public void offer(int x) {
		Node newNode = new Node(x);

		if (head == null) {
			head = tail = newNode;
		} else {
			tail.next = newNode;
			tail = newNode;
		}
	}

	public int poll() {
		if (isEmpty())
			throw new IllegalStateException("Empty Queue cannot be polled");

		int val = head.val;
		head = head.next;

		return val;

	}

	public int peek() {
		if (isEmpty())
			throw new IllegalStateException("Empty Queue cannot be peeked");
		return head.val;
	}

	public boolean isEmpty() {
		return (head == null);
	}

	public static void main(String[] args) {
		BasicQueue q = new BasicQueue();
		q.offer(1);
		q.offer(2);
		q.offer(3);
		q.offer(4);
		q.offer(5);
		q.offer(6);

		System.out.println(q.peek());

		q.poll();
		q.poll();
		q.poll();
		q.poll();

		while (!q.isEmpty()) {
			System.out.println(q.poll());
		}
		
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(1);
		queue.add(2);
		queue.add(3);

		// using Iterator to iterate through Queue
		Iterator<Integer> itr = queue.iterator();

		// hasNext() returns true if the queue has more elements
		while (itr.hasNext())
		{
			// next() returns the next element in the iteration
			System.out.println(itr.next());
		}
		
		System.out.println(queue.size());
	}
}
