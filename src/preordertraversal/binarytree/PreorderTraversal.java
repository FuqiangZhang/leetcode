package preordertraversal.binarytree;

import java.util.ArrayList;

import struct.Stack;
import node.TreeNode;

public class PreorderTraversal {
//¶þ²æÊ÷ÏÈÐò±éÀú
	public static void main(String[] args) {
		TreeNode tn_1 = new TreeNode(3);
		TreeNode tn_2 = new TreeNode(4);
		TreeNode tn_3 = new TreeNode(2);
		TreeNode root = new TreeNode(1);
		root.setLeft(tn_3);
		tn_3.setLeft(tn_1);
		tn_3.setRight(tn_2);
		
		
		PreorderTraversal pt = new PreorderTraversal();
		ArrayList result = pt.preOrder(root);
		System.out.println(result.toString());
	}

	//
	public ArrayList<Integer> preorderTraversal(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<Integer>();

		if (root != null) {
			result.addAll(preorderTraversal(root.getLeft()));
			result.add(root.getVal());
			result.addAll(preorderTraversal(root.getRight()));
		}

		return result;
	}

	public ArrayList<Integer> preOrder(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		Stack<TreeNode> nodeStack = new Stack<TreeNode>();
		nodeStack.push(root);
		while (!nodeStack.isEmpty()) {
			TreeNode node = nodeStack.pop();
			result.add(node.getVal());

			if (node.getRight() != null) {
				nodeStack.push(node.getRight());
			}

			if (node.getLeft() != null) {
				nodeStack.push(node.getLeft());
			}
		}

		return result;
	}
}
