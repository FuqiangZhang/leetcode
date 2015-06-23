package basic;

/**
 * 
 * Implement atoi to convert a string to an integer.
 * 
 * Hint: Carefully consider all possible input cases. If you want a challenge,
 * please do not see below and ask yourself what are the possible input cases.
 * 
 * Notes: It is intended for this problem to be specified vaguely (ie, no given
 * input specs). You are responsible to gather all the input requirements up
 * front.
 * 
 * Requirements for atoi: The function first discards as many whitespace
 * characters as necessary until the first non-whitespace character is found.
 * Then, starting from this character, takes an optional initial plus or minus
 * sign followed by as many numerical digits as possible, and interprets them as
 * a numerical value.
 * 
 * The string can contain additional characters after those that form the
 * integral number, which are ignored and have no effect on the behavior of this
 * function.
 * 
 * If the first sequence of non-whitespace characters in str is not a valid
 * integral number, or if no such sequence exists because either str is empty or
 * it contains only whitespace characters, no conversion is performed.
 * 
 * If no valid conversion could be performed, a zero value is returned. If the
 * correct value is out of the range of representable values, INT_MAX
 * (2147483647) or INT_MIN (-2147483648) is returned.
 * 
 * ��Ŀ���룺
 * 
 * ʵ��atoi�����ַ���ת��Ϊ������ ��ʾ����ϸ�������п��ܵ�����������������Ҫ��ս���벻Ҫ�����棬�����Լ�����Щ���ܵ����������
 * 
 * ע�������������ģ��˵������û�и�������˵�������㸺��Ԥ���ռ����е���������
 * 
 * atoi������ �ú������ȶ��������ܶ�Ŀհף�whitespace
 * ���ַ�ֱ������һ���ǿհ��ַ���������ַ���ʼ����һ����ѡ�ĳ�ʼ�ӺŻ���ţ������Ǿ����ܶ�����֣������ǵ�����ֵ���͡�
 * ���ַ������γ��������ַ�������԰��������ַ������ǻᱻ���ԣ��������������Ϊû��Ӱ�졣
 * ���str�еĵ�һ���ǿհ��ַ����в���һ����Ч������������������������в����ڣ�str�ǿյĻ�ֻ�����հ��ַ�������ִ���κ�ת����
 * ���û��ִ���κ���Ч��ת��
 * ���򷵻�0�������ȷ��ֵ�����˿ɱ�ʾ��ֵ�ķ�Χ������INT_MAX��2147483647����INT_MIN��-2147483648����
 */

public class StringToInteger {
	public int solution(String str) {
		char[] array = str.toCharArray();
		int result = 0;
		int signal = 1;

		int INT_MAX = Integer.MAX_VALUE;
		int INT_MIN = Integer.MIN_VALUE;

		if (array.length == 0) {
			return 0;
		}

		for (char c : array) {

			if (c == ' ') {
				continue;
			}

			if (c == '-') {
				signal = -1;
			}

			if (c >= '0' && c <= '9') {
				if (result > INT_MAX / 10 || c - '0' > INT_MAX - result * 10) {
					return signal == -1 ? INT_MIN : INT_MAX;
				}
				result = result * 10 + (int) c - 48;
			} else {
				break;
			}
		}
		return result * signal;
	}

	public static void main(String[] args) {
		StringToInteger sti = new StringToInteger();
		int result = sti.solution("999.666");
		System.out.println(result);
	}
}
