
public abstract class TestQuestion {

	protected int questionNumber;
	private static int nextQuestionNumber = 1;
	protected int pointValue;
	protected String text;

	public TestQuestion(String text, int pointValue) {
		this.text = text;
		this.pointValue = pointValue;
		questionNumber = nextQuestionNumber;
		nextQuestionNumber++;
	}

	public abstract int scoreQuestion(String answer);

	public String toString() {
		return questionNumber + ".\t" + text + " (" + pointValue + ")";
	}

}
