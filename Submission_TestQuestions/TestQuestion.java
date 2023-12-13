
public abstract class TestQuestion {

	private int questionNumber;
	private static int nextQuestionNumber = 1;
	private int pointValue;
	private String text;


	public TestQuestion(String text, int pointValue) {
		this.text = text;
		this.pointValue = pointValue;
	}

	public abstract int scoreQuestion(String answer);

	/**
	 * returns a string representation of the question including
	 * the question number, text, and point value. For example:
	 * 
	 * 1. This is the first question on the test. (3 pts)
	 * 
	 */
	public String toString() {
		return questionNumber + ".\t" + text + " (" + pointValue + ")";
	}

}
