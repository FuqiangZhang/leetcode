package twosum;

import java.util.Arrays;

public class TwoSum {
	public static int[] soluction(int[] arry_int, int target){
		int left = 0;  //左指针
		int right = arry_int.length - 1;// 右指针
		int sum = 0; // 临时和
		int leftNum = 0; // 左边数字
		int rightNum = 0;// 右边数字
		int[] arry_int_copy = arry_int.clone(); // 备份数组
		
		int[] result = new int[2];
		
		
		Arrays.sort(arry_int);  // 原数组排序
		if(target<arry_int[0])  // 如果没有 则直接输出false
			return result;
		while(left <  right){
			sum = arry_int[left] + arry_int[right];  // 两数之和
			if(sum == target){  //找到了
				leftNum = arry_int[left];  // 得到这两个数
				rightNum = arry_int[right];
				// 从原数组中找到index
				int index = 0;
				for(index = 0 ; index < arry_int_copy.length ; index ++){
					if(leftNum == arry_int_copy[index]){
						left = index;
					}
					if(rightNum == arry_int_copy[arry_int_copy.length-1-index]){
						right = arry_int_copy.length -1 -index;
					}
				}
				result[0] = left;
				result[1] = right;
				System.out.println(left+"/"+right);
				return result ;
			}
			
			//比target 小 则 左指针 右移
			if(sum<target){
				left = left + 1;
			}
			
			//否则 右指针 左移
			if(sum > target){
				right = right - 1;
			}
		}
		return result;
	}
}
