/*
 * @author Subhash  Muthu
 * Formats Phone Number and Name.
 */

import java.util.Scanner;

public class PhoneNumber {
    public static void main(String[] args){
        
        //Scanner declaration and construction
        Scanner inputScanner = new Scanner(System.in);
        
        //****NAME & STRING FORMATTING****

        //Gets the name from user using the scanner
        System.out.print("Enter your name: ");
        String fullName = inputScanner.nextLine();

        //Splits the name string into an array of strings with first and last name
        String[] firstLastName = fullName.split(" ");

        //****PHONE NUMBER & NUMBER FORMATTING****

        //Gets the phone number from user using the scanner
        System.out.print("Enter your phone number in the format xxxxxxxxxx: ");
        long phoneNumber = inputScanner.nextLong();
        inputScanner.nextLine();
        
        //Using division and modulus to split the phone number into three parts
        int areaCode = (int)(phoneNumber/10000000);                 //First 3 digits
        int prefixCode = (int)(phoneNumber/10000 - areaCode*1000);  //Middle 3 digits
        int localLine = (int)(phoneNumber % 10000);                 //Last 4 digits
        
        //Print all the info in Mr. Ellis' format
        System.out.printf("%s, %s\t(%d) %d-%d", firstLastName[1], firstLastName[0], areaCode, prefixCode, localLine);
        
        //Prevents resource leak
        inputScanner.close();
    }
}
