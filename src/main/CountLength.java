package main;

import java.util.Arrays;
import java.util.Stack;

public class CountLength {
	
	public int solution1(int[] input ,int value){
		int valueLength = 0;
		for(int i = 0; i <input.length-valueLength ;i++){
			if(input[i]==value){
				valueLength++;
				input[i]=input[input.length-valueLength];
				i--;
				}
		}
		int length = input.length - valueLength;
		System.out.println(Arrays.toString(input));
		return length;	
	}
	
	public int[] deleteElement(int[] input ,int index){
		input[index]=input[input.length];
		return input;
	}
	
	public int[] deleteElement2(int[] input ,int index){
		
		int[] newArray = new int[index];
		for(int i=0;i<index;i++){
			newArray[i] = input[i];
		}
		System.out.println(Arrays.toString(newArray));
		return newArray;
	}
	
	//老师的针对修改
	public int solution2(int[] input, int value) {
		int valueLength = 0;
		int index = 0;
		int length_now = input.length;

		while (index < length_now) {
			if (input[index] == value) {
				input[index] = input[length_now - 1];
				valueLength++;
				length_now--;
				index--;
			}
			index++;
		}
		int length = input.length - valueLength;
		System.out.println(Arrays.toString(input));
		return length;
	}
	
	//老师的方法
	public int removeElement(int[] array, int num) {
		int index = 0;
		for (int number : array) {
			if (number != num) {
				array[index] = number;
				index++;
			}
		}
		System.out.println(Arrays.toString(array));
		return index;
	}
	
	public static void main(String args[]){
		int[] input = {1,2,1,3,2,4,1};
		int value = 1;
		
		CountLength countLength = new CountLength();
		int length = countLength.solution1(input, value);
		System.out.println(length);
	}

	}
