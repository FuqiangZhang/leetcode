package basicAlgorithms;

import java.util.Arrays;

public class SelectionSort {
	
	public static void main(String[] args){
		SelectionSort ss = new SelectionSort();
		int[] array = {102, 27, 101, 68, 100, 34, 20, 76, 55,0};
		ss.selectionSort(array);
		System.out.println(Arrays.toString(array));
	}
	
	public void selectionSort(int[] array){
		int minSelected = 0;
		int index = 0;
		for(int i = 0;i < array.length-1;i++){
			minSelected = array[i];
			index = i;
			for(int j = i+1;j<array.length;j++){
				if(array[index]>array[j]){
					index = j;
				}
			}
			minSelected = array[index];
			array[index] = array[i];
			array[i] = minSelected;
		}
	}
}
