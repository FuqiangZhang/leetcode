package struct;

import java.util.Vector;

import node.TreeNode;

/**
 * 
 * Binary search tree (BST) is a node-based binary tree data structure which has
 * the following properties:
 * 
 * The left subtree of a node contains only nodes with keys less than the node's
 * key. The right subtree of a node contains only nodes with keys greater than
 * the node's key. Both the left and right subtrees must also be binary search
 * trees. From the above properties, it naturally follows that each node (item
 * in the tree) has a distinct key. Generally, the information represented by
 * each node is an Object element. However, for sequencing purposes, nodes are
 * compared according to their keys rather than any part of their associated
 * records.
 * 
 * The major advantage of binary search trees over other data structures is that
 * the related sorting algorithms and search algorithms such as in-order
 * traversal can be very efficient.
 * */

/**
 * 创建（插入）, 查找, 遍历 删除
 * 
 * 最大最小节点
 * 
 * */
public class BinSearchTree {
	public class Node {
		int value;
		Node left;
		Node right;

		Node(int value) {
			this.value = value;
			left = null;
			right = null;
		}
	}

	public BinSearchTree() {

	}

	/**
	 * 由一个数组构造BST
	 * */
	public BinSearchTree(int[] array) {
		for (int value : array) {
			insert(value);
		}
	}

	private Node root;

	/**
	 * 全部由根部开始插入
	 * */
	public void insert(int value) {
		root = insert(root, value);
	}

	/**
	 * 插入，根据节点值，判断插入到左边还是右边
	 * */
	public Node insert(Node node, int value) {
		if (node == null) {
			node = new Node(value);
		} else {
			if (value < node.value) {
				node.left = insert(node.left, value);
			} else {
				node.right = insert(node.right, value);
			}
		}
		return node;
	}

	/**
	 * 打印结果
	 * */
	public void visit(Node node) {
		if (node == null) {
			return;
		} else {
			System.out.println(node.value);
		}

	}

	/**
	 * 中序遍历
	 * */
	public void in_order_traves(Node node) {
		if (node == null) {
			return;
		} else {
			in_order_traves(node.left);
			visit(node);
			in_order_traves(node.right);
		}
	}

	/**
	 * 查找，其实就是二分查找
	 * */
	public Node bst_search(Node root, int key) {
		Node found = null;
		if (root == null) {
			found = null;
		} else {
			if (root.value == key) {
				found = root;
			}
			if (root.value < key) {
				found = bst_search(root.right, key);
			}
			if (root.value > key) {
				found = bst_search(root.left, key);
			}
		}

		return found;
	}

	/**
	 * 最大
	 * */
	public Node getMax(Node node) {
		Node cur = node;
		while (cur.right != null) {
			cur = cur.right;
		}
		return cur;
	}

	/**
	 * 最小
	 * */
	public Node getMin(Node node) {
		Node cur = node;
		while (cur.left != null) {
			cur = cur.left;
		}
		return cur;
	}

	/**
	 * 删除
	 * */
	public void delectNode(Node root, int key) {
		if (root == null)
			return;
		Node found = root;
		Node parent = null;
		boolean isLeft = false; // 用于判断该节点是左还是右子节点

		// 先找到该节点及其父节点
		while (found.value != key) {
			if (found.value < key) {
				parent = found;
				found = found.right;
				isLeft = false;
			} else {
				parent = found;
				found = found.left;
				isLeft = true;
			}
		}
		if (parent == found && found.left == null && found.right == null) {
			this.root = null;
		}
		// 1.该节点为叶子节点，直接删除
		if (found.left == null && found.right == null) {
			found = null;
			if (isLeft) {
				parent.left = null;
			} else {
				parent.right = null;
			}
		} else {
			if (found.left != null && found.right != null) {
				// 2.该节点同时存在左右子树, 将found 中左子树的最大值 付给原节点,然后 删除左子树中的最大节点
				Node now = getMax(found.left);
				delectNode(root, now.value);
				found.value = now.value;
			} else {// 3.该节点只有一个子树，则将其自树接到原父节点
				if (parent != null) {

					if (isLeft) {
						if (found.left != null)
							parent.left = found.left;
						else
							parent.left = found.right;
					} else {
						if (found.left != null)
							parent.right = found.left;
						else
							parent.right = found.right;
					}
				} else {
					this.root = found.left != null ? found.left : found.right;
				}
			}

		}

	}
/**
 * 获取树的深度
 * */
	public int getDepth(Node btree) {
		int rtnleft = 1;
		int rtnright = 1;
		if (btree == null) {
			return 0;
		}
		rtnleft = getDepth(btree.left);
		rtnright = getDepth(btree.right);

		return rtnleft > rtnright ? rtnleft + 1 : rtnright + 1;
	}
// need to be improved
	public void show(Node root) {
		Queue<Node> a = new Queue<Node>();
		Queue<Node> b = new Queue<Node>();
		a.enqueue(root);

		int blank = getDepth(root);

		while (!a.isEmpty()) {
			for (int i = 0; i < blank; i++)
				System.out.print(" ");
			Node node = a.dequeue(null);
			System.out.print(node.value);
			if (node.left != null)
				b.enqueue(node.left);
			if (node.right != null)
				b.enqueue(node.right);
			System.out.print(" ");
			if (a.isEmpty())
				System.out.println();
			while (!b.isEmpty()) {
				for (int i = 0; i < blank; i++)
					System.out.print(" ");
				Node node2 = b.dequeue(null);
				System.out.print(node2.value);
				if (node2.left != null)
					a.enqueue(node2.left);
				if (node2.right != null)
					a.enqueue(node2.right);
				System.out.print(" ");
				if (b.isEmpty())
					System.out.println();
			}
		}
	}

	//BFS
	public void breadFS(Node node){
		Queue<Node> q = new Queue<Node>();
		Vector<Node> v = new Vector<Node>();
		v.add(node);
		q.enqueue(node);
		while(!q.isEmpty()){
			Node t = q.dequeue(null);
			System.out.println(t.value);
			if(!v.contains(t.left)&& t.left!=null){
				v.add(t.left);
				q.enqueue(t.left);
			}
			if(!v.contains(t.right)&& t.right!=null){
				v.add(t.right);
				q.enqueue(t.right);
			}
		}
	}

	public static void main(String[] args) {
		int arr[] = { 1, 2, 4, 3, 6, 9, 5 };
		BinSearchTree bst = new BinSearchTree(arr);
//		bst.show(bst.root);
		bst.breadFS(bst.root);
	}

}
