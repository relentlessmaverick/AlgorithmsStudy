package com.lists;
/**
 * Represents Node for lists
 * @author vikrantmathure
 *
 */
public class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}

	@Override
	public String toString() {
		return "ListNode [val=" + val + ", next=" + next + "]";
	}
}
