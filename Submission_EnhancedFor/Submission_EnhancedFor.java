/*
 *  @author Subhash Muthu 
 */

public class Submission_EnhancedFor{
    public static void main(String[] args) {
        int[] values = new int[20];

        for (int i = 0; i < values.length; i++) {
            values[i] = ((int)(Math.random() * 99)) + 1;
        }
        for (int num : values) {
            System.out.println(num);
        }

        System.out.println(findMinVal(values));
        System.out.println(findAverage(values));
    }

    public static int findMinVal(int[] array){
        int minValue = array[0];
        for (int num : array) {
            if(num <  minValue){
                minValue = num;
            }
        }
        return minValue;
    }

    public static double findAverage(int[] array){
        int counter = 0;
        int finalNum = 0;
        for (int num : array) {
            finalNum += num;
            counter ++;
        }
        return ((double)finalNum) / counter;
    }
}