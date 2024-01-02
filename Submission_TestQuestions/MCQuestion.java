
public class MCQuestion extends TestQuestion {

	String[] choices;
	String answer;

	public MCQuestion(String text, String[] choices, String answer, int pointValue) {
		super(text, pointValue);
		this.choices = choices;
		this.answer = answer;
	}

	public String toString() {
		String retString = questionNumber + ".\t" + text + " (" + pointValue + " pts)";
		char choiceLetter = 'A';
		for (String choice : choices) {
			retString += "\n" + choiceLetter + ". " + choice;
			choiceLetter++;
		}
		return retString;
	}

	public int scoreQuestion(String answer) {
		char answerLetter = 'A';
		for (int i = 0; i < choices.length; i++) {
			if ((choices[i] == this.answer)) {
				for(int j = 0; j < i; j++){
					answerLetter++;
				}
			}
		}
		if (answer.equalsIgnoreCase(this.answer) || (Character.toLowerCase(answer.charAt(0)) == Character.toLowerCase(answerLetter) && answer.length() == 1)) {
			return pointValue;
		} else {
			return 0;
		}
	}

}
