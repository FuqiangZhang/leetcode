package list;

import node.ListNode;

public class RemoveNthList {

	public static void main(String[] args) {
		RemoveNthList rn = new RemoveNthList();

		ListNode<Integer> last = new ListNode<Integer>(5, null);
		ListNode<Integer> node4 = new ListNode<Integer>(4, last);
		ListNode<Integer> node3 = new ListNode<Integer>(3, node4);
		ListNode<Integer> node2 = new ListNode<Integer>(2, node3);
		ListNode<Integer> root = new ListNode<Integer>(1, node2);
		System.out.println(root.toString());
		System.out.println(rn.solution(root, 3).toString());
	}

	public ListNode<Integer> solution(ListNode<Integer> listnode, int n) {

		ListNode<Integer> lnSecond = listnode;
		ListNode<Integer> lnFirst = listnode;
		for (int i = 0; i < n; i++) {
			lnSecond = lnSecond.next();
		}
		if(n == 0){
			return listnode;
		}
		if (lnSecond == null) {
			System.out.println(listnode.next().getVal());
			return listnode.next();
			
		} else {
			while (lnSecond.next() != null) {
				lnSecond = lnSecond.next();
				lnFirst = lnFirst.next();
			}
			lnFirst.setNext(lnFirst.next().next());
			return listnode;
		}

	}
}
