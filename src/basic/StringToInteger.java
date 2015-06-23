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
 * 题目翻译：
 * 
 * 实现atoi，将字符串转换为整数。 提示：仔细考虑所有可能的输入情况。如果你想要挑战，请不要看下面，并问自己有哪些可能的输入情况。
 * 
 * 注：这个问题有意模糊说明（即没有给定输入说明）。你负责预先收集所有的输入需求。
 * 
 * atoi的需求： 该函数首先丢弃尽可能多的空白（whitespace
 * ）字符直到遇到一个非空白字符。从这个字符开始，有一个可选的初始加号或减号，后面是尽可能多的数字，把它们当成数值解释。
 * 该字符串在形成整数的字符后面可以包含额外字符，它们会被忽略，对这个函数的行为没有影响。
 * 如果str中的第一个非空白字符序列不是一个有效的整数，或者如果这样的序列不存在（str是空的或只包含空白字符），不执行任何转换。
 * 如果没有执行任何有效的转换
 * ，则返回0。如果正确的值超出了可表示的值的范围，返回INT_MAX（2147483647）或INT_MIN（-2147483648）。
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
