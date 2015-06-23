package basic;

/**
 * 
 * 
 * Given a sorted array and a target value, return the index if the target is
 * found. If not, return the index where it would be if it were inserted in
 * order.
 * 
 * You may assume no duplicates in the array.
 * 
 * Here are few examples. [1,3,5,6], 5 → 2 [1,3,5,6], 2 → 1 [1,3,5,6], 7 → 4
 * [1,3,5,6], 0 → 0
 * 
 * 题目翻译： 给定一个有序数组和一个目标值，如果找到目标则返回索引。如果没有，则返回把它插入时所在位置的索引。 假设数组中没有重复元素。
 * */
public class SearchInsertPosition {

	// 递归
	public int searchPosition(int[] array, int start, int end, int target) {
		if (array[(end + start) / 2] == target) {
			return (end + start) / 2;
		}
		if (end - start == 1 || end == start) {
			if (array[start] < target) {
				return start + 1;
			} else {
				return start;
			}
		}
		if (array[(end + start) / 2] > target) {
			return searchPosition(array, start, (end + start) / 2, target);
		}
		if (array[(end + start) / 2] < target) {
			return searchPosition(array, (end + start) / 2 + 1, end, target);
		}
		return -1;
	}

	// 迭代
	public int searchPost(int[] array, int target) {
		int end = array.length - 1;
		int start = 0;
		int index = 0;

		while (start <= end) {
			index = (start + end) / 2;
			if (array[index] == target)
				break;
			if (end - start == 1 || end == start) {
				if (array[start] < target) {
					index = start + 1;
				} else {
					index = start;
				}
				break;
			}
			if (array[index] > target) {
				end = index;
			}
			if (array[index] < target) {
				start = index + 1;
			}
		}

		return index;
	}

	public static void main(String[] args) {
		int[] array = { 4, 6, 7, 9, 10, 11, 13 };
		SearchInsertPosition sip = new SearchInsertPosition();
		System.out.println(sip.searchPost(array, 9));
		System.out.println(sip.searchPosition(array, 0, 6, 9));
	}
}
