/*
 * @author Subhash Muthu
 * 
 * Simple dice class.
 * only one method. Roll.
 * 
 */

package Submission_DiceProbability;

public class Dice{

    public int roll(){
        return (int)(Math.random() * 6) + 1;
    }

}