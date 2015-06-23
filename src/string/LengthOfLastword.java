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
 * ��Ŀ���룺 �����ַ���s���ɴ�Сд��ĸ�Ϳ��ַ�' '��ɣ��������һ�����ʵĳ��ȡ� ������һ�����ʲ����ڣ�����0��
 * ע�⣺���ʵĶ�����ֻ�����ǿո��ַ������С� ���磬 ���� s = "Hello World"�� ����5��
 * 
 * 
 * �Ӻ���ǰ����
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
