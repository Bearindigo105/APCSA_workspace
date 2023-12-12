
public class MultipleSelect extends TestQuestion {

	private String[] answerChoices;
	private boolean[] answers;

	/**
	 * Write a constructor for MultipleSelect which takes
	 * a string for the text, an array of Strings for answer choices
	 * and a boolean array for the correct answer. True in the boolean
	 * array represents that choice should be selected.
	 * The answer should be formatted such that each index indicates
	 * whether the answer at that index should be selected (true) or not
	 * (false). You may assume that answerChoices and answer have the
	 * same length.
	 * 
	 */
	public MultipleSelect(String text, int pointValue, String[] answerChoices, boolean[] answers) {
		this.text = text;
		this.pointValue = pointValue;
		this.answerChoices = answerChoices;
		this.answers = answers
	}

	/**
	 * Override the toString method to display the question in the
	 * form:
	 * 
	 * 2. This is the text for question number 2.
	 * Select ALL correct answer choices as more than one may be correct:
	 * 
	 * A. answer choice one
	 * B. answer choice two
	 * C. answer choice three
	 * D. answer choice four
	 * 
	 * Keep in mind there are no restrictions on the number of answer
	 * choices. Your method should work no matter the answer array.
	 * As a reminder, you may increment a char using ++ as it is primitive.
	 */

	public String toString() {
		String retString questionNumber + ".\t" + text + "\nSelect ALL correct answer choices as more than one may be correct:\n";
		char choiceLetter = 'A';
		for(String choice : answerChoices){
			retString += "\n" + choiceLetter + ".\t" + choice;
			choiceLetter ++;
		}
	}

	/**
	 * Override the inherited scoreQuestion method which takes a
	 * student's answer as an argument and returns true
	 * if it is correct and false otherwise. Keep in mind that
	 * the answer choices can be supplied in any order, so an
	 * answer "BAC" would be correct given a correct answer of
	 * "CBA". Points should be awarded for each answer choice
	 * as a fraction of the total points. For instance if there
	 * are 5 answer choices and the problem is worth 5 points, each
	 * answer choice is worth 1 point for being either properly
	 * selected or not selected. However, each incorrect answer
	 * choice subtracts its value from the score. so if 3 answer
	 * choices are properly selected (or not selected), and two are
	 * incorrect, and the problem is worth 5 points, the answer
	 * would be awarded 3 points for the correct choices, and lose
	 * 2 points for the incorrect choices for a total of 1 point.
	 * Be sure the score is never negative.
	 * 
	 */
	public int scoreQuestion(String answer) {
		
		//TODO

	}

}
