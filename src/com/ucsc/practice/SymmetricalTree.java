package com.ucsc.practice;

/**
 * This program checks recursively if a given binary tree is symmetric or not
 * 
 * Time complexity is O(n), because we traverse the entire input tree once.
 * Space complexity is O(n) in worst case,because # of recursions depend on the
 * height of the tree
 * 
 * @author vikrantmathure
 *
 */
public class SymmetricalTree {
	public boolean isSymmetric(Node root) {
		if (root == null)
			return true;
		return isSymmetric(root.left, root.right);
	}

	public boolean isSymmetric(Node lsubTree, Node rsubTree) {
		// base conditions
		if (lsubTree == null && rsubTree == null) {
			return true;
		} else if (rsubTree == null || lsubTree == null) {
			return false;
		}

		if (lsubTree.data != rsubTree.data)
			return false;

		if (!isSymmetric(lsubTree.left, rsubTree.right))
			return false;
		if (!isSymmetric(lsubTree.right, rsubTree.left))
			return false;

		return true;
	}
	
	/*
	 * Driver to test the code
	 */
	
	public static void main(String[] args) {
		SymmetricalTree symmetricalTree = new SymmetricalTree();

		Node root = new Node(1);
		root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		System.out.println(symmetricalTree.isSymmetric(root));

		Node root2 = new Node(1);
		root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(2);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(5);
		root.right.right = new Node(4);
		System.out.println(symmetricalTree.isSymmetric(root2));
	}

}
