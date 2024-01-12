public class Demo_Recursion {
    public static void main(String[] args){
        System.out.println(nthTerm(25));
        System.out.println(factorial(25));
    }

    public static int nthTerm(int n){
        if(n<3){
            return 1;
        }else{
            return nthTerm(n - 1) + nthTerm(n - 2);
        }
    }

    public static int factorial(int n){
        if(n==0){
            return 1;
        }else{
            return n * factorial(n-1);
        }
    }
}
