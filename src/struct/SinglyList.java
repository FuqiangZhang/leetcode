package struct;

/**
 *
 * ��������
 * 
 * 
 * */

public class SinglyList<T> {

	private Node<T> head; // �����ͷ�ڵ�
	private Node<T> tail; // �����β�ڵ�
	private int size;

	/**
	 * ����һ��������
	 */
	public SinglyList() {
		head = tail = null;
		size = 0;
	}

	/**
	 * �����ڲ��Ľڵ���
	 */
	private static class Node<T> {
		T data;// �ڵ������
		Node<T> next;// �ýڵ��ָ����һ���ڵ��ָ��

		Node(T data) {
			this.data = data;
			this.next = null;
		}

	}

	/**
	 * ���뵽ͷ��
	 * */
	public void addHead(T element) {
		if (head == null) {
			this.head = new Node<T>(element);
		} else {
			Node<T> node = new Node<T>(element);
			node.next = head;
			head = node;
		}

		if (tail == null) {
			tail = head;
		}
		size++;
	}

	/**
	 * ���뵽β��
	 * */
	public void addTail(T element) {
		Node<T> node = new Node<T>(element);
		tail.next = node;
		tail = node;
		size++;
	}

	/**
	 * ���룬��β��
	 * */
	public void insert(T element) {

		if (this.head == null) {
			addHead(element);

		} else if (this.tail == this.head) {
			addTail(element);

		} else {
			addTail(element);
		}
	}

	/**
	 * ���뵽����λ��
	 * */
	public boolean insert(T element, int index) {
		if (index < 0 || index > size) {
			return false;
		}
		if (index == 0) {
			addHead(element);
			return true;
		}
		if (index == size) {
			addTail(element);
			return true;
		}
		Node<T> x = head;
		for (int i = 0; i < index - 1; i++)
			x = x.next;
		Node<T> nodeInsert = new Node<T>(element);
		nodeInsert.next = x.next;
		x.next = nodeInsert;
		size++;
		return true;
	}

	/**
	 * ɾ��ĳһλ�õ�Ԫ��
	 * */

	public void removebyIndex(int index) {
		if (index < 0 || index > size) {
			return;
		}
		// ɾ������head
		if (index == 0) {
			head = head.next;
			size--;
			return;
		}

		Node<T> x = head;
		for (int i = 0; i < index - 1; i++)
			x = x.next;
		x.next = x.next.next;
		// ���ɾ������β
		if (index == size - 1) {
			tail = x;
		}
		size--;
		System.out.println(tail.data);

	}

	/**
	 * ɾ��ĳһ�ڵ�
	 * */

	public void delete(T data) {// ɾ��ĳһ�ڵ�
		Node<T> curr = head, prev = null;
		boolean suc = false;// �Ƿ�ɾ���ɹ���־
		while (curr != null) {
			if (curr.data.equals(data)) {
				size--;
				// �ж���ʲô�ڵ�
				if (curr == head) { // ���ɾ������ͷ�ڵ�
					head = curr.next;
					suc = true;
					return;
				}
				if (curr == tail) { // ���ɾ������β�ڵ�
					tail = prev;
					prev.next = null;
					suc = true;
					return;
				} else {// ���ɾ�������м�ڵ㣨����ͷ�ڵ���β�ڵ㣩
					prev.next = curr.next;
					suc = true;
					return;
				}
			}

			prev = curr;
			curr = curr.next;
		}

		if (suc == false) {
			System.out.println('\n' + "û���������");
		}

	}

	public void printLinkList() { // ��ӡ����
		Node<T> curr = this.head;
		if (isEmpty()) {
			try {
				throw new Exception("linklist is empty");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		while (curr != null) {
			System.out.print(curr.data + " ");
			curr = curr.next;
		}
		System.out.println();
	}
	
	/**
	 * �����ȡ  ���ص�index��Ԫ��
	 * */
	
	public T getbyIndex(int index) {
		Node<T> cur = head;
		
		if(index<0||index>=size){
			try {
				throw new Exception("out of range");
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
		
		if(index == size-1){
			return tail.data;
		}
		for (int i = 0; i < index; i++) {
			cur = cur.next;
		}
		return cur.data;
	}
	
	/**
	 * ����ͷ
	 * */
	
	public T getHead(){
		if(head == null)
			return null;
		return head.data;
	}
	
	/**
	 * ����β
	 * */
	
	public T getTail(){
		if(tail == null)
			return null;
		return tail.data;
	}
	

	/**
	 * ����size
	 * */
	public int size() {
		return size;
	}

	/**
	 * �ж��Ƿ�Ϊ��
	 * */
	public boolean isEmpty() {// �ж������Ƿ�Ϊ��
		return this.head == null || this.tail == null;
	}

	public static void main(String[] args) {
		SinglyList<Integer> mylist = new SinglyList<Integer>();// ����һ��������
		mylist.insert(1);
		mylist.insert(2);
		mylist.insert(3);
		mylist.insert(4);
		mylist.printLinkList();
		mylist.removebyIndex(3);
		mylist.printLinkList();
	}

}