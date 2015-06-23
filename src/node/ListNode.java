package node;

public class ListNode<T> {
	public T value;
	
	public ListNode<T> next;
	
	public ListNode(T value, ListNode<T> next){
		this.value = value;
		this.next = next;
	}
	
	public ListNode<T> next(){
		return this.next;
	}
	
	public T getVal(){
		return this.value;
	}
	
	public void setNext(ListNode<T> next){
		this.next = next;
	}
	
	public String toString(){
		
		String str = "[";
		ListNode<T> ln = this;
		str = str + ln.getVal();
		while(ln.next()!=null){
			str = str + "," + ln.next().getVal().toString();
			ln = ln.next();
		}
		str = str + "]";
		return str;
	}
}
