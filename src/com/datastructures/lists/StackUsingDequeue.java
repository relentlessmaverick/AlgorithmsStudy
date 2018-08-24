package com.datastructures.lists;

import java.util.Deque;
import java.util.LinkedList;

public class StackUsingDequeue {
	Deque<Integer> queue;
	
	public StackUsingDequeue() {
	    queue = new LinkedList<>();
	}

	/** Push element element onto stack. */
	public void push(int x) {
	    queue.offer(x);
	}

	/** Removes the element on top of the stack */
	public int pop() {
	    return queue.pollLast();
	}

	/** Get the top element */
	public int top() {
	    return queue.peekLast();
	}

	/** Returns whether the stack is empty */
	public boolean empty() {
	    return queue.isEmpty();
	}
}
