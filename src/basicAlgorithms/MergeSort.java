package basicAlgorithms;

import java.util.Arrays;

/**
 * 
 * */

public class MergeSort {

	public static void main(String args[]) {
		int i = 0;
		System.out.println(i++);
		System.out.println(i);
		int[] array = { 27, 68, 34, 20, 76, 55,0 ,1};
		MergeSort is = new MergeSort();
		is.mergeSort(array);
		System.out.println(Arrays.toString(array));
	}

	public void merge(int[] l, int[] r, int[] a) {
		int i = 0, j = 0, k = 0;
		int nL = l.length;
		int nR = r.length;

		while (i < nL && j < nR) {
			if (l[i] <= r[j]) {
				a[k] = l[i];
				i++;
			} else {
				a[k] = r[j];
				j++;
			}
			k++;
		}

		while (i < nL) {
			a[k] = l[i];
			k++;
			i++;
		}
		while (j < nR) {
			a[k] = r[j];
			k++;
			j++;
		}
	}

	public void mergeSort(int[] a) {
		if (a.length < 2)
			return;
		int[] left = new int[a.length / 2];
		int[] right = new int[a.length - a.length / 2];
		
		for (int i = 0; i < a.length / 2 ; i++) {
			left[i] = a[i];
		}

		for (int i = a.length / 2; i < a.length; i++) {
			right[i - a.length / 2] = a[i];
		}

		mergeSort(left);
		mergeSort(right);
		merge(left, right, a);
	}
}
