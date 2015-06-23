package basicAlgorithms;

import java.util.Vector;

import node.TreeNode;
import struct.BinSearchTree;
import struct.Queue;

/**
 * 1 procedure BFS(G,v) is 
 * 2 create a queue Q 
 * 3 create a set V 
 * 4 add v to V 
 * 5 enqueue v onto Q 
 * 6 while Q is not empty loop 
 * 7 t ¡û Q.dequeue() 
 * 8 if t is what we are looking for then 
 * 9 return t 
 * 10 end if 
 * 11 for all edges e in G.adjacentEdges(t) loop 
 * 12 u ¡û G.adjacentVertex(t,e) 
 * 13 if u is not in V then
 * 14 add u to V 
 * 15 enqueue u onto Q 
 * 16 end if 
 * 17 end loop 
 * 18 end loop 
 * 19 return none 
 * 20 end BFS
 */
public class BreadthFirstSearch {
	public void breadFS(TreeNode node){
		Queue<TreeNode> q = new Queue<TreeNode>();
		Vector<TreeNode> v = new Vector<TreeNode>();
		v.add(node);
		q.enqueue(node);
		while(!q.isEmpty()){
			TreeNode t = q.dequeue(null);
			System.out.println(t.getVal());
			if(!v.contains(t.getLeft())&& t.getLeft()!=null){
				v.add(t.getLeft());
				q.enqueue(t.getLeft());
			}
			if(!v.contains(t.getRight())&& t.getRight()!=null){
				v.add(t.getRight());
				q.enqueue(t.getRight());
			}
		}
	}
	public static void main(String[] args){
		TreeNode tn_1 = new TreeNode(3);
		TreeNode tn_2 = new TreeNode(4);
		TreeNode tn_3 = new TreeNode(2);
		TreeNode root = new TreeNode(1);
		root.setLeft(tn_3);
		tn_3.setLeft(tn_1);
		tn_3.setRight(tn_2);
		BreadthFirstSearch bfs = new BreadthFirstSearch();
		bfs.breadFS(root);
	}
}
