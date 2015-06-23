package twosum;

public class SumTwo {

	public static void main(String[] args) {
		int[] input = { 1, 2, 4, 3 };
		int target = 7;
		SumTwo st = new SumTwo();
		int[] result = st.sum(input,target);
		for(int i=0;i<result.length;i++){
			System.out.println(result[i]);
		}

	}

	public int[] sum(int[] arry, int target) {
		int[] result = new int[2];
		for (int i = 0; i < arry.length; i++) {
			for (int j = i + 1; j < arry.length; j++) {
				if (target - arry[i] == arry[j]) {
					result[0] = i;
					result[1] = j;
					return result;
				}
			}
		}
		return result;
	}


}
