/*
 * @author Subhash Muthu
 * Calculator Test
 */

public class CalcTest {

    public static void main(String[] args){
        Calculator subhash = new Calculator();

        int result = subhash.add(2, 4);
        System.out.println("2 + 4 = " + result);

        int rolls = subhash.getNumCalc();
        System.out.println(rolls);
    }
}
