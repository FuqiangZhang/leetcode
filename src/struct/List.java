package struct;

import node.ListNode;

public class List<T> {

	private ListNode<T> lastNode;
	private ListNode<T> readNode;
	private ListNode<T> firstNode;

	public List() {

	}

	public void add(T value) {
		ListNode<T> node = new ListNode<T>(value, null);
		if (this.lastNode == null) {
			this.lastNode = node;
			firstNode = node;
		} else {
			this.lastNode.setNext(node);
			this.lastNode = node;
		}
	}

	public T next() {
		if (readNode == null) {
			readNode = firstNode;
			return readNode.getVal();
		}
		if (readNode.next() != null) {
			T result = readNode.next().getVal();
			readNode = readNode.next();
			return result;
		}
		return null;
	}

	public static void main(String[] args) {
		List list = new List();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(3);
		list.add(3);
		list.add(3);
		Integer i;
		while ((i = (Integer) list.next()) != null) {
			System.out.println(i);
		}
	}

}