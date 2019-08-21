import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("Duplicates")

public class Board {

    char[][] board;
    char truePlayerMark;
    char falsePlayerMark;
    boolean player;

    public Board() {
        board = new char[3][3];
        truePlayerMark = 'X';
        falsePlayerMark = 'O';
        player = true; //false is X, 0 is True
        initializeBoard();
    }


    // Set/Reset the board back to all empty values.
    public void initializeBoard() {
        // Loop through rows
        for (int i = 0; i < 3; i++) {

            // Loop through columns
            for (int j = 0; j < 3; j++) {
                board[i][j] = '.';
            }
        }
    }


    // Print the current board
    public void printBoard() {
        System.out.println(" ");

        for (int i = 0; i < 3; i++) {
            System.out.print(" ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + "  ");
            }
            System.out.println();
            System.out.println(" ");
        }
    }

    // Player X
    public boolean placeMarkX(int row, int col) {

        // Make sure that row and column are in bounds of the board.
        if ((row >= 0) && (row < 3)) {
            if ((col >= 0) && (col < 3)) {
                if (board[row][col] == '.') {
                    board[row][col] = truePlayerMark;
                    return true;
                }
            }
        }

        return false;
    }

    // Player 0 but should refactor to be in same code as the other one.
    public boolean placeMarkY(int row, int col) {

        // Make sure that row and column are in bounds of the board.
        if ((row >= 0) && (row < 3)) {
            if ((col >= 0) && (col < 3)) {
                if (board[row][col] == '.') {
                    board[row][col] = falsePlayerMark;
                    return true;
                }
            }
        }

        return false;
    }


    public boolean playerYWin() {
        boolean isWin = false;
        if ((board[0][0] == 'O' && board[1][1] == 'O' && board[2][2] == 'O') || (board[2][0] == 'O' && board[1][1] == 'O' && board[0][2] == 'O') ||
                (board[0][0] == 'O' && board[1][0] == 'O' && board[2][0] == 'O') || (board[0][1] == 'O' && board[1][1] == 'O' && board[2][1] == 'O') ||
                (board[0][2] == 'O' && board[1][2] == 'O' && board[2][2] == 'O') || (board[0][0] == 'O' && board[0][1] == 'O' && board[0][2] == 'O') ||
                (board[1][0] == 'O' && board[1][1] == 'O' && board[1][2] == 'O') || (board[2][0] == 'O' && board[2][1] == 'O' && board[2][2] == 'O')
        ) {
            isWin = true;
        }
        return isWin;
    }

    public boolean playerXWin() {
        boolean isWin = false;
        if ((board[0][0] == 'X' && board[1][1] == 'X' && board[2][2] == 'X') || (board[2][0] == 'X' && board[1][1] == 'X' && board[0][2] == 'X') ||
                (board[0][0] == 'X' && board[1][0] == 'X' && board[2][0] == 'X') || (board[0][1] == 'X' && board[1][1] == 'X' && board[2][1] == 'X') ||
                (board[0][2] == 'X' && board[1][2] == 'X' && board[2][2] == 'X') || (board[0][0] == 'X' && board[0][1] == 'X' && board[0][2] == 'X') ||
                (board[1][0] == 'X' && board[1][1] == 'X' && board[1][2] == 'X') || (board[2][0] == 'X' && board[2][1] == 'X' && board[2][2] == 'X')
        ) {
            isWin = true;
        }
        return isWin;
    }

    public boolean isDraw() {
        boolean isDraw = false;
        ArrayList tester = new ArrayList<String>();
        List<char[]> list = Arrays.asList(board);
        if (!playerXWin() && !playerYWin()) {
            for (char[] arr : list) {
                for (char item : arr) {
                    if (Arrays.asList(item).contains('.')) {
                        tester.add(item);

                    } else if (playerXWin() || playerYWin()) {
                        isDraw = false;

                    } else if (!playerXWin() && !playerYWin()) {
                        for (char[] arr1 : list) {
                            for (char item1 : arr1) {
                                if (!Arrays.asList(item1).contains('.')) {
                                    isDraw = true;
                                }
                            }
                        }
                    }
                }
            }
        }
        if(tester.size() >= 1) {
            isDraw = false;
        }

        return isDraw;
    }


    public boolean gameState() {
        boolean gameover = false;
        isDraw();
        if (playerYWin()) {
            gameover = true;
//            printBoard();
            System.out.println("Player two wins!");
        }
        if (playerXWin()) {
            gameover = true;
//            printBoard();
            System.out.println("Player one wins!");
        }
        if (isDraw()) {
            gameover = true;
//            printBoard();
            System.out.println("It's a draw!!");
        }
        return gameover;
    }
}

















//
//  --------------------------------------------  OLD CODE----------------------------------

//    public boolean playerYWin() {
//        boolean isLose = false;
//        for (int i = 0; i < board.length; i++) {
//            if ((board[0][i] == 'O') || (board[1][i] == 'O') || (board[2][i] == 'O') || (board[0][0] == 'O' && board[1][1] != 'O' && board[2][2] == 'O') ||
//                    (board[2][0] == 'O' && board[1][1] == 'O' && board[0][2] == 'O')
//
//            ){
//                isLose = true;
//
//            }
//        }
//            if(isLose) {
//                return false;
//            }
//            return true;
//
//    }
//}

//    public boolean playerXWin() {
//        for (int i = 0; i < board.length; i++) {
//            if((board[0][i] != 'X') && (board[1][i] != 'X') && (board[2][i] != 'X') && (board[0][0] != 'X' && board[1][1] != 'X' && board[2][2] != 'X')
//                    && (board[2][0] != 'X' && board[1][1] != 'X' && board[0][2] != 'X')
//
//            ){
//                return false;
//            }
//        }
//        System.out.println("Player 1 wins");
//        return true;
//    }
//}
//
//    public boolean playerYWin() {
//        boolean isWin = false;
//        for (int i = 0; i < board.length; i++) {
//            for (int j = 0; j < board[i].length ; j++) {
//                if((board[0][j] == 'O') || (board[1][j] == 'O'))  {
//                    isWin = true;
//            }
//
//            }
//        }
//        return isWin;
//    }
//}
