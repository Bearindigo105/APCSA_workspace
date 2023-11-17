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

public class CompSciCheckerUnitTests {

    // *****FILL IN THE FOLLOWING VARIABLE********/
    private static String fullName = "Muthu Subhash Muthu";

    // ******DO NOT CHANGE ANYTHING BELOW THIS LINE OR YOUR SUBMISSION WILL BE
    // INCORRECT**********/

    private CompSciChecker[][] testBoard;
    private static int correctTests;
    private static int totalTests;
    private static int nameHash;
    private static boolean check;

    @Test
    public void TestConstructorSetup() {
        char[][] setup = {
                { 'W', ' ', 'W', ' ', 'W', ' ', 'W', ' ' },
                { ' ', 'W', ' ', 'W', ' ', 'W', ' ', 'W' },
                { 'W', ' ', 'W', ' ', 'W', ' ', 'W', ' ' },
                { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
                { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
                { ' ', 'B', ' ', 'B', ' ', 'B', ' ', 'B' },
                { 'B', ' ', 'B', ' ', 'B', ' ', 'B', ' ' },
                { ' ', 'B', ' ', 'B', ' ', 'B', ' ', 'B' }

        };

        CompSciCheckerBoard board = new CompSciCheckerBoard();
        CompSciCheckerBoard expected = new CompSciCheckerBoard(createBoard(setup));

        assertEquals(expected.toString(), board.toString());
        assertEquals(12, board.getNumBlackPieces());
        assertEquals(12, board.getNumWhitePieces());
        check = true;
    }

    @Test
    public void TestValidMoveOccuppied() {
        CompSciCheckerBoard board = new CompSciCheckerBoard();
        boolean result = board.isValidMove(0, 0, 1, 1);
        assertEquals(false, result);
        check = true;
    }

    @Test
    public void TestValidMoveLeftEdge() {
        CompSciCheckerBoard board = new CompSciCheckerBoard();
        boolean result = board.isValidMove(2, 0, 0, -1);
        assertEquals(false, result);
        check = true;
    }

    @Test
    public void TestValidMoveTopEdge() {
        CompSciCheckerBoard board = new CompSciCheckerBoard();
        boolean result = board.isValidMove(0, 4, -1, 0);
        assertEquals(false, result);
        check = true;
    }

    @Test
    public void TestValidMoveRightEdge() {
        CompSciCheckerBoard board = new CompSciCheckerBoard();
        boolean result = board.isValidMove(5, 7, 6, 5);
        assertEquals(false, result);
        check = true;
    }

    @Test
    public void TestValidMoveBottomEdge() {
        CompSciCheckerBoard board = new CompSciCheckerBoard();
        boolean result = board.isValidMove(7, 5, 8, 5);
        assertEquals(false, result);
        check = true;
    }

    @Test
    public void TestValidMoveOccuppied2() {
        CompSciCheckerBoard board = new CompSciCheckerBoard();
        boolean result = board.isValidMove(1, 1, 2, 2);
        assertEquals(false, result);
        check = true;
    }

    @Test
    public void TestValidMoveBackwards() {
        CompSciCheckerBoard board = new CompSciCheckerBoard();
        boolean result = board.isValidMove(6, 4, 7, 4);
        assertEquals(false, result);
        check = true;
    }

    @Test
    public void TestValidMoveBackwards2() {
        CompSciCheckerBoard board = new CompSciCheckerBoard();
        boolean result = board.isValidMove(2, 4, 1, 4);
        assertEquals(false, result);
        check = true;
    }

    @Test
    public void TestValidMoveBackwards3() {
        CompSciCheckerBoard board = new CompSciCheckerBoard();
        board.getBoard()[0][2].setReachedEnd(true);
        boolean result = board.isValidMove(0, 2, -1, 2);
        assertEquals(false, result);
        check = true;
    }

    @Test
    public void TestValidMoveBackwards4() {
        CompSciCheckerBoard board = new CompSciCheckerBoard();
        board.getBoard()[2][0].setReachedEnd(true);
        boolean result = board.isValidMove(2, 0, 1, -1);
        assertEquals(false, result);
        check = true;
    }

    @Test
    public void TestValidMoveBackwards5() {
        CompSciCheckerBoard board = new CompSciCheckerBoard();
        board.getBoard()[7][1].setReachedEnd(true);
        boolean result = board.isValidMove(7, 1, 8, 1);
        assertEquals(false, result);
        check = true;
    }

    @Test
    public void TestValidMoveBackwards6() {
        CompSciCheckerBoard board = new CompSciCheckerBoard();
        board.getBoard()[5][7].setReachedEnd(true);
        boolean result = board.isValidMove(5, 7, 6, 8);
        assertEquals(false, result);
        check = true;
    }

    @Test
    public void TestValidMoveBackwards7() {
        CompSciCheckerBoard board = new CompSciCheckerBoard();
        board.getBoard()[2][6].setReachedEnd(true);
        boolean result = board.isValidMove(2, 6, 1, 6);
        assertEquals(true, result);
        check = true;
    }

    @Test
    public void TestValidMoveBackwards8() {
        CompSciCheckerBoard board = new CompSciCheckerBoard();
        board.getBoard()[6][2].setReachedEnd(true);
        boolean result = board.isValidMove(6, 2, 7, 2);
        assertEquals(true, result);
        check = true;
    }

    @Test
    public void TestValidMoveBackwards9() {
        CompSciCheckerBoard board = new CompSciCheckerBoard();
        board.getBoard()[1][1] = null;
        board.getBoard()[2][2].setReachedEnd(true);
        boolean result = board.isValidMove(2, 2, 1, 1);
        assertEquals(true, result);
        check = true;
    }

    @Test
    public void TestValidMoveBackwards10() {
        CompSciCheckerBoard board = new CompSciCheckerBoard();
        board.getBoard()[7][5] = null;
        board.getBoard()[6][6].setReachedEnd(true);
        boolean result = board.isValidMove(6, 6, 7, 5);
        assertEquals(true, result);
        check = true;
    }

    @Test
    public void TestValidMoveForwards1() {
        CompSciCheckerBoard board = new CompSciCheckerBoard();
        boolean result = board.isValidMove(2, 2, 3, 1);
        assertEquals(true, result);
        check = true;
    }

    @Test
    public void TestValidMoveForwards2() {
        CompSciCheckerBoard board = new CompSciCheckerBoard();
        boolean result = board.isValidMove(2, 2, 3, 2);
        assertEquals(true, result);
        check = true;
    }

    @Test
    public void TestValidMoveForwards3() {
        CompSciCheckerBoard board = new CompSciCheckerBoard();
        boolean result = board.isValidMove(2, 2, 3, 3);
        assertEquals(true, result);
        check = true;
    }

    @Test
    public void TestValidMoveForwards4() {
        CompSciCheckerBoard board = new CompSciCheckerBoard();
        boolean result = board.isValidMove(5, 5, 4, 4);
        assertEquals(true, result);
        check = true;
    }

    @Test
    public void TestValidMoveForwards5() {
        CompSciCheckerBoard board = new CompSciCheckerBoard();
        boolean result = board.isValidMove(5, 5, 4, 5);
        assertEquals(true, result);
        check = true;
    }

    @Test
    public void TestValidMoveForwards6() {
        CompSciCheckerBoard board = new CompSciCheckerBoard();
        boolean result = board.isValidMove(5, 5, 4, 6);
        assertEquals(true, result);
        check = true;
    }

    @Test
    public void TestValidMoveHorizontal1() {
        CompSciCheckerBoard board = new CompSciCheckerBoard();
        boolean result = board.isValidMove(5, 5, 5, 4);
        assertEquals(true, result);
        check = true;
    }

    @Test
    public void TestValidMoveHorizontal2() {
        CompSciCheckerBoard board = new CompSciCheckerBoard();
        boolean result = board.isValidMove(5, 5, 5, 6);
        assertEquals(true, result);
        check = true;
    }

    @Test
    public void TestValidMoveHorizontal3() {
        CompSciCheckerBoard board = new CompSciCheckerBoard();
        boolean result = board.isValidMove(1, 5, 1, 4);
        assertEquals(true, result);
        check = true;
    }

    @Test
    public void TestValidMoveHorizontal4() {
        CompSciCheckerBoard board = new CompSciCheckerBoard();
        boolean result = board.isValidMove(1, 5, 1, 6);
        assertEquals(true, result);
        check = true;
    }

    @Test
    public void TestValidMoveJump1() {
        CompSciCheckerBoard board = new CompSciCheckerBoard();
        board.getBoard()[3][3] = new CompSciChecker("B");
        boolean result = board.isValidMove(2, 2, 4, 4);
        assertEquals(true, result);
        check = true;
    }

    @Test
    public void TestValidMoveJump2() {
        CompSciCheckerBoard board = new CompSciCheckerBoard();
        board.getBoard()[3][2] = new CompSciChecker("B");
        boolean result = board.isValidMove(2, 2, 4, 2);
        assertEquals(true, result);
        check = true;
    }

    @Test
    public void TestValidMoveJump3() {
        CompSciCheckerBoard board = new CompSciCheckerBoard();
        board.getBoard()[3][1] = new CompSciChecker("B");
        boolean result = board.isValidMove(2, 2, 4, 0);
        assertEquals(true, result);
        check = true;
    }

    @Test
    public void TestValidMoveJump4() {
        CompSciCheckerBoard board = new CompSciCheckerBoard();
        board.getBoard()[3][3] = new CompSciChecker("B");
        board.getBoard()[3][2] = new CompSciChecker("W");
        boolean result = board.isValidMove(3, 2, 3, 4);
        assertEquals(true, result);
        check = true;
    }

    @Test
    public void TestValidMoveJump5() {
        CompSciCheckerBoard board = new CompSciCheckerBoard();
        board.getBoard()[3][3] = new CompSciChecker("W");
        board.getBoard()[3][2] = new CompSciChecker("B");
        boolean result = board.isValidMove(3, 3, 3, 1);
        assertEquals(true, result);
        check = true;
    }

    @Test
    public void TestValidMoveJump6() {
        CompSciCheckerBoard board = new CompSciCheckerBoard();
        board.getBoard()[3][3] = new CompSciChecker("B");
        board.getBoard()[3][2] = new CompSciChecker("B");
        boolean result = board.isValidMove(2, 2, 4, 3);
        assertEquals(false, result);
        check = true;
    }

    @Test
    public void TestValidMoveJump7() {
        CompSciCheckerBoard board = new CompSciCheckerBoard();
        board.getBoard()[3][1] = new CompSciChecker("B");
        board.getBoard()[2][1] = new CompSciChecker("B");
        boolean result = board.isValidMove(2, 2, 3, 0);
        assertEquals(false, result);
        check = true;
    }

    @Test
    public void TestValidMoveJump8() {
        CompSciCheckerBoard board = new CompSciCheckerBoard();
        board.getBoard()[3][2] = new CompSciChecker("B");
        boolean result = board.isValidMove(3, 2, 5, 2);
        assertEquals(false, result);
        check = true;
    }

    @Test
    public void TestValidMoveJump9() {
        CompSciCheckerBoard board = new CompSciCheckerBoard();
        board.getBoard()[6][1] = new CompSciChecker("W");
        board.getBoard()[6][1].setReachedEnd(true);
        boolean result = board.isValidMove(6, 1, 4, 1);
        assertEquals(true, result);
        check = true;
    }

    @Test
    public void TestValidMoveJump10() {
        CompSciCheckerBoard board = new CompSciCheckerBoard();
        board.getBoard()[6][6] = new CompSciChecker("W");
        board.getBoard()[6][6].setReachedEnd(true);
        boolean result = board.isValidMove(6, 6, 4, 4);
        assertEquals(true, result);
        check = true;
    }

    @Test
    public void TestValidMoveJump11() {
        CompSciCheckerBoard board = new CompSciCheckerBoard();
        board.getBoard()[6][1] = new CompSciChecker("W");
        board.getBoard()[6][1].setReachedEnd(true);
        boolean result = board.isValidMove(6, 1, 4, 1);
        assertEquals(true, result);
        check = true;
    }

    @Test
    public void TestValidMoveJump12() {
        CompSciCheckerBoard board = new CompSciCheckerBoard();
        board.getBoard()[6][5] = new CompSciChecker("W");
        board.getBoard()[5][4] = new CompSciChecker("B");
        board.getBoard()[6][5].setReachedEnd(true);
        boolean result = board.isValidMove(6, 5, 4, 4);
        assertEquals(false, result);
        check = true;
    }

    @Test
    public void TestValidMoveJump13() {
        CompSciCheckerBoard board = new CompSciCheckerBoard();
        board.getBoard()[4][2] = new CompSciChecker("W");
        boolean result = board.isValidMove(5, 3, 3, 1);
        assertEquals(true, result);
        check = true;
    }

    @Test
    public void TestValidMoveJump14() {
        CompSciCheckerBoard board = new CompSciCheckerBoard();
        board.getBoard()[4][5] = new CompSciChecker("W");
        boolean result = board.isValidMove(5, 5, 3, 5);
        assertEquals(true, result);
        check = true;
    }

    @Test
    public void TestValidMoveJump15() {
        CompSciCheckerBoard board = new CompSciCheckerBoard();
        board.getBoard()[4][2] = new CompSciChecker("W");
        boolean result = board.isValidMove(5, 1, 3, 3);
        assertEquals(true, result);
        check = true;
    }

    @Test
    public void TestValidMoveJump16() {
        CompSciCheckerBoard board = new CompSciCheckerBoard();
        board.getBoard()[3][3] = new CompSciChecker("W");
        board.getBoard()[3][2] = new CompSciChecker("B");
        boolean result = board.isValidMove(3, 2, 3, 4);
        assertEquals(true, result);
        check = true;
    }

    @Test
    public void TestValidMoveJump17() {
        CompSciCheckerBoard board = new CompSciCheckerBoard();
        board.getBoard()[3][3] = new CompSciChecker("B");
        board.getBoard()[3][2] = new CompSciChecker("W");
        boolean result = board.isValidMove(3, 3, 3, 1);
        assertEquals(true, result);
        check = true;
    }

    @Test
    public void TestValidMoveJump18() {
        CompSciCheckerBoard board = new CompSciCheckerBoard();
        board.getBoard()[4][3] = new CompSciChecker("W");
        board.getBoard()[4][2] = new CompSciChecker("W");
        boolean result = board.isValidMove(5, 3, 3, 2);
        assertEquals(false, result);
        check = true;
    }

    @Test
    public void TestValidMoveJump19() {
        CompSciCheckerBoard board = new CompSciCheckerBoard();
        board.getBoard()[5][6] = new CompSciChecker("W");
        board.getBoard()[4][6] = new CompSciChecker("W");
        boolean result = board.isValidMove(5, 5, 4, 7);
        assertEquals(false, result);
        check = true;
    }

    @Test
    public void TestValidMoveJump20() {
        CompSciCheckerBoard board = new CompSciCheckerBoard();
        board.getBoard()[4][1] = new CompSciChecker("W");
        board.getBoard()[3][1] = new CompSciChecker("W");
        boolean result = board.isValidMove(5, 1, 2, 1);
        assertEquals(false, result);
        check = true;
    }

    @Test
    public void TestValidMoveJump21() {
        CompSciCheckerBoard board = new CompSciCheckerBoard();
        board.getBoard()[1][2] = new CompSciChecker("W");
        board.getBoard()[1][2].setReachedEnd(true);
        boolean result = board.isValidMove(1, 2, 3, 2);
        assertEquals(false, result);
        check = true;
    }

    @Test
    public void TestValidMoveJump22() {
        CompSciCheckerBoard board = new CompSciCheckerBoard();
        board.getBoard()[1][1] = new CompSciChecker("B");
        board.getBoard()[1][1].setReachedEnd(true);
        boolean result = board.isValidMove(1, 1, 3, 3);
        assertEquals(true, result);
        check = true;
    }

    @Test
    public void TestValidMoveJump23() {
        CompSciCheckerBoard board = new CompSciCheckerBoard();
        board.getBoard()[2][0] = new CompSciChecker("B");
        boolean result = board.isValidMove(1, 1, 3, -1);
        assertEquals(false, result);
        check = true;
    }

    @Test
    public void TestValidMoveJump24() {
        CompSciCheckerBoard board = new CompSciCheckerBoard();
        board.getBoard()[1][7] = new CompSciChecker("B");
        boolean result = board.isValidMove(0, 6, 2, 8);
        assertEquals(false, result);
        check = true;
    }

    @Test
    public void TestValidMoveJump25() {
        CompSciCheckerBoard board = new CompSciCheckerBoard();
        board.getBoard()[1][7] = new CompSciChecker("B");
        boolean result = board.isValidMove(0, 6, 2, 8);
        assertEquals(false, result);
        check = true;
    }

    @Test
    public void TestValidMoveBoardunchanged() {
        CompSciCheckerBoard board = new CompSciCheckerBoard();
        String before = board.toString();
        board.isValidMove(1, 1, 2, 1);
        assertEquals(before, board.toString());
        check = true;
    }

    @Test
    public void TestValidMoveEmptyOrigin() {
        CompSciCheckerBoard board = new CompSciCheckerBoard();
        boolean result = board.isValidMove(5, 2, 4, 2);
        assertEquals(false, result);
        check = true;
    }

    @Test
    public void TestMakeMoveInvalidMove() {
        CompSciCheckerBoard board = new CompSciCheckerBoard();
        board.getBoard()[3][2] = new CompSciChecker("B");
        String original = board.toString();
        board.makeMove(2, 2, 3, 2);
        assertEquals(original, board.toString());
        check = true;
    }

    @Test
    public void TestMakeMovePieceMoved() {
        CompSciCheckerBoard originalBoard = new CompSciCheckerBoard();
        CompSciCheckerBoard testBoard = new CompSciCheckerBoard();
        originalBoard.getBoard()[3][4] = originalBoard.getBoard()[2][4];
        originalBoard.getBoard()[2][4] = null;
        String original = originalBoard.toString();
        testBoard.makeMove(2, 4, 3, 4);
        assertEquals(original, testBoard.toString());
        check = true;
    }

    @Test
    public void TestMakeMovePieceMoved2() {
        CompSciCheckerBoard originalBoard = new CompSciCheckerBoard();
        CompSciCheckerBoard testBoard = new CompSciCheckerBoard();
        originalBoard.getBoard()[5][2] = originalBoard.getBoard()[6][2];
        originalBoard.getBoard()[6][2] = null;
        String original = originalBoard.toString();
        testBoard.makeMove(6, 2, 5, 2);
        assertEquals(original, testBoard.toString());
        check = true;
    }

    @Test
    public void TestMakeMovePieceMoved3() {
        CompSciCheckerBoard originalBoard = new CompSciCheckerBoard();
        CompSciCheckerBoard testBoard = new CompSciCheckerBoard();
        originalBoard.getBoard()[4][2] = originalBoard.getBoard()[2][2];
        originalBoard.getBoard()[2][2] = null;
        originalBoard.getBoard()[4][4] = originalBoard.getBoard()[5][3];
        originalBoard.getBoard()[5][3] = null;
        String original = originalBoard.toString();
        testBoard.makeMove(2, 2, 3, 2);
        testBoard.makeMove(3, 2, 4, 2);
        testBoard.makeMove(5, 3, 4, 4);
        assertEquals(original, testBoard.toString());
        check = true;
    }

    @Test
    public void TestMakeMoveUpdateReachedEnd() {
        CompSciCheckerBoard testBoard = new CompSciCheckerBoard();
        testBoard.getBoard()[1][5] = testBoard.getBoard()[5][1];
        testBoard.getBoard()[5][1] = null;
        assertEquals(false, testBoard.getBoard()[1][5].reachedEnd());
        testBoard.makeMove(1, 5, 0, 5);
        assertEquals(true, testBoard.getBoard()[0][5].reachedEnd());
        check = true;
    }

    @Test
    public void TestMakeMoveUpdateAfterReachedEnd() {
        CompSciCheckerBoard originalBoard = new CompSciCheckerBoard();
        CompSciCheckerBoard testBoard = new CompSciCheckerBoard();
        testBoard.getBoard()[1][5] = testBoard.getBoard()[5][1];
        testBoard.getBoard()[5][1] = null;
        originalBoard.getBoard()[1][4] = originalBoard.getBoard()[5][1];
        originalBoard.getBoard()[5][1] = null;
        originalBoard.getBoard()[1][5] = null;
        String original = originalBoard.toString();
        testBoard.makeMove(1, 5, 0, 5);
        testBoard.makeMove(0, 5, 1, 4);
        assertEquals(original, testBoard.toString());
        check = true;
    }

    @Test
    public void TestMakeMoveJumpUpdate1() {
        CompSciCheckerBoard originalBoard = new CompSciCheckerBoard();
        CompSciCheckerBoard testBoard = new CompSciCheckerBoard();
        originalBoard.getBoard()[4][2] = originalBoard.getBoard()[2][4];
        originalBoard.getBoard()[2][4] = null;
        String original = originalBoard.toString();
        testBoard.getBoard()[3][3] = new CompSciChecker("B");
        testBoard.makeMove(2, 4, 4, 2);
        assertEquals(original, testBoard.toString());
        check = true;
    }

    @Test
    public void TestMakeMoveJumpUpdate2() {
        CompSciCheckerBoard originalBoard = new CompSciCheckerBoard();
        CompSciCheckerBoard testBoard = new CompSciCheckerBoard();
        originalBoard.getBoard()[4][4] = originalBoard.getBoard()[2][4];
        originalBoard.getBoard()[2][4] = null;
        String original = originalBoard.toString();
        testBoard.getBoard()[3][4] = new CompSciChecker("B");
        testBoard.makeMove(2, 4, 4, 4);
        assertEquals(original, testBoard.toString());
        check = true;
    }

    @Test
    public void TestMakeMoveJumpUpdate3() {
        CompSciCheckerBoard originalBoard = new CompSciCheckerBoard();
        CompSciCheckerBoard testBoard = new CompSciCheckerBoard();
        originalBoard.getBoard()[4][6] = originalBoard.getBoard()[2][4];
        originalBoard.getBoard()[2][4] = null;
        String original = originalBoard.toString();
        testBoard.getBoard()[3][5] = new CompSciChecker("B");
        testBoard.makeMove(2, 4, 4, 6);
        assertEquals(original, testBoard.toString());
        check = true;
    }

    @Test
    public void TestMakeMoveJumpUpdate4() {
        CompSciCheckerBoard originalBoard = new CompSciCheckerBoard();
        CompSciCheckerBoard testBoard = new CompSciCheckerBoard();
        originalBoard.getBoard()[0][4] = null;
        String original = originalBoard.toString();
        testBoard.getBoard()[0][5] = new CompSciChecker("B");
        testBoard.getBoard()[0][6] = null;
        testBoard.makeMove(0, 4, 0, 6);
        assertEquals(original, testBoard.toString());
        check = true;
    }

    @Test
    public void TestMakeMoveJumpUpdate5() {
        CompSciCheckerBoard originalBoard = new CompSciCheckerBoard();
        CompSciCheckerBoard testBoard = new CompSciCheckerBoard();
        originalBoard.getBoard()[0][2] = null;
        String original = originalBoard.toString();
        testBoard.getBoard()[0][1] = new CompSciChecker("B");
        testBoard.getBoard()[0][0] = null;
        testBoard.makeMove(0, 2, 0, 0);
        assertEquals(original, testBoard.toString());
        check = true;
    }

    @Test
    public void TestMakeMoveJumpUpdate6() {
        CompSciCheckerBoard originalBoard = new CompSciCheckerBoard();
        CompSciCheckerBoard testBoard = new CompSciCheckerBoard();
        originalBoard.getBoard()[3][3] = originalBoard.getBoard()[5][5];
        originalBoard.getBoard()[5][5] = null;
        String original = originalBoard.toString();
        testBoard.getBoard()[4][4] = new CompSciChecker("W");
        testBoard.makeMove(5, 5, 3, 3);
        assertEquals(original, testBoard.toString());
        check = true;
    }

    @Test
    public void TestMakeMoveJumpUpdate7() {
        CompSciCheckerBoard originalBoard = new CompSciCheckerBoard();
        CompSciCheckerBoard testBoard = new CompSciCheckerBoard();
        originalBoard.getBoard()[3][5] = originalBoard.getBoard()[5][5];
        originalBoard.getBoard()[5][5] = null;
        String original = originalBoard.toString();
        testBoard.getBoard()[4][5] = new CompSciChecker("W");
        testBoard.makeMove(5, 5, 3, 5);
        assertEquals(original, testBoard.toString());
        check = true;
    }

    @Test
    public void TestMakeMoveJumpUpdate8() {
        CompSciCheckerBoard originalBoard = new CompSciCheckerBoard();
        CompSciCheckerBoard testBoard = new CompSciCheckerBoard();
        originalBoard.getBoard()[3][7] = originalBoard.getBoard()[5][5];
        originalBoard.getBoard()[5][5] = null;
        String original = originalBoard.toString();
        testBoard.getBoard()[4][6] = new CompSciChecker("W");
        testBoard.makeMove(5, 5, 3, 7);
        assertEquals(original, testBoard.toString());
        check = true;
    }

    @Test
    public void TestMakeMoveUpdateNumPieces() {
        CompSciCheckerBoard testBoard = new CompSciCheckerBoard();
        assertEquals(12, testBoard.getNumBlackPieces());
        testBoard.makeMove(5, 3, 4, 3);
        testBoard.makeMove(4, 3, 3, 3);
        testBoard.makeMove(2, 2, 4, 4);
        assertEquals(11, testBoard.getNumBlackPieces());
        check = true;
    }

    @Test
    public void TestMakeMoveUpdateNumPieces2() {
        CompSciCheckerBoard testBoard = new CompSciCheckerBoard();
        assertEquals(12, testBoard.getNumWhitePieces());
        testBoard.makeMove(2, 2, 3, 2);
        testBoard.makeMove(3, 2, 4, 2);
        testBoard.makeMove(5, 1, 3, 3);
        assertEquals(11, testBoard.getNumWhitePieces());
        check = true;
    }

    @Test
    public void TestMakeMoveUpdateMultipleMoves() {
        CompSciCheckerBoard originalBoard = new CompSciCheckerBoard();
        originalBoard.getBoard()[2][2] = null;
        originalBoard.getBoard()[7][4] = originalBoard.getBoard()[7][5];
        originalBoard.getBoard()[7][5] = null;
        originalBoard.getBoard()[6][2] = null;
        originalBoard.getBoard()[4][4] = originalBoard.getBoard()[6][4];
        originalBoard.getBoard()[6][4] = null;
        originalBoard.getBoard()[7][3] = null;
        String originalString = originalBoard.toString();
        CompSciCheckerBoard testBoard = new CompSciCheckerBoard();
        assertEquals(12, testBoard.getNumWhitePieces());
        assertEquals(12, testBoard.getNumWhitePieces());
        testBoard.makeMove(2, 2, 3, 2);
        testBoard.makeMove(3, 2, 4, 2);
        testBoard.makeMove(4, 2, 5, 2);
        testBoard.makeMove(5, 2, 7, 2);
        testBoard.makeMove(7, 5, 7, 4);
        testBoard.makeMove(7, 2, 7, 4);
        testBoard.makeMove(7, 3, 6, 3);
        testBoard.makeMove(3, 2, 4, 2);
        testBoard.makeMove(7, 2, 5, 4);
        testBoard.makeMove(6, 4, 4, 4);
        assertEquals(11, testBoard.getNumWhitePieces());
        assertEquals(10, testBoard.getNumBlackPieces());
        assertEquals(originalString, testBoard.toString());
        check = true;
    }

    // ************************************************************************/
    @Before
    public void setup() {
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

    @BeforeClass
    public static void getStarted() {
        nameHash = fullName.hashCode();
        correctTests = nameHash;
    }

    @AfterClass
    public static void finish() throws FileNotFoundException {
        PrintWriter out = new PrintWriter("Project_CompSciChecker/" + fullName + "_chess_output.txt");
        String output = fullName + ":" + correctTests + ":*****:" + nameHash + ":";
        String fileString = "";
        Scanner file = new Scanner(new File("Project_CompSciChecker/CompSciCheckerUnitTests.java"));
        while (file.hasNextLine()) {
            fileString += file.nextLine();
        }
        fileString = fileString.substring(fileString.indexOf("INCORRECT**********/"));
        output += output.hashCode();
        output += ":" + fileString.hashCode();
        out.write(output);
        out.close();
    }

    public CompSciChecker[][] createBoard(char[][] s) {
        CompSciChecker[][] board = new CompSciChecker[s.length][s[0].length];
        for (int i = 0; i < s.length; i++) {
            System.out.print("testing");
            for (int j = 0; j < s[0].length; j++) {
                if (s[i][j] == ' ') {
                    board[i][j] = null;
                } else if (s[i][j] == 'W') {
                    board[i][j] = new CompSciChecker("W");
                } else if (s[i][j] == 'B') {
                    board[i][j] = new CompSciChecker("B");
                } else {
                    throw new IllegalArgumentException();
                }
            }
        }
        return board;
    }
}
