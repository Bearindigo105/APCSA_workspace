/*
 * @author Subhash Muthu
 * 
 * Test AP String Shtuf
 */


package Submission_ApString;

public class ApStringMain {
    public static void main(String[] args) {
        ApString apstr = new ApString("Helllllo Worrrrld!");
        System.out.println(apstr.getCurrentString());
        System.out.println(apstr.removeDoubleLetters());
        
        System.out.println(apstr.spacedWord());

        System.out.println(apstr.wordCount());
        System.out.println(apstr.getCurrentString());
    }
}
