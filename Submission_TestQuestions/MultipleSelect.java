
public class MultipleSelect extends TestQuestion {

	private String[] answerChoices;
	private boolean[] answers;

	public MultipleSelect(String text, int pointValue, String[] answerChoices, boolean[] answers) {
		this.text = text;
		this.pointValue = pointValue;
		this.answerChoices = answerChoices;
		this.answers = answers
	}

	public String toString() {
		String retString questionNumber + ".\t" + text + text + " (" + pointValue + ")\nSelect ALL correct answer choices as more than one may be correct:\n";
		char choiceLetter = 'A';
		for(String choice : answerChoices){
			retString += "\n" + choiceLetter + ".\t" + choice;
			choiceLetter ++;
		}
	}

	public int scoreQuestion(String answer) {
		int score = 0;
		double increment = ((double)pointValue)/(answers.length);

		for(char answerLetter : answer.toCharArray()){
			for(boolean ans : answers){
				if(ans == answerLetter)
					score += increment;
			}
		}

		return score;
	}

}
