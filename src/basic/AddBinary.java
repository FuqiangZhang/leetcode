package basic;

import struct.Stack;

/**
 * Given two binary strings, return their sum (also a binary string).
 * 
 * For example, a = "11" b = "1" Return "100".
 * 
 * ��Ŀ���룺
 * 
 * ���������������ַ������������ǵĺͣ�Ҳ��һ���������ַ������� ���磬 a = "11" b = "1" ����"100"��
 * */

public class AddBinary {
	public String soluction3(String a, String b) {
		char[] c1;
		char[] c2;
		// ��Ϊ�����ַ����ĳ��ȿ��ܲ�һ���� ���Ҵ����ʱ��Ҫ�Գ���Ϊ��׼
		if (a.length() >= b.length()) {
			c1 = a.toCharArray(); // ��������ַ��� ����ַ����� �� ���� 10001 ��� {'1','0','0','0','1'}
			c2 = b.toCharArray();
		} else {
			c1 = b.toCharArray();
			c2 = a.toCharArray();
		}

		int maxByte = c1.length;
		int minByte = c2.length;
		char[] result = new char[maxByte + 1]; // �洢������ַ����飬 ��Ϊ�п������Ҫ��һλ �� ���������1

		int jinwei = 0; // ��������   ��λ�� ����a����, ����b ���� �� �ַ� ��� ����
		int int_c1 = 0; //
		int int_c2 = 0;

		while (maxByte > 0 && minByte > 0) { // ��һ��ѭ���� �� ���� �� �̵��Ǹ���ͷ 
			maxByte--;
			minByte--;

			int_c1 = Integer.valueOf(c1[maxByte] + ""); // �ַ� -> ����
			int_c2 = Integer.valueOf(c2[minByte] + "");

			result[maxByte + 1] = ((int_c1 ^ int_c2 ^ jinwei) + "").charAt(0);  // ������ �ֻ� ���� ������Ӧλ�� ������ ����ֱ�Ӵ���һ�±���ַ�
			
			int te = int_c1 + int_c2 + jinwei;//�ж��Ƿ���Ҫ��λ   ��������� ���ڵ��ڶ�����Ҫ��λ
			if (te >= 2) {
				jinwei = 1;
			} else {
				jinwei = 0;
			}
		}
		while (maxByte > 0) { // �ڶ���ѭ�� ������ʣ�µĲ���
			maxByte--;
			int_c1 = Integer.valueOf(c1[maxByte] + "");   //ͬ��  ��� ����
			
			result[maxByte + 1] = ((int_c1 ^ jinwei) + "").charAt(0);// ������ �ֻ� ���� ������Ӧλ�� ������ ����ֱ�Ӵ���һ�±���ַ�  ��Ϊ �̵������Ѿ�û��
			
			jinwei = int_c1 & jinwei; // ������  ���� ���� �Ƿ��λ
		}
		
		//ѭ������֮�� Ҫ�ж������Ƿ���Ҫ��λ
		if (jinwei == 1) {
			result[maxByte] = '1';
		} else {
			result[maxByte] = '0';
		}
		System.out.println(new String(result));
		return new String(result);
	}

	// �� �ַ�����
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

	// �������ַ��� ת ʮ����
	public int strtoInt(String a) {
		int int_a = 0;
		for (int i = 0; i < a.length(); i++) {
			int c = Integer.valueOf(a.charAt(i) + "");
			int_a = (int) (int_a + c * (Math.pow(2, a.length() - i - 1)));
		}
		return int_a;
	}

	// ʮ���� ת�������ַ���
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
