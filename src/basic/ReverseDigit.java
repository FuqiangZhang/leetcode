package basic;

/**
 * Reverse digits of an integer.
 * 
 * Example1: x = 123, return 321 Example2: x = -123, return -321
 * 
 * Have you thought about this? Here are some good questions to ask before
 * coding. Bonus points for you if you have already thought through this!
 * 
 * If the integer's last digit is 0, what should the output be? ie, cases such
 * as 10, 100.
 * 
 * Did you notice that the reversed integer might overflow? Assume the input is
 * a 32-bit integer, then the reverse of 1000000003 overflows. How should you
 * handle such cases?
 * 
 * Throw an exception? Good, but what if throwing an exception is not an option?
 * You would then have to re-design the function (ie, add an extra parameter).
 * 
 * ��Ŀ���룺
 * 
 * ��ת������ ��1��X = 123������321 ��2��X = -123������-321
 * 
 * ����û�������Щ�أ� ������һЩ����֮ǰҪ�ʵĺ����⡣������Ѿ���������Щ���������ָ��㣡 ������������һλ��0��Ӧ�����ʲô������10��100�������
 * ����û��ע�⵽��ת���������������������������һ��32λ����������1000000003��ת�������Ӧ����δ������������
 * �׳�һ���쳣������������������׳��쳣�أ���ô�����������ƺ����������һ������Ĳ�������
 */

public class ReverseDigit {

	// ���� char[]

	public int solution(int input) {
		int output = 0;
		char[] array = ((int) input + "").toCharArray();
		char[] char_result = new char[array.length];
		for (int i = 0; i < array.length; i++) {
			char_result[array.length - 1 - i] = array[i];
		}
		System.out.println(new String(char_result));
		int index = 0;
		while (char_result[index] == '0') {
			index++;
		}
		StringToInteger sti = new StringToInteger();
		output = sti.solution(new String(char_result, index, char_result.length
				- index));
		return output;
	}

	// ��Ϊ��ת

	public int solution2(int input) {

		int output = 0;
		int digit_last = 0;
		int signal = 1;
		if (input < 0) {
			input = -input;
			signal = -1;
		}

		while (input > 0) {
			digit_last = input - input / 10 * 10;
			input = input / 10;
			output = output * 10 + digit_last;
		}
		output = output * signal;
		
		return output;
	}

	public static void main(String[] args) {
		ReverseDigit rd = new ReverseDigit();
		int output = rd.solution2(1534236469);
		System.out.println(output);
	}

}
