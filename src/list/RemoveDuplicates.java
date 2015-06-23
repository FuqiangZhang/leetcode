package list;

import node.ListNode;


/**
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * */


public class RemoveDuplicates {
	
	public static void main(String[] args){
		RemoveDuplicates rd = new RemoveDuplicates();
		ListNode<Integer> last = new ListNode<Integer>(1, null);
		ListNode<Integer> node4 = new ListNode<Integer>(1, last);
		ListNode<Integer> node3 = new ListNode<Integer>(1, node4);
		ListNode<Integer> node2 = new ListNode<Integer>(1, node3);
		ListNode<Integer> root = new ListNode<Integer>(1, node2);
		System.out.println(root.toString());
		rd.removeDuplicates(root);
		System.out.println(root.toString());
	}
	
	public void removeDuplicates(ListNode<Integer> node){
		ListNode<Integer> cur = node;
		
		while(cur!=null &&cur.next!=null){
				if(cur.next.value == cur.value){
					if(cur.next.next!=null)
						cur.next = cur.next.next;
					else
						cur.next = null;
				}else{
					cur = cur.next;
				}
		}
	}
	
}
