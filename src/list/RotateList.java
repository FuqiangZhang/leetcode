package list;

import node.ListNode;
import struct.List;

/**
 * 
 * Given a list, rotate the list to the right by k places, where k is
 * non-negative.
 * 
 * For example: Given 1->2->3->4->5->NULL and k = 2, return 4->5->1->2->3->NULL.
 * 
 * ��Ŀ���룺
 * 
 * ����һ������������תk��λ�ã�����k�ǷǸ��ġ� ���磺 ����1->2->3->4->5->NULL��k = 2��
 * ����4->5->1->2->3->NULL��
 * */
public class RotateList {
	public static void main(String[] args) {

		ListNode<Integer> last = new ListNode<Integer>(5, null);
		ListNode<Integer> node4 = new ListNode<Integer>(4, last);
		ListNode<Integer> node3 = new ListNode<Integer>(3, node4);
		ListNode<Integer> node2 = new ListNode<Integer>(2, node3);
		ListNode<Integer> root = new ListNode<Integer>(1, node2);
		System.out.println(root.toString());
		RotateList rl = new RotateList();
		rl.solution(root, 101);
	}

	public ListNode<Integer> solution(ListNode<Integer> head, int k) {
		ListNode<Integer> ln = head;

		ListNode<Integer> head_result = head;
		ListNode<?> end_result = null;

		if (head == null) {
			return head;
		}

		int index = 1;
		while (ln.next() != null) {
			ln = ln.next();
			index++;

		}

		ln.setNext(head); // ���һ����
		k = k % index;
		for (int i = 0; i < index - k; i++) {
			ln = ln.next();
		}
		head_result = ln.next();
		ln.setNext(null);
		System.out.println(head_result.toString());
		return head_result;
	}
}
