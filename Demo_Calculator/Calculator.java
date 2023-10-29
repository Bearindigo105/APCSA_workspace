/*
 * @author Subhash Muthu
 * Calculator Class
 */

public class Calculator {
    
    private int numCalc;

    public int add(int a, int b){
        int ans = a + b;
        numCalc ++;
        return ans;
    }

    public int sub(int a, int b){
        int ans = a - b;
        numCalc ++;
        return ans;
    }

    public int getNumCalc(){
        return numCalc;
    }

    public boolean randomMethod(String str, int num1, int num2){
        return true;
    }

    public void reset(){
        numCalc = 0;
    }
}
