/*
 * @author Subhash Muthu
 * 
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Submission_GettysburgAddress {

    public static void main(String[] args) throws FileNotFoundException{
        ArrayList<String> gettyAddrArrList = new ArrayList<>();
        Scanner gettyAddrFile = new Scanner(new File("Submission_GettysburgAddress\\GettysburgAddress.txt"));

        while (gettyAddrFile.hasNext()) {
            String replacedWord = gettyAddrFile.next().replace('.', Character.MIN_VALUE);
            replacedWord = replacedWord.replace(',', Character.MIN_VALUE);
            gettyAddrArrList.add(replacedWord);
        }

        //Uncomment to print out the arraylist
        //
        // for (String string : gettyAddrArrList) {
        //     System.out.print("(" + string + "), ");
        // }

        int totalGettyAddrLen = 0;
        int largestLength = gettyAddrArrList.get(0).length();
        String largestWord = null;
        for (String word : gettyAddrArrList) {
            totalGettyAddrLen += word.length();
            if(largestLength < word.length()){
                largestLength = word.length();
                largestWord = word;
            }
        }
        System.out.println(); // intentionally blank

        System.out.println("Largest Word: (" + largestWord + "), which is " + largestLength + " characters long");
        System.out.println("Average Word Length: " + totalGettyAddrLen/gettyAddrArrList.size());
    }
}
