package struct;

/**
 *
 * 单向链表
 * 
 * 
 * */

public class SinglyList<T> {

	private Node<T> head; // 链表的头节点
	private Node<T> tail; // 链表的尾节点
	private int size;

	/**
	 * 构造一个空链表
	 */
	public SinglyList() {
		head = tail = null;
		size = 0;
	}

	/**
	 * 链表内部的节点类
	 */
	private static class Node<T> {
		T data;// 节点的数据
		Node<T> next;// 该节点的指向下一个节点的指针

		Node(T data) {
			this.data = data;
			this.next = null;
		}

	}

	/**
	 * 插入到头部
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
	 * 插入到尾部
	 * */
	public void addTail(T element) {
		Node<T> node = new Node<T>(element);
		tail.next = node;
		tail = node;
		size++;
	}

	/**
	 * 插入，到尾部
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
	 * 插入到任意位置
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
	 * 删除某一位置的元素
	 * */

	public void removebyIndex(int index) {
		if (index < 0 || index > size) {
			return;
		}
		// 删除的是head
		if (index == 0) {
			head = head.next;
			size--;
			return;
		}

		Node<T> x = head;
		for (int i = 0; i < index - 1; i++)
			x = x.next;
		x.next = x.next.next;
		// 如果删除的是尾
		if (index == size - 1) {
			tail = x;
		}
		size--;
		System.out.println(tail.data);

	}

	/**
	 * 删除某一节点
	 * */

	public void delete(T data) {// 删除某一节点
		Node<T> curr = head, prev = null;
		boolean suc = false;// 是否删除成功标志
		while (curr != null) {
			if (curr.data.equals(data)) {
				size--;
				// 判断是什么节点
				if (curr == head) { // 如果删除的是头节点
					head = curr.next;
					suc = true;
					return;
				}
				if (curr == tail) { // 如果删除的是尾节点
					tail = prev;
					prev.next = null;
					suc = true;
					return;
				} else {// 如果删除的是中间节点（即非头节点或非尾节点）
					prev.next = curr.next;
					suc = true;
					return;
				}
			}

			prev = curr;
			curr = curr.next;
		}

		if (suc == false) {
			System.out.println('\n' + "没有这个数据");
		}

	}

	public void printLinkList() { // 打印链表
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
	 * 随机读取  返回第index个元素
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
	 * 返回头
	 * */
	
	public T getHead(){
		if(head == null)
			return null;
		return head.data;
	}
	
	/**
	 * 返回尾
	 * */
	
	public T getTail(){
		if(tail == null)
			return null;
		return tail.data;
	}
	

	/**
	 * 返回size
	 * */
	public int size() {
		return size;
	}

	/**
	 * 判断是否为空
	 * */
	public boolean isEmpty() {// 判断链表是否为空
		return this.head == null || this.tail == null;
	}

	public static void main(String[] args) {
		SinglyList<Integer> mylist = new SinglyList<Integer>();// 构造一个空链表
		mylist.insert(1);
		mylist.insert(2);
		mylist.insert(3);
		mylist.insert(4);
		mylist.printLinkList();
		mylist.removebyIndex(3);
		mylist.printLinkList();
	}

}