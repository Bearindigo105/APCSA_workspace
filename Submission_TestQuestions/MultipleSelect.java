
public class MultipleSelect extends TestQuestion {

	private String[] answerChoices;
	private boolean[] answers;

	public MultipleSelect(String text, int pointValue, String[] answerChoices, boolean[] answers) {
		super(text, pointValue);
		this.answerChoices = answerChoices;
		this.answers = answers;
	}

	public String toString() {
		String retString = super.questionNumber + ".\t" + super.text + super.text + " (" + super.pointValue
				+ ")\nSelect ALL correct answer choices as more than one may be correct:\n";
		char choiceLetter = 'A';
		for (String choice : answerChoices) {
			retString += "\n" + choiceLetter + ".\t" + choice;
			choiceLetter++;
		}
		return retString;
	}

	public int scoreQuestion(String answer) {
		double score = 0;
		double numCorrectAns = 0;
		for (boolean correctAns : answers) {
			if (correctAns)
				numCorrectAns++;
		}
		int increment = (int) (pointValue / numCorrectAns);

		for (char answerLetter : answer.toCharArray()) {
			for (int i = 0; i < answers.length; i++) {
				if (Character.toUpperCase(answerLetter) == i + 65 && answers[i])
					score += increment;
				
			}
		}

		return (int) score;
	}

}
