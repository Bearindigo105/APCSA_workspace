/*
 * @author Subhash Muthu
 * 
 * https://gvsd.instructure.com/courses/15378/assignments/385034?module_item_id=844704
 */

import java.util.Scanner;

public class Classwork_2DArray {

    public static void main(String[] args) {

        int[] oneDimesionalArr = new int[50 + (int) (Math.random() * 51)];
        int[][] twoDimensionalArr = new int[(int) Math.ceil(oneDimesionalArr.length / 7.0)][7];
        Scanner inputScanner = new Scanner(System.in);

        for (int i = 0; i < oneDimesionalArr.length; i++) {
            oneDimesionalArr[i] = (int) (Math.random() * 100) + 1;
        }

        for (int i = 0; i < twoDimensionalArr.length; i++) {
            for (int j = 0; j < twoDimensionalArr[i].length; j++) {
                twoDimensionalArr[i][j] = 0;
            }
        }

        for (int i = 0; i < oneDimesionalArr.length; i++) {

            if (i % 7 == 0) {
                System.out.println(); // newline
            }

            System.out.print(oneDimesionalArr[i] + ", ");
        }

        System.out.println();

        for (int i = 0; i < oneDimesionalArr.length; i++) {
            twoDimensionalArr[i / 7][i % 7] = oneDimesionalArr[i];
        }

        System.out.println();

        for (int[] rowArr : twoDimensionalArr) {
            for (int num : rowArr) {
                System.out.print(num + ", ");
            }
            System.out.println();
        }

        System.out.print("input an integer to check the array? ");
        int integerToFind = inputScanner.nextInt();
     
        String outString = "value not found";

        for (int i = twoDimensionalArr.length * twoDimensionalArr[0].length - 1; i >= 0; i--) {
            if(integerToFind == twoDimensionalArr[i / 7][i % 7]){
                outString = "Row: " + i / 7 + ", Col: " + i % 7;
            }
            
        }

        System.out.println(outString);

        inputScanner.close();
    }
}
