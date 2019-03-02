package com.ucsc.practice;

/**
 * This is the class representing individual nodes in binary search tree
 * @author vikrantmathure
 *
 */
public class Node {
	int data;
	Node left;
	Node right;

	public Node(int data) {
		this.data = data;
		left = null;
		right = null;
	}
}

