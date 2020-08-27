package com.basicdatastructures;

import java.util.Iterator;
/**
 * iterable queue with constant order operations [without Generics]
 * @author vikrantmathure
 *
 */
public class BasicQueuev2 implements Iterable{
	
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

	@Override
	public Iterator iterator() {
		return new CustomQueueIterator(this);
	}
	
	private class CustomQueueIterator implements Iterator{
		
		Node current;

		public CustomQueueIterator(BasicQueuev2 basicQueueII) {
			current = basicQueueII.head;	
		}

		@Override
		public boolean hasNext() {
			return current == null;
		}

		@Override
		public Object next() {
			Node node = current;
			current = current.next;
			return node;
		}
		
	}
	
	private static class Node {
		int val;
		Node next;

		Node(int val) {
			this.val = val;
		}

		@Override
		public String toString() {
			return "Node [val=" + val + "]";
		}
		
	}
	
	public static void main(String[] args) {
		BasicQueuev2 q = new BasicQueuev2();
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
		
		q.offer(10);
		q.offer(20);
		q.offer(30);
		q.offer(40);
		q.offer(50);
		q.offer(60);
		
		Iterator iter = q.iterator();
		while(!iter.hasNext()) {
			System.out.println(((Node)iter.next()).val);
		}
	}
}
