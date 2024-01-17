import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		int[] start = new int[10];
		for (int i = 0; i < start.length; i++) {
			start[i] = (int) (Math.random() * 20 + 1);
		}
		int[] sorted = Arrays.copyOf(start, start.length);
		Arrays.sort(sorted);
		mergesort(start);
		if (Arrays.equals(start, sorted))
			System.out.print("correctly sorted");
		else
			System.out.print("not properly sorted");
		System.out.println();
		System.out.println(Arrays.toString(sorted));
	}

	/**
	 * @param arr
	 * @apiNote sorts arr from least to greatest.
	 */
	public static void mergesort(int[] arr) {
		if (arr.length > 1) {
			int[] arrL = Arrays.copyOfRange(arr, 0, arr.length / 2);
			int[] arrR = Arrays.copyOfRange(arr, arr.length / 2, arr.length);

			mergesort(arrL);
			mergesort(arrR);

			int i = 0;
			int j = 0;
			int k = 0;
			while (i < arrL.length && j < arrR.length) {
				if (arrL[i] <= arrR[j]) {
					arr[k] = arrL[i];
					i++;
				} else {
					arr[k] = arrR[j];
					j++;
				}
				k++;
			}
			while (i < arrL.length) {
				arr[k] = arrL[i];
				i++;
				k++;
			}
			while (j < arrR.length) {
				arr[k] = arrR[j];
				j++;
				k++;
			}
		}
	}
}
