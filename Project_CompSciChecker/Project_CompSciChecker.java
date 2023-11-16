import java.util.Scanner;

/**
 * @apiNote A test class/game of comp sci checkers
 * @author Subhash Muthu
 */
public class Project_CompSciChecker{
    
    public static void main(String[] args){
        Scanner inputScanner = new Scanner(System.in);

        CompSciCheckerBoard cscb = new CompSciCheckerBoard();
        String colorToMove = "W";
        while (cscb.getNumBlackPieces() + cscb.getNumWhitePieces() != 0) {
            
            int inputRow;
            int inputColumn;
            int inputNewRow;
            int inputNewColumn;
            
            boolean isThisMoveValid = true;
            do{
                if (isThisMoveValid = false) {
                    System.out.println("Invalid Move!!!!");
                }
                System.out.println(colorToMove + " to move [W: " + cscb.getNumWhitePieces() + " B: " + cscb.getNumBlackPieces() + "]");

                System.out.println(cscb);

                System.out.print("original row? ");
                inputRow = inputScanner.nextInt();
                inputScanner.nextLine(); // clear input stream
                System.out.print("original column? ");
                inputColumn = inputScanner.nextInt();
                inputScanner.nextLine();

                System.out.print("new row? ");
                inputNewRow = inputScanner.nextInt();
                inputScanner.nextLine(); // clear input stream
                System.out.print("new column? ");
                inputNewColumn = inputScanner.nextInt();
                inputScanner.nextLine();

                System.out.println(cscb.isValidMove(inputRow, inputColumn, inputNewRow, inputNewColumn));
                if (cscb.isValidMove(inputRow, inputColumn, inputNewRow, inputNewColumn) && cscb.getBoard()[inputRow][inputColumn] != null) {
                    if (cscb.getBoard()[inputRow][inputColumn].getColor() == colorToMove){
                        isThisMoveValid = true;
                    }else{
                        isThisMoveValid = false;
                    }
                }
            }while(!isThisMoveValid);
            
            cscb.makeMove(inputRow, inputColumn, inputNewRow, inputNewColumn);
            if(colorToMove == "W"){    
                colorToMove = "B";
            }else{
               colorToMove = "W";
            }
        }
        
        inputScanner.close();
    }
}