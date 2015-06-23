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
	// o(n)方法 ， 另一种应该可以 但是目前还没想出来
	public int[] solution(int[] input) {

		int length = input.length;
		int index = 0;

		int sum = 0;	   				// 临时和
		int maxsum = 0;					// sub array 最大和

		int start = 0;					// sub array 开始
		int end = 0;					// sub array 结束

		int start_tmp = 0;				// 临时开始	

		while (input[index] < 0) {		// 从正的开始
			index++;
		}
		for (int i = index; i < length; i++) {
			sum = sum + input[i];
			if (sum > maxsum) {
				maxsum = sum;				// 当前和比maxsum 大 ， 则maxsum至为当前和， 且end 至为 i
				end = i;
				start = start_tmp;			// start 变成 start_tmp
			}
			if (sum < 0) {					//只要前面的不为负 ， 则一定要加上前面的， 为负数了， 就 sum 至0， 往后看
				sum = 0;					
				start_tmp = i + 1;			// 表示 此时的和 是从这里开始加的
			}

		}

		int[] result = new int[end - start + 1];
		System.arraycopy(input, start, result, 0, end - start + 1);
		System.out.println(maxsum);
		return result;
	}
}
