/**
 * 
 * @author 	Subhash Muthu
 * 
 * MULTI SIDED DIE MAIN
 *
 */

package Submission_DieLoop;

import java.util.Scanner;

public class DieMain 
{

	public static void main(String[] args) 
	{

		//Task One
		System.out.println("TASK ONE -----------------------");

		MultiSidedDie twelveSidedDieA = new MultiSidedDie(12);
		MultiSidedDie twelveSidedDieB = new MultiSidedDie(12);

		int DieARoll;
		int DieBRoll;
		
		do{
			DieARoll = twelveSidedDieA.roll();
			DieBRoll = twelveSidedDieB.roll();
			System.out.println(DieARoll + " " + DieBRoll);
		}while(DieARoll != DieBRoll);

		System.out.println(twelveSidedDieA.getNumRolls());
		
		//Task Two
		System.out.println("TASK TWO -----------------------");

		Scanner inputScanner = new Scanner(System.in);
		MultiSidedDie mSidedDie = new MultiSidedDie();

		
		System.out.print("How many sides you want on your dice? ");

		mSidedDie.setNumSides(inputScanner.nextInt());
		int targetRoll;

		boolean isTaskTwoExecuted = false;

		System.out.print("What is your target number? ");

		while(!isTaskTwoExecuted){

			boolean isInputValid = false;

			if(inputScanner.hasNextInt()){

				targetRoll = inputScanner.nextInt();
				inputScanner.nextLine();
				
				if(targetRoll <= mSidedDie.getNumSides() && targetRoll >= 1){
					
					isTaskTwoExecuted = true;

					isInputValid = true;
					
					int numTargetHits = 0;

					for (int i = 1; i < 21; i++) {
						int rolledNum = mSidedDie.roll();

						if(targetRoll == rolledNum){
							numTargetHits ++;
						}

						System.out.println("guess #" + i + "  this roll: " + rolledNum + "  target was rolled " + numTargetHits + " times");
					}
				}
			}
			if(!isInputValid){
				System.out.println("Invalid target number? ");
			}
		}


		//Task Three
		System.out.println("TASK THREE -----------------------");

		MultiSidedDie mSidedDie3 = new MultiSidedDie();

		
		System.out.print("How many sides you want on your dice? ");

		mSidedDie3.setNumSides(inputScanner.nextInt());
		int targetRoll3;

		boolean isTaskThreeExecuted = false;

		System.out.print("What is your target number? ");

		while(!isTaskThreeExecuted){

			boolean isInputValid = false;

			if(inputScanner.hasNextInt()){

				targetRoll3 = inputScanner.nextInt();
				inputScanner.nextLine();
				
				if(targetRoll3 <= mSidedDie3.getNumSides() && targetRoll3 >= 1){
					
					isTaskThreeExecuted = true;

					isInputValid = true;
					int mSidedDie3RolledNum;
					do{
						mSidedDie3RolledNum = mSidedDie3.roll();
						System.out.println("Roll #" + mSidedDie3.getNumRolls() + ": " + mSidedDie3RolledNum);
					}while(mSidedDie3RolledNum != targetRoll3);
					System.out.println("rolled " + mSidedDie3.getNumRolls() + " times until target was rolled");
				}
			}
			if(!isInputValid){
				System.out.println("Invalid target number? ");
			}
		}
		
		inputScanner.close();
	}

}
