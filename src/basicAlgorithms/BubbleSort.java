package basicAlgorithms;

import java.util.Arrays;

public class BubbleSort {
	public static void main(String[] args) {
		int[] array = { 102, 27, 101, 68, 100, 34, 20, 76, 55,0 };
		BubbleSort bs = new BubbleSort();
		bs.bubbleSort(array);
		System.out.println(Arrays.toString(array));
	}

	public void bubbleSort(int[] array) {
		for (int j = 0; j < array.length - 1; j++){
			for (int i = 1; i < array.length; i++) {
				if (array[i] < array[i - 1]) {
					int temp = array[i - 1];
					array[i - 1] = array[i];
					array[i] = temp;
				}
			}
		}
	}
}
