package basicAlgorithms;

import java.util.Arrays;
/**
 * o(n2)
 * 
 * */
public class InsertSort {
	public static void main(String args[]){
		int[] array = {27,68,34,20,76,55};
		InsertSort is = new InsertSort();
		is.insertSort(array);
		System.out.println(Arrays.toString(array));
	}
	
	public void insertSort(int[] array){
		int temp = 0;
		for(int i = 1;i<array.length;i++){
			if(array[i]<array[i-1]){
				temp = array[i];
				array[i] = array[i-1];
				int insertPosition = 0;
				for(int j = i-2;j>=0;j--){
					if(array[j]>temp){
						array[j+1] = array[j];
					}else{
						insertPosition = j + 1;
						break;
					}
				}
				array[insertPosition] = temp;
			}
		}
	}
}
