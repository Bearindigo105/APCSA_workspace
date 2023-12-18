import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestQuestionUnitTests {

    // *****FILL IN THE FOLLOWING VARIABLE********/
    private static String fullName = "Muthu Subhash Muthu";

    // ******DO NOT CHANGE ANYTHING BELOW THIS LINE OR YOUR SUBMISSION WILL BE
    // INCORRECT**********/

    private static int correctTests;
    private static int totalTests;
    private static int nameHash;
    private static boolean check;
    private static String prompt = "this is the question prompt:";
    private static String[] ansChoice;
    private static boolean[] correctAns;
    private static String inc = "incorrect answer";
    private static String cor = "Correct Answer";
    private static MultipleSelect MSQ1;
    private static MCQuestion MCQ1;
    private static TestQuestion TQ1;

    @Test
    public void TestMSscoreCorrect() {
        String ans = "Correct Answer";
        String[] a = { inc, cor, inc, inc };
        boolean[] b = { false, true, true, false };
        ansChoice = a;
        MultipleSelect q = new MultipleSelect(prompt, 8, ansChoice, b);
        assertEquals(8, q.scoreQuestion("BC"));
        check = true;
    }

    @Test
    public void TestMSscoreCorrect2() {
        String ans = "Correct Answer";
        String[] a = { inc, cor, inc, inc };
        boolean[] b = { false, true, true, false };
        ansChoice = a;
        MultipleSelect q = new MultipleSelect(prompt, 8, ansChoice, b);
        assertEquals(8, q.scoreQuestion("cB"));
        check = true;
    }

    @Test
    public void TestMSscorePartial() {
        String ans = "Correct Answer";
        String[] a = { inc, cor, inc, inc };
        boolean[] b = { true, true, true, false };
        ansChoice = a;
        MultipleSelect q = new MultipleSelect(prompt, 8, ansChoice, b);
        assertEquals(4, q.scoreQuestion("AB"));
        check = true;
    }

    @Test
    public void TestMSscorePartial2() {
        String ans = "Correct Answer";
        String[] a = { inc, cor, inc, inc, "sure", "whatever", "sweetness" };
        boolean[] b = { true, true, true, false, false, false, true };
        ansChoice = a;
        MultipleSelect q = new MultipleSelect(prompt, 7, ansChoice, b);
        assertEquals(3, q.scoreQuestion("cAgD"));
        check = true;
    }

    @Test
    public void TestMSscorePartial3() {
        String ans = "Correct Answer";
        String[] a = { inc, cor, inc, "sure", "whatever", "sweetness" };
        boolean[] b = { true, true, true, false, false, false };
        ansChoice = a;
        MultipleSelect q = new MultipleSelect(prompt, 6, ansChoice, b);
        assertEquals(0, q.scoreQuestion(""));
        check = true;
    }

    @Test
    public void TestMSscoreNegative() {
        String ans = "Correct Answer";
        String[] a = { inc, cor, inc, "sure", "whatever", "sweetness" };
        boolean[] b = { true, false, true, true, true, false };
        ansChoice = a;
        MultipleSelect q = new MultipleSelect(prompt, 6, ansChoice, b);
        assertEquals(0, q.scoreQuestion("BF"));
        check = true;
    }

    @Test
    public void TestMCScoreLetterIncorrect() {
        String ans = "Correct Answer";
        String[] a = { inc, inc, inc, cor, inc };
        ansChoice = a;
        MCQuestion q = new MCQuestion(prompt, ansChoice, ans, 8);

        assertEquals(0, q.scoreQuestion("C"));
        check = true;
    }

    @Test
    public void TestMCScoreCompleteIncorrect() {
        String ans = "Correct Answer";
        String[] a = { inc, inc, cor, inc, inc };
        ansChoice = a;
        MCQuestion q = new MCQuestion(prompt, ansChoice, ans, 8);

        assertEquals(0, q.scoreQuestion(ans + "!"));
        check = true;
    }

    @Test
    public void TestMCScoreCompleteLower() {
        String ans = "Correct Answer";
        String[] a = { inc, inc, inc, cor, inc, inc };
        ansChoice = a;
        MCQuestion q = new MCQuestion(prompt, ansChoice, ans, 4);

        assertEquals(4, q.scoreQuestion(ans.toLowerCase()));
        check = true;
    }

    @Test
    public void TestMCScoreCompleteAnswer() {
        String ans = "Correct Answer";
        String[] a = { inc, inc, cor, inc, inc };
        ansChoice = a;
        MCQuestion q = new MCQuestion(prompt, ansChoice, ans, 8);

        assertEquals(8, q.scoreQuestion(ans));
        check = true;
    }

    @Test
    public void TestMCScoreLetterLower() {
        String ans = "Correct Answer";
        String[] a = { inc, inc, inc, cor, inc, inc };
        ansChoice = a;
        MCQuestion q = new MCQuestion(prompt, ansChoice, ans, 4);

        assertEquals(4, q.scoreQuestion("d"));
        check = true;
    }

    @Test
    public void TestMCScoreLetter() {
        String ans = "Correct Answer";
        String[] a = { inc, inc, cor, inc, inc };
        ansChoice = a;
        MCQuestion q = new MCQuestion(prompt, ansChoice, ans, 8);

        assertEquals(8, q.scoreQuestion("C"));
        check = true;
    }

    @Test
    public void TestMultipleChoiceToString() {

        String result = MCQ1.toString();
        String expected = "2.\t" + prompt + " (2 pts)\nA. " + inc + "\nB. " + inc + "\nC. " + cor + "\nD. " + inc
                + "\nE. "
                + inc + "\nF. " + inc;
        assertEquals(expected, result);
        check = true;
    }

    @Test
    public void TestMultipleSelectToString() {
        String result = MSQ1.toString();
        String expected = "1.\t" + prompt +
                " (6 pts)\nSelect ALL correct answer choices as more than one may be correct:\n\nA. " +
                inc + "\nB. " + cor + "\nC. " + inc + "\nD. " + inc;

        assertEquals(expected, result);
        check = true;
    }

    @Test
    public void TestThirdToString() {
        String result = TQ1.toString();
        String expected = "3.\t" + prompt +
                " (10 pts)\nSelect ALL correct answer choices as more than one may be correct:\n\nA. " +
                inc + "\nB. " + cor + "\nC. " + inc + "\nD. " + inc + "\nE. " + cor + "\nF. " + cor;

        assertEquals(expected, result);
        check = true;
    }

    @BeforeClass
    public static void setup() throws FileNotFoundException {
        String ans = "Correct Answer";
        String[] a = { inc, cor, inc, inc };
        boolean[] b = { false, true, true, false };
        ansChoice = a;
        MSQ1 = new MultipleSelect(prompt, 6, ansChoice, b);

        String[] a1 = { inc, inc, cor, inc, inc, inc };
        ansChoice = a1;
        MCQ1 = new MCQuestion(prompt, ansChoice, ans, 2);

        String[] a2 = { inc, cor, inc, inc, cor, cor };
        ansChoice = a2;
        boolean[] b1 = { true, false, true, true, false, false };
        TQ1 = new MultipleSelect(prompt, 10, ansChoice, b);

        nameHash = fullName.hashCode();
        correctTests = nameHash + getFileHash();

    }

    // ************************************************************************/
    @Before
    public void setupCheck() {
        check = false;
    }

    @After
    public void process() {
        if (check) {
            correctTests++;
        }
        totalTests++;
        check = false;
    }

    @AfterClass
    public static void finish() throws FileNotFoundException {
        PrintWriter out = new PrintWriter(fullName + "_chess_output.txt");
        String output = fullName + ":" + correctTests + ":::" + nameHash + ":";
        output += ":" + getFileHash() + ":";
        output += output.hashCode() + ":";
        output += getFileHash();
        out.write(output);
        out.close();
    }

    public static int getFileHash() throws FileNotFoundException {
        String fileString = "";
        Scanner file = new Scanner(new File("TestQuestionUnitTests.java"));
        while (file.hasNextLine()) {
            fileString += file.nextLine();
        }
        fileString = fileString.substring(fileString.indexOf("INCORRECT**********/"));
        file.close();
        return fileString.hashCode();
    }

}
