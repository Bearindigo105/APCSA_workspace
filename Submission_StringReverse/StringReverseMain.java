/*
 * @author Subhash Muthu
 * 
 * Reverses a string that the user
 * inputs.
 * 
 */

package Submission_StringReverse;

import java.util.Scanner;

public class StringReverseMain {
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        
        System.out.print("Enter a string: ");
        String outputString = StringReverse(inputScanner.nextLine());
        System.out.println("\nOutput: " + outputString);

        inputScanner.close();
    }

    private static String StringReverse(String srcStr){
        
        String returnStr = "";

        for (int i = 0; i < srcStr.length(); i++) {
            returnStr = srcStr.charAt(i) + returnStr;
        }
        
        return returnStr;
    }
}
