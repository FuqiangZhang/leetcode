package list;

import node.ListNode;
import struct.List;

public class ReverseList {
	public static void main(String[] args){
		ListNode<Integer> last = new ListNode<Integer>(5, null);
		ListNode<Integer> node4 = new ListNode<Integer>(4, last);
		ListNode<Integer> node3 = new ListNode<Integer>(3, node4);
		ListNode<Integer> node2 = new ListNode<Integer>(2, node3);
		ListNode<Integer> root = new ListNode<Integer>(1, node2);
		System.out.println(root.toString());
		ReverseList rl = new ReverseList();
		rl.reverseListIteratively(root);
		System.out.println(last.toString());
	}
	public void reverseListIteratively(ListNode<Integer> head) {
		//���ж�  Ϊ�� ���
		if (head == null || head.next() == null)
			return; 
		//�õ� �ڶ�����
		ListNode<Integer> second = head.next();
		ListNode<Integer> third = second.next();
		//һ��ָ�뽻��
		second.setNext(head); 
		//head ָ���
		head.setNext(null); 
		//�� �����
		if (third == null)
			return;
		//�Դ����󽻻�
		ListNode<Integer> now_Node = third;
		ListNode<Integer> before_Node = second;
		while (now_Node != null) {
			ListNode<Integer> next_Node = now_Node.next();
			now_Node.setNext(before_Node);
			before_Node = now_Node;
			now_Node = next_Node;
		}
	}
}
