/*
 * @author Subhash Muthu
 * Hackerman/Wordle Style Game
*/

package Project_CrackTheCode;

import java.util.Scanner;

public class CrackMeMain{
    public static void main(String[] args){
        CrackMe targetCrackMe = new CrackMe();
        Scanner inputScanner = new Scanner(System.in);

        int guessesLeft = 10;
        boolean isPinGuessed = false;

        while (!(guessesLeft > 0 && isPinGuessed)){
            short guess;
            boolean isGuessInvalid;
            System.out.println("guess #" + guessesLeft);
            guessesLeft --;
            System.out.print("enter pin: ");

            if(inputScanner.hasNextShort()){
                
                guess = inputScanner.nextShort();
                
                if(guess < 999 && guess > 100){
                    isGuessInvalid = false;
                    String guessStr = guess + "";
                    char digitOne = targetCrackMe.checkFirstDigit(guessStr) ? guessStr.charAt(0) : '_';
                    char digitTwo = targetCrackMe.checkSecondDigit(guessStr) ? guessStr.charAt(1) : '_';
                    char digitThree = targetCrackMe.checkThirdDigit(guessStr) ? guessStr.charAt(2) : '_';
                    String outputStr = String.format("%c%c%c",digitOne, digitTwo, digitThree);
                    
                    System.out.println(outputStr);

                    inputScanner.nextLine();
                    if(!outputStr.contains("_")){
                        isPinGuessed = true;
                    }
                }else{
                    isGuessInvalid = true;
                }
            }else{
                isGuessInvalid = true;
            }
            if(isGuessInvalid){
                System.out.println("invalid guess");
                inputScanner.nextLine();
            }
        }

        System.out.println(isPinGuessed ? "You're in the mainframe! Swordfish!" : "I guess being a hacker isn't for everyone. You Lost.");

        inputScanner.close();
    }
}