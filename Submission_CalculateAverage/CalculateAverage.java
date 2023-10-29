/*
 * @author Subhash Muthu
 * Calculates the average.
 */

import java.util.Scanner;

public class CalculateAverage {
    public static void main(String[] args) {

        Scanner inputScanner = new Scanner(System.in);
        
        System.out.print("Course name: ");
        final String courseName = inputScanner.nextLine();
        
        System.out.print("First assessment name: ");
        final String testOne = inputScanner.nextLine();
        System.out.println("Points earned on first assignment: ");
        final int pointsEarnedAssgnmnt1 = inputScanner.nextInt();
        inputScanner.nextLine();
        System.out.println("Points possible on first assignment: ");
        final int pointsTotalAssgnmnt1 = inputScanner.nextInt();
        inputScanner.nextLine();
        
        System.out.print("Second assessment name: ");
        final String testTwo = inputScanner.nextLine();
        System.out.println("Points earned on second assignment: ");
        final int pointsEarnedAssgnmnt2 = inputScanner.nextInt();
        inputScanner.nextLine();
        System.out.println("Points possible on second assignment: ");
        final int pointsTotalAssgnmnt2 = inputScanner.nextInt();
        inputScanner.nextLine();
        
        System.out.print("Third assessment name: ");
        final String testThree = inputScanner.nextLine();
        System.out.println("Points earned on third assignment: ");
        final int pointsEarnedAssgnmnt3 = inputScanner.nextInt();
        inputScanner.nextLine();
        System.out.println("Points possible on third assignment: ");
        final int pointsTotalAssgnmnt3 = inputScanner.nextInt();
        inputScanner.nextLine();        
        inputScanner.close();

        int courseEarnedPoints = pointsEarnedAssgnmnt1 + pointsEarnedAssgnmnt2 + pointsEarnedAssgnmnt3;
        int courseTotalPoints = pointsTotalAssgnmnt1 + pointsTotalAssgnmnt2 + pointsTotalAssgnmnt3;
        System.out.println(courseName + " Score for " + testOne + ", " + testTwo + ", " + testThree + ": " + courseEarnedPoints + "/" + courseTotalPoints);
        float courseAverage = (float)courseEarnedPoints/(float)courseTotalPoints;
        System.out.println("student average: " + courseAverage);
    }
}