
public class MCQuestion extends TestQuestion {

	String[] choices;
	String answer;


	public MCQuestion(String text, String[] choices, String answer, int pointValue) {
		this.choices = choices;
		this.text = text;
		this.answer = answer;
		this.pointValue = pointValue;
	}

	public String toString() {
		String retString questionNumber + ".\t" + text + " (" + pointValue + ")";
		char choiceLetter = 'A';
		for(String choice : choices){
			retString += "\n" + choiceLetter + ".\t" + choice;
			choiceLetter ++;
		}
	}

	
	public int scoreQuestion(String answer){
		char answerLetter = 'A';
		for(int i = 0; i < choices.length; i ++){
			if(choices[i] == this.answer){
				answerLetter = i + 'A';
			}
		}
		if(answer == this.answer || answer.charAt(0).toUpperCase() == answerLetter){
			return pointValue
		}
		return 0;
	}

}
