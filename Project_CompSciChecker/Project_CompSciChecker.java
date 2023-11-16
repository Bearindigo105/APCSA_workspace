import java.util.Scanner;

public class Project_CompSciChecker{
    
    public static void main(String[] args){
        Scanner inputScanner = new Scanner(System.in);
        CompSciCheckerBoard cscb = new CompSciCheckerBoard();
        for (int i = 0; i < 5; i++) {
            
            System.out.println(cscb);

            System.out.print("original row? ");
            int inputRow = inputScanner.nextInt();
            inputScanner.nextLine(); // clear input stream
            System.out.print("original column? ");
            int inputColumn = inputScanner.nextInt();
            inputScanner.nextLine();

            System.out.print("new row? ");
            int inputNewRow = inputScanner.nextInt();
            inputScanner.nextLine(); // clear input stream
            System.out.print("new column? ");
            int inputNewColumn = inputScanner.nextInt();
            inputScanner.nextLine();

            cscb.makeMove(inputRow, inputColumn, inputNewRow, inputNewColumn);
        }
        
        inputScanner.close();
    }
}