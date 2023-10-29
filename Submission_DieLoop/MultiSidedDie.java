/*
 * 
 * @author Subhash Muthu
 * 
 * die with differing number of sides
 *
 */

package Submission_DieLoop;

 public class MultiSidedDie {

	//FIELDS
	private int _numSides;
	private int _numRolls;
	
	
	//CONSTRUCTORS
	public MultiSidedDie(){
		_numSides = 6;
	}
	
	public MultiSidedDie(int numSides){
		if (numSides < 4) {
			this._numSides = 4;
	    } else {		
			this._numSides = numSides;	
		}
	}
	
	//METHODS
	
	public int roll(){
		this._numRolls ++;
		return (int)(Math.random() * (_numSides) + 1);
	}

	public int getNumSides() {
		return _numSides;
	}
	
	public int getNumRolls() {
		return _numRolls;
	}
	
	public void reset(){
		_numRolls = 0;
	}
	
	public void setNumSides(int numSides) {
		if (numSides < 4) {
			this._numSides = 4;
	    } else {		
			this._numSides = numSides;	
		}
	}
	
	@Override
	public String toString(){
		return "numSides: " + _numSides + "\nnumRolls: " + _numRolls;
	}

}
