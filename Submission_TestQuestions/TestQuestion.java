
public abstract class TestQuestion {

	private int questionNumber;
	private static int nextQuestionNumber = 1;
	private int pointValue;
	private String text;


	public TestQuestion(String text, int pointValue) {
		this.text = text;
		this.pointValue = pointValue;
		questionNumber = nextQuestionNumber
		nextQuestionNumber ++;
	}

	public abstract int scoreQuestion(String answer);
	
	public String toString() {
		return questionNumber + ".\t" + text + " (" + pointValue + ")";
	}

}
