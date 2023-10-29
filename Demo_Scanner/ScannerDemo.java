/*
 * @author Subhash Muthu
 * Scanner demo
 */

package Demo_Scanner;

import java.util.Scanner;

public class ScannerDemo {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("enter your age: ");
        int age = input.nextInt();
        input.nextLine();
        System.out.print("enter your name: ");
        String name = input.nextLine();
        System.out.println("Hey " + name + ", how are ya! How was your " + age + "th birthday?");
        input.close();
    }
}
