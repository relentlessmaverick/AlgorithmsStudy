package com.lists;

/**
 * Merges 2 lists given the head references
 * 
 * @author vikrantmathure
 *
 */
public class Merge2Lists {
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode head = new ListNode(0);
		ListNode p = head;

		while (l1 != null || l2 != null) {

			if (l1 != null && l2 != null) {

				// if condition > OR < controls ascending || descending merge

				if (l1.val > l2.val) {
					p.next = l1;
					l1 = l1.next;
				} else {
					p.next = l2;
					l2 = l2.next;
				}
				p = p.next;

			} else if (l1 == null) {
				p.next = l2;
				break;

			} else if (l2 == null) {
				p.next = l1;
				break;
			}
		}
		return head.next;
	}

	public static void main(String args[]) {
		ListNode l3 = new ListNode(3);
		ListNode l2 = new ListNode(2);
		l3.next = l2;
		ListNode l300 = new ListNode(300);
		ListNode l200 = new ListNode(200);
		l300.next = l200;
		System.out.println(l3);
		System.out.println(l300);
		System.out.println(mergeTwoLists(l3, l300));
	}
}
