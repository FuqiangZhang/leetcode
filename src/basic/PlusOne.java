package basic;

import java.util.Arrays;

/**
 * Given a non-negative number represented as an array of digits, plus one to
 * the number.
 * 
 * The digits are stored such that the most significant digit is at the head of
 * the list.
 * 
 * 
 * 题目翻译：
 * 
 * 给定一个数字数组表示的非负数，对该数加1。 最高位数字存储在列表的头部。
 * 
 * */
public class PlusOne {
	public static void main(String[] args) {
		int[] input = { 9,  9, 9 };
		PlusOne po = new PlusOne();
		System.out.println(Arrays.toString(po.solution(input)));
	}

	public int[] solution(int[] input) {

		int jinwei = 1;

		for (int i = input.length - 1; i >= 0; i--) {
			if (jinwei == 1) {
				if (input[i] != 9) {
					input[i]++;
					jinwei = 0;
				} else {
					input[i] = 0;
					jinwei = 1;
				}
			}
			if (jinwei == 0) {
				break;
			}
		}
		if (input[0] == 0) {
			int[] input2 = new int[input.length+1];
			input2[0]=1;
			System.arraycopy(input, 0, input2, 1, input.length);  
			return input2;
		}
		return input;
	}
}
