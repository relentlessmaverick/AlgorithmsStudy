package com.basicdatastructures;
/**
 * ListNode class
 * @author vikrantmathure
 *
 * @param <T>
 */
public class ListNode<T> {
	T val;
	ListNode<T> next;

	ListNode(T val) {
		this.val = val;
	}

	@Override
	public String toString() {
		return "ListNode [val=" + val + "]";
	}
	
}