package com.basicdatastructures;
/**
 * Node class
 * @author vikrantmathure
 *
 */
public class Node {
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
