package basic;

import struct.Stack;

/**
 * Given two binary strings, return their sum (also a binary string).
 * 
 * For example, a = "11" b = "1" Return "100".
 * 
 * 题目翻译：
 * 
 * 给定两个二进制字符串，返回它们的和（也是一个二进制字符串）。 例如， a = "11" b = "1" 返回"100"。
 * */

public class AddBinary {
	public String soluction3(String a, String b) {
		char[] c1;
		char[] c2;
		// 因为两个字符串的长度可能不一样， 而且处理的时候要以长的为基准
		if (a.length() >= b.length()) {
			c1 = a.toCharArray(); // 将输入的字符串 变成字符数组 如 输入 10001 变成 {'1','0','0','0','1'}
			c2 = b.toCharArray();
		} else {
			c1 = b.toCharArray();
			c2 = a.toCharArray();
		}

		int maxByte = c1.length;
		int minByte = c2.length;
		char[] result = new char[maxByte + 1]; // 存储结果的字符数组， 因为有可能最后要进一位 ， 所以这里加1

		int jinwei = 0; // 三个变量   进位， 数组a的数, 数组b 的数 讲 字符 变成 整形
		int int_c1 = 0; //
		int int_c2 = 0;

		while (maxByte > 0 && minByte > 0) { // 第一个循环， 从 最右 到 短的那个的头 
			maxByte--;
			minByte--;

			int_c1 = Integer.valueOf(c1[maxByte] + ""); // 字符 -> 整形
			int_c2 = Integer.valueOf(c2[minByte] + "");

			result[maxByte + 1] = ((int_c1 ^ int_c2 ^ jinwei) + "").charAt(0);  // 三个数 抑或 就是 结果相对应位数 的数， 这里直接处理一下变成字符
			
			int te = int_c1 + int_c2 + jinwei;//判断是否需要进位   三个数相加 大于等于而就是要进位
			if (te >= 2) {
				jinwei = 1;
			} else {
				jinwei = 0;
			}
		}
		while (maxByte > 0) { // 第二个循环 长数组剩下的部分
			maxByte--;
			int_c1 = Integer.valueOf(c1[maxByte] + "");   //同样  变成 整形
			
			result[maxByte + 1] = ((int_c1 ^ jinwei) + "").charAt(0);// 两个数 抑或 就是 结果相对应位数 的数， 这里直接处理一下变成字符  因为 短的数组已经没了
			
			jinwei = int_c1 & jinwei; // 两个数  相与 就是 是否进位
		}
		
		//循环完了之后 要判断整体是否需要进位
		if (jinwei == 1) {
			result[maxByte] = '1';
		} else {
			result[maxByte] = '0';
		}
		System.out.println(new String(result));
		return new String(result);
	}

	// 纯 字符处理
	public String soluction2(String a, String b) {
		char[] c1;
		char[] c2;
		if (a.length() >= b.length()) {
			c1 = a.toCharArray();
			c2 = b.toCharArray();
		} else {
			c1 = b.toCharArray();
			c2 = a.toCharArray();
		}

		int maxByte = c1.length;
		int minByte = c2.length;
		char[] result = new char[maxByte + 1];
		char jinwei = '0';
		while (maxByte > 0 && minByte > 0) {
			maxByte--;
			minByte--;

			if (c1[maxByte] == c2[minByte]) {

				result[maxByte + 1] = '0';
				if (jinwei == '1') {
					result[maxByte + 1] = '1';
				}
				if (c1[maxByte] == '0') {
					jinwei = '0';
				} else {
					jinwei = '1';
				}

			} else {
				result[maxByte + 1] = '1';
				if (jinwei == '1') {
					result[maxByte + 1] = '0';
					jinwei = '1';
				}
				System.out.println("byte" + (maxByte - 1));
			}
		}
		while (maxByte > 0) {
			maxByte--;

			if (jinwei == '0') {
				result[maxByte + 1] = c1[maxByte];
			} else {
				if (c1[maxByte] == '0') {
					result[maxByte + 1] = '1';
					jinwei = '0';
				} else {
					result[maxByte + 1] = '0';
					jinwei = '1';
				}
			}
		}
		if (jinwei == '1') {
			result[maxByte] = '1';
		} else {
			result[maxByte] = '0';
		}
		return new String(result);
	}

	public String soluction(String a, String b) {
		int int_a = 0;
		int int_b = 0;
		int result = 0;
		int_a = strtoInt(a);
		int_b = strtoInt(b);
		result = int_a + int_b;
		String str_result = dToBstr(result);
		System.out.println(str_result);
		return str_result;
	}

	// 二进制字符串 转 十进制
	public int strtoInt(String a) {
		int int_a = 0;
		for (int i = 0; i < a.length(); i++) {
			int c = Integer.valueOf(a.charAt(i) + "");
			int_a = (int) (int_a + c * (Math.pow(2, a.length() - i - 1)));
		}
		return int_a;
	}

	// 十进制 转二进制字符串
	public String dToBstr(int d) {
		Stack<Integer> stack = new Stack<Integer>();
		StringBuffer sb = new StringBuffer();
		while (d >= 2) {
			int yushu = d % 2;
			d = d / 2;
			stack.push(yushu);
		}
		stack.push(d);
		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		new AddBinary().soluction3("100", "101");
	}
}
