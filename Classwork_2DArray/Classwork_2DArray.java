/*
 * @author Subhash Muthu
 */

public class Classwork_2DArray {
    
    public static void main(String[] args) {
        
        int[] oneDarr = new int[50 + (int)(Math.random() * 51)];
        int[][] twoDarr = new int[(int)Math.ceil(oneDarr.length / 7.0)][7];

        for (int i = 0; i < oneDarr.length; i++) {
            oneDarr[i] = (int)(Math.random() * 100) + 1;
        }
        
        for (int i = 0; i < twoDarr.length; i++) {
            for (int j = 0; j < twoDarr[i].length; j++) {
                twoDarr[i][j] = 0;
            }
        }
        for (int i = 0; i < oneDarr.length; i++) {
            
            if(i % 7 == 0){
                System.out.println(); // newline
            }
            
            System.out.print(oneDarr[i] + ", ");
        }
        System.out.println();
        for (int i = 0; i < oneDarr.length; i++) {
            
            
        }

        System.out.println(); // newline

        for (int[] numArr : twoDarr) {
            for (int num : numArr) {
                System.out.print(num + ", ");
            }
            System.out.println(); //newline
        }
        
    }
}
