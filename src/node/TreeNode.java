package node;

public class TreeNode {
	private int val;
	private TreeNode left;
	private TreeNode right;

	public TreeNode(int x) {
		val = x;
	}
	
	public int getVal(){
		return this.val;
	}
	
	public void setVal(int val){
		this.val = val;
	}
	
	public TreeNode getLeft(){
		return this.left;
	}
	
	public TreeNode getRight(){
		return this.right;
	}
	
	public void setLeft(TreeNode left){
		this.left = left;
	}
	
	public void setRight(TreeNode right){
		this.right = right;
	}
}