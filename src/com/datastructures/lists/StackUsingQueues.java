package com.datastructures.lists;

import java.util.LinkedList;
import java.util.Queue;

/** Implementing Stack Using Queues */
public class StackUsingQueues {

	Queue<Integer> inQueue;
	Queue<Integer> outQueue;

	public StackUsingQueues() {
		inQueue = new LinkedList<>();
		outQueue = new LinkedList<>();
	}

	/** Pushing element onto Stack */
	public void push(int x) {
		inQueue.add(x);
	}

	/** Popping from Stack */
	public int pop() {

		while (inQueue.size() > 1) {
			outQueue.add(inQueue.remove());
		}
		int popValue = inQueue.remove();

		/** Swap references of inQueue & outQueue */
		Queue<Integer> temp;
		temp = inQueue;
		inQueue = outQueue;
		outQueue = temp;
		return popValue;
	}

	/** Peeking into Stack */
	public int top() {

		while (inQueue.size() > 1) {
			outQueue.add(inQueue.remove());
		}
		return inQueue.peek();
	}
	
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return inQueue.isEmpty() && outQueue.isEmpty();
    }
}
