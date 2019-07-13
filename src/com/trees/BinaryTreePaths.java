package com.trees;

import java.util.LinkedList;
import java.util.List;

/**
 * Given a binary tree, return all root-to-leaf paths
 * 
 * @author vikrantmathure
 *
 */

public class BinaryTreePaths {
	/**
	 * Helper method to build all the root-to-leaf paths
	 * @param path
	 * @param root
	 * @param paths
	 */
	public static void build_paths(String path, TreeNode root, LinkedList<String> paths) {
		if (root != null) {
			path = path + Integer.toString(root.val);
			if (root.left == null && root.right == null) {
				paths.add(path);
			} else {
				path+= "->";
				build_paths(path, root.left, paths);
				build_paths(path, root.right, paths);
			}
		}
	}

	public static List<String> binaryTreePaths(TreeNode root) {
		List<String> paths = new LinkedList<String>();
		build_paths("", root, new LinkedList<String>());
		return paths;
	}

	public static void main(String args[]) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(10);
		root.right = new TreeNode(15);
		//		root.left.left = new TreeNode(20);
		//		root.left.right = new TreeNode(25);
		//		root.right.left = new TreeNode(30);
		//		root.right.right = new TreeNode(35);
		System.out.println(binaryTreePaths(root));

	}
}
