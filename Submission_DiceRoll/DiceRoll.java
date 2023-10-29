/*
 * @author Subhash Muthu
 * DiceRoll class.
 *      rolls 10 numbers,
 *      lists how many of each number was rolled.
 */

package Submission_DiceRoll;

public class DiceRoll {
    public static void main(String[] args){
        Dice die = new Dice();
        
        byte[] numsOfNumsArray = new byte[6];

        for(int i = 0; i < 11; i ++){
            int rolledNum = die.roll();
            numsOfNumsArray[rolledNum - 1] ++;            
            System.out.print(rolledNum + " ");
        }
        System.out.println(); // BLANK NEWLINE
        
        for (int index = 0; index < numsOfNumsArray.length; index++) {
            switch(index){
                case 0:
                System.out.print("ones: ");
                break;
                case 1:
                System.out.print("twos: ");
                break;
                case 2:
                System.out.print("threes: ");
                break;
                case 3:
                System.out.print("fours: ");
                break;
                case 4:
                System.out.print("fives: ");
                break;
                case 5:
                System.out.print("sixes: ");
                break;
            }
            System.out.println(numsOfNumsArray[index]);
        }
    }
}
