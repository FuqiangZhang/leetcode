package basic;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Find the contiguous subarray within an array (containing at least one number)
 * which has the largest sum. For example, given the array [-2, 1, -3, 4, -1,
 * 2,1, -5, 4 ], the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 * 
 * More practice:
 * 
 * If you have figured out the O(n) solution, try coding another solution using
 * the divide and conquer approach, which is more subtle.
 * 
 */
public class MaximumSubarray {
	public static void main(String[] args) {
		int[] input = { -2, 1, -3, 4, -1, 2, 1, -5, 110 };
		MaximumSubarray ms = new MaximumSubarray();
		int[] out = ms.solution(input);
		System.out.println(Arrays.toString(out));
	}
	// o(n)���� �� ��һ��Ӧ�ÿ��� ����Ŀǰ��û�����
	public int[] solution(int[] input) {

		int length = input.length;
		int index = 0;

		int sum = 0;	   				// ��ʱ��
		int maxsum = 0;					// sub array ����

		int start = 0;					// sub array ��ʼ
		int end = 0;					// sub array ����

		int start_tmp = 0;				// ��ʱ��ʼ	

		while (input[index] < 0) {		// �����Ŀ�ʼ
			index++;
		}
		for (int i = index; i < length; i++) {
			sum = sum + input[i];
			if (sum > maxsum) {
				maxsum = sum;				// ��ǰ�ͱ�maxsum �� �� ��maxsum��Ϊ��ǰ�ͣ� ��end ��Ϊ i
				end = i;
				start = start_tmp;			// start ��� start_tmp
			}
			if (sum < 0) {					//ֻҪǰ��Ĳ�Ϊ�� �� ��һ��Ҫ����ǰ��ģ� Ϊ�����ˣ� �� sum ��0�� ����
				sum = 0;					
				start_tmp = i + 1;			// ��ʾ ��ʱ�ĺ� �Ǵ����￪ʼ�ӵ�
			}

		}

		int[] result = new int[end - start + 1];
		System.arraycopy(input, start, result, 0, end - start + 1);
		System.out.println(maxsum);
		return result;
	}
}
