package com.trees;

/**
 * Checks if a binary tree is symmetric or not, whether the tree is mirror
 * image of itself
 * 
 * Time complexity is O(n), because we traverse the entire input tree once.
 * n is the total number of nodes in the tree.
 * 
 * Space complexity is O(n) : The number of recursive calls is bound by the height of the tree. 
 * In the worst case, the tree is linear and the height is in O(n). 
 * Therefore, space complexity due to recursive calls on the stack is O(n)
 * in the worst case.
 * 
 * @author vikrantmathure
 *
 */
public class IsSymmetric {

	public boolean isSymmetric(Node root) {
		if (root == null)
			return true;
		else
			return isSymmetric(root.left, root.right);
	}
	
	/**
	 * Using Recursive Approach
	 * @param Node p
	 * @param Node q
	 * @return boolean result
	 */
	private boolean isSymmetric(Node p, Node q) {
		
		// if both nodes are null, the tree is considered as symmetric
		if (p == null && q == null)
			return true;
		if (p == null || q == null)
			return false;
		
		// both values must be equal for the tree to be symmetric
		if (p.data != q.data)
			return false;
		else
			return isSymmetric(p.left, q.right) && isSymmetric(p.right, q.left);
	}
}
