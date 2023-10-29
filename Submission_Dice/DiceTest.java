/*
 * @author Subhash Muthu
 * Uses the dice class
 * in order to complete
 * some tasks.
 */

 package Submission_Dice;

public class DiceTest {
    
    private static Dice Die1 = new Dice();
    private static Dice Die2 = new Dice();

    public static void main(String[] args){
        
        executeRolls(Die1, 3, "Die 1");
        executeRolls(Die2, 4, "Die 2");
        
        printNumRolls(Die1, "die 1");
        printNumRolls(Die1, "die 2");

        Die1.reset();
        System.out.println("after reset:");
        
        printNumRolls(Die1, "die 1");
        printNumRolls(Die1, "die 2");
    }

    public static void executeRolls(Dice die, int numRolls, String dieName){
    
        System.out.println(dieName + ":");
    
        for (int i = 0; i < numRolls; i++) {
            System.out.println(die.roll());
        }

    }

    public static void printNumRolls(Dice die, String dieName){

        System.out.println(dieName + " was rolled " + die.getNumRolls() + " times");

    }

}
