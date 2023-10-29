/*
 *@author Subhash Muthu
 *Chapter Four Review
 */

package Submission_ChapterFourReview;

public class ChapterFourReview{
	private final String _myStr;
	private int _myInt;

	public ChapterFourReview(String myStr, int myInt){
		this._myStr = myStr;
		this._myInt = myInt;
	}

	public ChapterFourReview(String myStr){
		this._myStr = myStr;
		this._myInt = 10;
	}
	
	public int getMyInt(){return this._myInt;}

	public String getMyStr(){return this._myStr;}

	public char getLastLetter(){
		int lastLetterIndex = this._myStr.length() - 1;
		return this._myStr.charAt(lastLetterIndex);
	}
	
	public String getFirstHalf(){
		int middleIndex = this._myStr.length() / 2;
		return this._myStr.substring(0, middleIndex);
	}

	public String getSecondHalf(){
		int middleIndex = this._myStr.length() / 2;
		return this._myStr.substring(middleIndex, this._myStr.length());
	}

	public void setMyInt(int myInt){this._myInt = myInt;}
}


