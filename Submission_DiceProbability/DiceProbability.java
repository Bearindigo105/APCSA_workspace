/*
 * @author Subhash Muthu
 * 
 * A main program that utilizes arrays to print probabilites of dice rolls
 */

package Submission_DiceProbability;

import java.util.Scanner;

public class DiceProbability {

    public static void main(String[] args) {

        Scanner inputScanner = new Scanner(System.in);

        Dice die1 = new Dice();
        Dice die2 = new Dice();

        System.out.print("How many times would you like to roll? ");
        int rollNum = inputScanner.nextInt();
        inputScanner.nextLine(); // pesky \n

        int[] rollArray = new int[13]; // the size is 13 so that index can be 12

        for (int i = 0; i < rollNum; i++) {
            rollArray[die1.roll() + die2.roll()] ++;
        }

        for (int i = 2; i < rollArray.length; i++) {
            System.out.printf("%d:\t%d\tExperimental probability: %.4f\n", i, rollArray[i], rollArray[i] / 12.0);
        }

        inputScanner.close();
    }
}
