package list;

import node.ListNode;

/**
 * 
 * Merge two sorted linked lists and return it as a new list. The new list
 * should be made by splicing together the nodes of the first two lists.
 * */
public class MergeTwoSortedList {

	public static void main(String args[]) {
		ListNode<Integer> last = new ListNode<Integer>(8, null);
		ListNode<Integer> node4 = new ListNode<Integer>(6, last);
		ListNode<Integer> node3 = new ListNode<Integer>(5, node4);
		ListNode<Integer> node2 = new ListNode<Integer>(3, node3);
		ListNode<Integer> root = new ListNode<Integer>(1, node2);
		// rd.removeDuplicates(root);
		// System.out.println(root=root.next);
		
		ListNode<Integer> lastb = new ListNode<Integer>(7, null);
		ListNode<Integer> node4b = new ListNode<Integer>(4, lastb);
		ListNode<Integer> node3b = new ListNode<Integer>(3, node4b);
		ListNode<Integer> node2b = new ListNode<Integer>(2, node3b);
		ListNode<Integer> rootb = new ListNode<Integer>(1, node2b);
		MergeTwoSortedList mts = new MergeTwoSortedList();
		System.out.println(mts.soluction(root, rootb));
		

	}

	public ListNode<Integer> soluction(ListNode<Integer> a, ListNode<Integer> b) {
		ListNode<Integer> cur;
		ListNode<Integer> root;
		if (a == null)
			return b;
		if (b == null)
			return a;
//		if (a.value < b.value) {
//			root = cur = a;
//			a = a.next;
//		} else {
//			root = cur = b;
//			b = b.next;
//		}

		root = new ListNode<Integer>(0, null);
		cur = root;
		while (a != null && b != null) {
			if (a.value < b.value) {
				cur.next = a;
				a = a.next;
			} else {
				cur.next = b;
				b = b.next;
			}
			cur = cur.next;
		}

		if (a != null) {
			cur.next = a;
		}
		if (b != null) {
			cur.next = b;
		}
		return root.next;
	}
}
