package twosum;

import java.util.Arrays;

public class TwoSum {
	public static int[] soluction(int[] arry_int, int target){
		int left = 0;  //��ָ��
		int right = arry_int.length - 1;// ��ָ��
		int sum = 0; // ��ʱ��
		int leftNum = 0; // �������
		int rightNum = 0;// �ұ�����
		int[] arry_int_copy = arry_int.clone(); // ��������
		
		int[] result = new int[2];
		
		
		Arrays.sort(arry_int);  // ԭ��������
		if(target<arry_int[0])  // ���û�� ��ֱ�����false
			return result;
		while(left <  right){
			sum = arry_int[left] + arry_int[right];  // ����֮��
			if(sum == target){  //�ҵ���
				leftNum = arry_int[left];  // �õ���������
				rightNum = arry_int[right];
				// ��ԭ�������ҵ�index
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
			
			//��target С �� ��ָ�� ����
			if(sum<target){
				left = left + 1;
			}
			
			//���� ��ָ�� ����
			if(sum > target){
				right = right - 1;
			}
		}
		return result;
	}
}
