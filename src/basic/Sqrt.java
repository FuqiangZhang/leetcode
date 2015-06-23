package basic;

/**
 * 
 * Implement int sqrt(int x).
 * 
 * Compute and return the square root of x. 开平方根
 * 
 * 妈蛋啊 一点思路没有，这他妈怎么算
 * 
 * 二分查找
 * 
 * */
public class Sqrt {

	public static void main(String[] args) {
		Sqrt sqrt = new Sqrt();
		System.out.println(sqrt.solution(65));
	}

	public int solution(int x) {
		if (x < 2) {
			return x;
		}

		int low = 1;
		int high = x / 2;
		int mid = 0;
		int lastMid = 0;

		while (low <= high) {
			mid = (low + high) / 2;
			if (x / mid > mid) {
				low = mid + 1;
				lastMid = mid;
			} else if (x / mid < mid) {
				high = mid - 1;
			} else {
				return mid;
			}
		}

		return lastMid;
	}

	// public int solution(int start, int x,int target) {
	//
	// int mid = (start + x) / 2;
	// System.out.println(mid+" = mid");
	// if (mid * mid == target) {
	// return mid;
	// }
	// if (mid * mid < target) {
	// return solution(mid, x , target);
	// }
	// if (mid * mid > target) {
	// return solution(start, mid , target);
	// }
	// return 0;
	// }

}
