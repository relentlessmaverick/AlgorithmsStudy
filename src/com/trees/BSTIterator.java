package com.trees;

import java.util.ArrayList;
import java.util.List;
/**
 * This class represents iterator for binary tree; this is backed by list
 * that stores the elements of tree inorder
 * @author vikrantmathure
 *
 */
public class BSTIterator {
    TreeNode curr;
    List<Integer> list = new ArrayList<>();
    
    public BSTIterator(TreeNode root) {
        this.curr = root;
        inOrderTraverse(root,list);
    }
    
    /** @return the next smallest number */
    public int next() {
    	int prev = list.iterator().next();
    	list.remove(0);
        return prev;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return (!list.isEmpty());
    }
    
    private void inOrderTraverse(TreeNode root,List<Integer> list){
        if(root != null){
            inOrderTraverse(root.left,list);
            list.add(root.val);
            inOrderTraverse(root.right,list);
        }
    }
    
    public static void main(String[] args) {
		TreeNode root = new TreeNode(50);
		TreeNode node2 = new TreeNode(10);
		TreeNode node3 = new TreeNode(60);
		TreeNode node4 = new TreeNode(8);
		TreeNode node5 = new TreeNode(12);
		
		root.left=node2;
		root.right=node3;
		root.left.left=node4;
		root.left.right=node5;
    	BSTIterator iterator = new BSTIterator(root);
    	// System.out.println(iterator.next());
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
}