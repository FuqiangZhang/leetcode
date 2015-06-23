package basic;

import java.util.Arrays;

/**
 * Given an array and a value, remove all instances of that value in place and
 * return the new length.
 * 
 * The order of elements can be changed. It doesn't matter what you leave beyond
 * the new length.
 * 
 * 题目翻译： 给定一个数组和一个值，就地删除该值的所有实例，并返回新的长度。 元素的顺序是可以改变的。除了新的长度外，留下啥都不要紧。
 */
public class RemoveElement {

	public int removeElement(int[] array, int num) {
		int index = 0;
		for (int number : array) {
			if (number != num) {
				array[index] = number;
				index++;
			}
		}
		return index;
	}

	public int solution1(int[] input, int value) {
		int valueLength = 0;
		for (int i = 0; i < input.length - valueLength; i++) {
			if (input[i] == value) {
				valueLength++;
				input[i] = input[input.length - valueLength];
				i--;
			}
		}
		int length = input.length - valueLength;
		System.out.println(Arrays.toString(input));
		return length;
	}

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

	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 1, 1, 4 };
		int num = 1;
		RemoveElement re = new RemoveElement();
		int length = re.removeElement(array, num);
		System.out.println(length);
	}
}
