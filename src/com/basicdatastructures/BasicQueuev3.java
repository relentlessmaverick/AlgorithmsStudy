package com.basicdatastructures;

import java.util.Iterator;
/**
 * iterable queue with constant order operations [with Generics]
 * @author vikrantmathure
 *
 * @param <T>
 */
public class BasicQueuev3<T> implements Iterable<T> {

	private ListNode<T> head;
	private ListNode<T> tail;

	public void offer(T x) {
		ListNode<T> newNode = new ListNode<T>(x);

		if (head == null) {
			head = tail = newNode;
		} else {
			tail.next = newNode;
			tail = newNode;
		}
	}

	public T poll() {
		if (isEmpty())
			throw new IllegalStateException("Empty Queue cannot be polled");

		T val = head.val;
		head = head.next;

		return val;

	}

	public T peek() {
		if (isEmpty())
			throw new IllegalStateException("Empty Queue cannot be peeked");
		return head.val;
	}

	public boolean isEmpty() {
		return (head == null);
	}

	// return Head
	public ListNode<T> getHead() {
		return head;
	}
	
	/**
	 * driver
	 * @param args
	 */
	public static void main(String[] args) {
		BasicQueuev3<Integer> q = new BasicQueuev3<>();
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

		BasicQueuev3<String> stringQueue = new BasicQueuev3<>();
		stringQueue.offer("Summer");
		stringQueue.offer("Johnson");
		stringQueue.offer("Spring");
		stringQueue.offer("Taylor");

		Iterator<String> iter = stringQueue.iterator();
		while (!iter.hasNext()) {
			System.out.println(iter.next());
		}

		BasicQueuev3<Double> doubleQueue = new BasicQueuev3<>();
		doubleQueue.offer(34.56);
		doubleQueue.offer(33.56);
		doubleQueue.offer(31.56);
		doubleQueue.offer(32.56);

		//TODO:why not working
//		for(Double d : doubleQueue) {
//			System.out.println(d);
//		}
		
		Iterator<Double> iter1 = doubleQueue.iterator();
		while (!iter1.hasNext()) {
			System.out.println(iter1.next());
		}
	}

	//	@Override
	//	public Iterator<T> iterator() {
	//		
	//		return new CustomQueueComparator<T>(this);
	//	}
	//	
	//	private static class CustomQueueComparator<T> implements Iterator<T>{
	//		ListNode<T> current;
	//		
	//		public CustomQueueComparator(BasicQueuev3<T> basicQueuev3) {
	//			current = basicQueuev3.getHead();
	//		}
	//
	//		@Override
	//		public boolean hasNext() {
	//			return current == null;
	//		}
	//
	//		@Override
	//		public T next() {
	//			ListNode<T> node = current;
	//			current = current.next;
	//			return node.val;
	//		}
	//		
	//	}

	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			ListNode<T> current;
			// anonymous class can only have a default constructor; hence, using static initializer
			{
				current = head;
			}

			@Override
			public boolean hasNext() {
				return current == null;
			}

			@Override
			public T next() {
				ListNode<T> node = current;
				current = current.next;
				return node.val;
			}
		};
	}

}
