package basic;

/**
 * 题目：输入一个整数，求该整数的二进制表达中有多少个1。例如输入10，由于其二进制表示为1010，有两个1，因此输出2。
 * 
 * 分析：这是一道很基本的考查位运算的面试题。包括微软在内的很多公司都曾采用过这道题。
 * 
 * 一个很基本的想法是，我们先判断整数的最右边一位是不是1。接着把整数右移一位，原来处于右边第二位的数字现在被移到第一位了，再判断是不是1。这样每次移动一位，
 * 直到这个整数变成0为止。现在的问题变成怎样判断一个整数的最右边一位是不是1了。很简单，如果它和整数1作与运算。由于1除了最右边一位以外，其他所有位都为0。
 * 因此如果与运算的结果为1，表示整数的最右边一位是1，否则是0。
 * */
public class OneinInteger {
	
	public static void main(String[] args){
		OneinInteger oi = new OneinInteger();
		int n = oi.howManyOne(2);
		System.out.println(n);
	}
	
	public int howManyOne(int num){
		int i = 0;
		while(num!=0){
			i= ((num>>=1)&1) == 1? i+1:i;
		}
		return i;
	}
}
