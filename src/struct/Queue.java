package struct;

import java.util.LinkedList;

public class Queue<T> {
	private LinkedList<T> list = new LinkedList<T>();
	
	public void clear(){
		list.clear();
	}
	
	public boolean isEmpty(){
		return list.isEmpty();
	}
	
	public void enqueue(T t){
		list.addLast(t);
	}
	
	public T dequeue(T t){
		if(isEmpty()){
			throw new java.util.EmptyStackException();
		}
		return list.removeFirst();
	}
	
	public T firstElement(){
		if(isEmpty()){
			throw new java.util.EmptyStackException();
		}
		return list.getFirst();
	}
	
	public String toString(){
		return list.toString();
	}
}
