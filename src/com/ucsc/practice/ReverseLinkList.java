package com.ucsc.practice;

/**
 * This class reverses a given LinkedList
 * @author vikrantmathure
 *
 */
public class ReverseLinkList {
	class Node{
		Node next;
	}
	
	// Demo Example
	// 1->2->3->4
	// 2->1
	// 3->2->1
	// 4->3->2->1
	
	public Node reverseLinkedList(Node head){
		
		Node p1 = head;
		Node p2 = head.next;
		head.next = null;
		
		while(p1!=null && p2!=null){
			Node tempLLNode = p2.next;
			p2.next = p1;
			p1 = p2;
			p2 = tempLLNode;
		}
		return p1;
	}
}
