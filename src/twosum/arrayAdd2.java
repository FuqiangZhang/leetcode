package twosum;

import java.util.Arrays;

public class arrayAdd2 {

	public static void main(String arg[]) {
		int[] input = { 1, 2, 3, 6, 8, 11 };
		int target = 5;

		arrayAdd2 object = new arrayAdd2();
		int result[] = object.add(input, target);

		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}

	public int[] add(int[] input, int target) {
		int[] result = new int[2];

		int[] input2 = input.clone();
		Arrays.sort(input2);

		int i = 0;
		int j = input2.length-1;
		while (i < j) {
			if (input2[i] + input2[j] < target) {
				i++;
			} else if (input2[i] + input2[j] > target) {
				j--;
			} else if (input2[i] + input2[j] == target) {
				break;
			}
		}
		System.out.println(i+"/"+j);
		
		
		arrayAdd2 object = new arrayAdd2();
		int arrayA = object.returnIndex(input, input2[i]);
		int arrayB = object.returnIndex(input, input2[j]);
		
		if (arrayA<arrayB){
			result[0]= arrayA;
			result[1]= arrayB;
		}else{
			result[1]= arrayA;
			result[0]= arrayB;
		}

		return result;
	}

	public int returnIndex(int[] input, int num) {
		int i = 0;

		for (i = 0; i < input.length && num != input[i]; i++) {
		}

		return i;
	}

}