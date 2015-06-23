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
 * 题目翻译：
 * 
 * 反转整数。 例1：X = 123，返回321 例2：X = -123，返回-321
 * 
 * 你有没有想过这些呢？ 这里有一些编码之前要问的好问题。如果你已经考虑了这些，奖励积分给你！ 如果整数的最后一位是0，应该输出什么？例如10，100的情况。
 * 你有没有注意到反转后的整数可能溢出？假设输入的是一个32位的整数，则1000000003反转后溢出。应该如何处理这种情况？
 * 抛出一个异常？不错，但如果不允许抛出异常呢？那么你必须重新设计函数（即添加一个额外的参数）。
 */

public class ReverseDigit {

	// 依赖 char[]

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

	// 猪为反转

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
