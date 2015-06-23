package basic;

/**
 * Divide two integers without using multiplication, division and mod operator.
 * */
public class Divide {
	public static void main(String[] args) {
		Divide d = new Divide();
		// System.out.println(Math.abs(-2147483648));
		System.out.println(d.divide(-2147483648, -1));
	}

	public int solution(int a, int b) {
		int result = 0;
		while (a > 0 && a >= b) {
			a = a - b;
			result++;
		}
		return result;
	}

	int divide(int dividend, int divisor) {
		long a = Math.abs((long) dividend);
		long b = Math.abs((long) divisor);
		int res = 0;
		while (a >= b) {
			long t = b;
			for (int i = 1; a >= t; i <<= 1, t <<= 1) {
				a -= t;
				res += i;
			}
		}
		return ((dividend < 0) ^ (divisor < 0)) ? -res : res;
	}
}
