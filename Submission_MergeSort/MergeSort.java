import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args){
		int[] start = new int[9];
		for(int i = 0; i < start.length; i++)
		{
			start[i] = (int)(Math.random()*20 + 1);
		}
		int[] sorted = Arrays.copyOf(start,start.length);
		Arrays.sort(sorted);
		mergesort(start);
		if(Arrays.equals(start, sorted))
			System.out.print("correctly sorted");
		else
			System.out.print("not properly sorted");
	}
	
	/*
	 * implement the mergesort method.  It should be a recursive
	 * implementation of the mergesort algorithm we spoke about
	 * in class.  If you run this main method it will tell you 
	 * if your algorithm properly sorted the array.  You do not 
	 * need to add any code to the main method.
	 */
	
	public static void mergesort(int[] arr){
		if(arr.length == 1){

		}else{
			int[] arrL = Arrays.copyOfRange(arr, 0, arr.length/2);
			int[] arrR = Arrays.copyOfRange(arr, arr.length/2, arr.length);
			mergesort(arrR);
			mergesort(arrL);
			arr = arrL;
		}
	}

}
