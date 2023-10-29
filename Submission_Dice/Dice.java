package Submission_Dice;


public class Dice 
{
	private int numRolls;
	
	public Dice()
	{
		numRolls = 0;
	}
	
	public int roll()
	{
		numRolls = numRolls + 1;
		return (int)(Math.random()*6 + 1);
		
	}
	
	public int getNumRolls()
	{
		return numRolls;
	}
	
	public void reset()
	{
		numRolls = 0;
	}

}
