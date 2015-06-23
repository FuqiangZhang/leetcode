package struct;

import java.util.LinkedList;

public class Stack<T> {
	
	public static void main(String[] args){
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		while(!stack.isEmpty()){
			System.out.println(stack.pop());
		}

	}
	
	
	 private LinkedList<T> list = new LinkedList<T>();
	 
	 public void clear(){
		 list.clear();
	 }
	 
	 public boolean isEmpty(){
		 return list.isEmpty();
	 }
	 
	 public T push(T t){
		 list.addLast(t);
		 return t;
	 }
	 
	 public T pop(){
		 if(isEmpty())
			 throw new java.util.EmptyStackException();
		 return  list.removeLast();
	 }
	 
	 public T peek(){
		 if(isEmpty())
			 throw new java.util.EmptyStackException();
		 return list.getLast();
	 }
	 
	 public String toString(){
		 return list.toString();
	 }
	 
}
