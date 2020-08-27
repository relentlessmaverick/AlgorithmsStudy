package com.basicdatastructures;

/**
 * Stack based on a LinkedList
 * push, pop & peek are O(1) operations
 * @author vikrantmathure
 *
 */
public class BasicStack {
	private Node top;
	
	/**
	 * push x on top of the stack
	 * @param x
	 */
	public void push(int x) {
		Node newNode = new Node(x);
		
		// you can also use isEmpty()
		if (top != null) {
			newNode.next = top;
		}
		top = newNode;
	}

	/**
	 * removes topVal
	 * @return topVal
	 */
	public int pop() {
		
		if (top == null) {
			throw new IllegalStateException("Empty Stack cannot be popped");
		}
		int result = top.val;
		top = top.next;
		return result;
	}
	
	/**
	 * 
	 * @return topVal
	 */
	public int peek() {
		if (isEmpty()) {
			throw new IllegalStateException("Empty Stack cannot be peeked");
		}
		return top.val;
	}
	
	public boolean isEmpty() {
		return top == null;
	}

	public static void main(String[] args) {
		BasicStack stack = new BasicStack();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		stack.push(6);
		stack.pop();
		stack.pop();
		//System.out.println(stack.peek());
		
		while(!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
	}
}
