package string;

/**
 * 
 * Given a string s consists of upper/lower-case alphabets and empty space
 * characters ' ', return the length of last word in the string.
 * 
 * If the last word does not exist, return 0.
 * 
 * Note: A word is defined as a character sequence consists of non-space
 * characters only.
 * 
 * For example, Given s = "Hello World", return 5.
 * 
 * 题目翻译： 给定字符串s，由大小写字母和空字符' '组成，返回最后一个单词的长度。 如果最后一个单词不存在，返回0。
 * 注意：单词的定义是只包含非空格字符的序列。 例如， 给定 s = "Hello World"， 返回5。
 * 
 * 
 * 从后往前遍历
 * */
public class LengthOfLastword {

	public static void main(String[] args) {
		LengthOfLastword lol = new LengthOfLastword();
		System.out.println(lol.solution(" s a "));
	}

	public int solution(String input) {
		int length = input.length();
		if (length <= 0)
			return 0;
		int index = length - 1;

		int out = 0;
		char[] cs = input.toCharArray();

		while (cs[index] == ' ' && index > 0)
			index--;
		for (; index >= 0; index--) {
			out++;
			if (cs[index] == ' ') {
				return out - 1;
			}
		}
		//
		return out;
	}

}
