
/**
 * @apiNote A class that can be used to emulate comp sci checkers
 * @author Subhash Muthu
 * @author Mr. Ellis
 */
public class CompSciCheckerBoard {

	private CompSciChecker[][] board;
	private int numWhitePieces;
	private int numBlackPieces;

	/**
	 * @apiNote
	 * when constructed, the board should looks like this:
	 * 
	 *  _ _ _ _ _ _ _ _
	 * |W   W   W   W  |
	 * |  W   W   W   W|
	 * |W   W   W   W  |
	 * |               |
	 * |               |
	 * |  B   B   B   B|
	 * |B   B   B   B  |
	 * |_ B _ B _ B _ B|
	 */
	public CompSciCheckerBoard() {
		board = new CompSciChecker[8][8];

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < board.length; j++) {
				if ((j + i) % 2 == 0) {
					if (i < 3) {
						board[i][j] = new CompSciChecker("W");
						numWhitePieces ++;
					} else if (i > 4) {
						board[i][j] = new CompSciChecker("B");
						numBlackPieces ++;
					}
				}
			}
		}
	}

	/**
	 * @apiNote constructs specific cases
	 * @param board
	 */
	public CompSciCheckerBoard(CompSciChecker[][] board) {
		this.board = board;
		numWhitePieces = 0;
		numBlackPieces = 0;
		for (int i = 0; i < this.board.length; i++) {
			for (int j = 0; j < this.board[i].length; j++) {
				if (this.board[i][j] != null) {
					if (this.board[i][j].getColor().equals("W"))
						numWhitePieces++;
					else
						numBlackPieces++;
				}
			}
		}

	}

	/**
	 * @apiNote checks if move is valid
	 * @param originalRow
	 * @param originalColumn
	 * @param newRow
	 * @param newColumn
	 * @return true if the move is: 
	 *         one space fwd, horizontal, diagonal,
	 *         two spaces jumping an opp piece,
	 *         and going to an empty square. 
	 * 		   Otherwise, false
	 */
	public boolean isValidMove(int originalRow, int originalColumn, int newRow, int newColumn) {

		if (board[originalRow][originalColumn] == null) {
			return false;
		}

		int rowDiff = newRow - originalRow;
		int columnDiff = newColumn - originalColumn;

		boolean isntDirectionCorrect = false;

		if (originalRow != newRow) {

			int direction;

			if(board[originalRow][originalColumn].getColor() == "W") {
				direction = 1;
			}else{
				direction = -1;
			}

			isntDirectionCorrect = originalRow * direction < newRow * direction;

			if (!isntDirectionCorrect && board[originalRow][originalColumn].reachedEnd()) {
				isntDirectionCorrect = !isntDirectionCorrect;
			}
		}

		if (!isntDirectionCorrect) {
			return false;
		}

		if ((Math.abs(rowDiff) == 1 || rowDiff == 0) && (columnDiff == 0 || Math.abs(columnDiff) == 1)) {
			return true;
		}

		if ((Math.abs(rowDiff) == 2 || rowDiff == 0) && (Math.abs(columnDiff) == 2 || columnDiff == 0)) {
			if (board[originalRow + (rowDiff / 2)][originalColumn + (columnDiff / 2)] == null) {
				return false;
			}
			if ((board[originalRow + rowDiff / 2][originalColumn + columnDiff / 2].getColor() == "W") != (board[originalRow][originalColumn].getColor() == "W")) {
				return true;
			}

		}
		return false;
	}

	/**
	 * @apiNote moves the piece only if isValidMove is true
	 * @param originalRow
	 * @param originalColumn
	 * @param newRow
	 * @param newColumn
	 * @see isValidMove
	 */
	public void makeMove(int originalRow, int originalColumn, int newRow, int newColumn) {
		int rowDiff = newRow - originalRow;
		int columnDiff = newColumn - originalColumn;

		if (isValidMove(originalRow, originalColumn, newRow, newColumn)) {
			if (Math.abs(rowDiff) == 2 || Math.abs(columnDiff) == 2) {
				if (board[originalRow + (rowDiff / 2)][originalColumn + (columnDiff / 2)].getColor() != board[originalRow][originalColumn].getColor()) {
					if(board[originalRow + (rowDiff / 2)][originalColumn + (columnDiff / 2)].getColor() == "W"){
						numWhitePieces --;
					}else{
						numBlackPieces --;
					}
					board[originalRow + (rowDiff / 2)][originalColumn + (columnDiff / 2)] = null;
				}
			}
			board[newRow][newColumn] = board[originalRow][originalColumn];
			board[originalRow][originalColumn] = null;
		}
	}

	/**
	 * @param row x coordinate of board
	 * @param col y coordinate of board
	 * @return the piece at the given row and col or null if no piece
	 *         is located at that location
	 */
	public CompSciChecker getPiece(int row, int col) {
		return board[row][col];
	}

	/**
	 * @return the field board
	 */
	public CompSciChecker[][] getBoard() {
		return board;
	}

	/**
	 * @return number of white pieces on board
	 */
	public int getNumWhitePieces() {
		return numWhitePieces;
	}

	/**
	 * @return number of black pieces on board
	 */
	public int getNumBlackPieces() {
		return numBlackPieces;
	}

	/**
	 * @return a string representation of the board
	 */
	public String toString() {
		String str = "  _ _ _ _ _ _ _ _\n";
		for (int i = 0; i < board.length; i++) {
			str += i + "|";
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] != null)
					str += board[i][j].getColor();
				else {
					if (i < board.length - 1)
						str += " ";
					else
						str += "_";
				}
				if (j < board[i].length - 1)
					str += " ";
			}
			str += "|\n";
		}
		str += "  0 1 2 3 4 5 6 7\n";
		return str;
	}

}
