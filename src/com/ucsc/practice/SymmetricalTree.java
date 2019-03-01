package com.ucsc.practice;

public class SymmetricalTree {
	public boolean isSymmetric(Node root) {
		if (root == null)
			return true;
		return isSymmetric(root.left, root.right);
	}
	 
	public boolean isSymmetric(Node l, Node r) {
		// base conditions
		if (l == null && r == null) {
			return true;
		} else if (r == null || l == null) {
			return false;
		}
	 
		if (l.data != r.data)
			return false;
	 
		if (!isSymmetric(l.left, r.right))
			return false;
		if (!isSymmetric(l.right, r.left))
			return false;
	 
		return true;
	}
	
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
