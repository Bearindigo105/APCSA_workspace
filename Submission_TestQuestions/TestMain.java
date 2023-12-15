import java.util.Scanner;
import java.util.ArrayList;

public class TestMain{

    public static void main(String[] args){
        ArrayList<TestQuestion> TestQuestions = new ArrayList<TestQuestion>();
        Scanner input = new Scanner(System.in);
        
        boolean keepGoing = true;
        while(keepGoing){
            System.out.print("Multiple Choice or Multiple Select(mc/ms)? ");
            
            System.out.print("Enter the text? ");
            String text = input.nextLine();
            System.out.print("How many answer choices? ")
            int numAnswers = Integer.parseInt(input.nextLine());
            String[] answerChoices = new String[numAnswers];
            for(int i = 0; i < numAnswers; i++){
                System.out.print("Answer Choice #" + i + "? ");
                answerChoices[i] = input.nextLine();
            }
            System.out.print("What is the point value? ");
            int pointValue = input.nextLine();
            if(input.nextLine() == "mc"){
                System.out.print("What is the correct answer(range 0 - numAnswers-1)? ")
                int correctAnswer = Integer.parseInt(input.nextLine());
                TestQuestions.add(new MCQuestion(text, answerChoices, answerChoices[correctAnswer], pointValue));
            }else if(input.nextLine() == "ms"){
                System.out.print("What are the correct answers(range 0 - numAnswers-1, range 0 - numAnswers-1, ...)? ");
                String[] answerStrs = input.nextLine().split(", ");
                int[] answerInts = new int[answerStrs.length];
                for(int i = 0; i < answerStrs.length; i++){
                    answerInts[i] = Integer.parseInt(answerStrs[i]);
                }
                TestQuestions.add(new MultipleSelect());
            }
        }
    }


}