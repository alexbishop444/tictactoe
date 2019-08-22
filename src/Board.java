import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("Duplicates")

public class Board {

    char[][] board;
    char truePlayerMark;
    char falsePlayerMark;
    boolean player;
    char blankChar = '.';

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
    boolean placed = false;
        // Make sure that row and column are in bounds of the board.
        if ((row >= 0) && (row < 3)) {
            if ((col >= 0) && (col < 3)) {
                if (board[row][col] == '.' && board[row][col] != 'X' && board[row][col] != 'O') {
                    board[row][col] = truePlayerMark;
                    placed = true;
                } else {
                    placed = false;
                    System.out.println("There is already a piece there!");
                }
            }
        }

        return placed;
    }

    // Player 0 but should refactor to be in same code as the other one.
    public boolean placeMarkY(int row, int col) {
        boolean placed = false;
        // Make sure that row and column are in bounds of the board.
        if ((row >= 0) && (row < 3)) {
            if ((col >= 0) && (col < 3)) {
                if (board[row][col] == '.' && board[row][col] != 'X' && board[row][col] != 'O') {
                    board[row][col] = falsePlayerMark;
                    placed = true;
                } else {
                    placed = false;
                    System.out.println("There is already a piece there!");
                }
            }
        }
        return placed;
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

    private boolean horizontal() {
        for(int i=0;i < board.length; i++) {
            if(IsAllEqual(board[i]))
                return true;
        }
        return false;
    }

    private boolean diagonolLeftToRight() {
        char[] array = new char[board.length];
        for(int i=0;i < board.length; i++) {
                array[i] = board[i][i];
        }
        if(IsAllEqual(array)) {
            return true;
        }
        return false;
    }

    private boolean diagonolRightToLeft() {
        char[] array = new char[board.length];
        int goHere = board.length -1;
        int start = -1;
        for(int i=goHere;i >= 0; i--) {
            start++;
            array[i] = board[i][start];
        }
        if(IsAllEqual(array)) {
            return true;
        }
        return false;
    }

    private boolean vertical() {
        char[] array = new char[board.length];
        for(int i=0;i < board.length; i++) {
            for (int j = 0; j <board.length ; j++) {
                array[i] = board[j][i];
            }
            if(IsAllEqual(array)) {
                return true;
            }
        }
        return false;
    }

    private Boolean IsAllEqual(char[] line)
    {
        for (int i=1; i < line.length; i++){
            char currentChar = line[i];
            if (currentChar == blankChar || line[0] != currentChar){
                return false;
            }
        }
        return true;
    }




    public boolean gameState() {
        boolean gameover = false;
        isDraw();
        if (diagonolRightToLeft()) {
            gameover = true;
//            printBoard();
            System.out.println("Game over!");
        }
        if (diagonolLeftToRight()) {
            gameover = true;
//            printBoard();
            System.out.println("Game over!");
        }
        if (horizontal()) {
            gameover = true;
            System.out.println("Game over!");
        }
        if (vertical()) {
            gameover = true;
            System.out.println("Game over!");
        }
        if (isDraw()) {
            gameover = true;
//            printBoard();
            System.out.println("It's a draw!!");
        }
        return gameover;
    }

    public boolean validateInput(char[] input) {
        boolean validInput;
        if ((input.length == 2) && (Character.isDigit(input[0]) && Character.isDigit(input[1]))) {
                validInput = true;
        } else {
            validInput = false;
        }
        return validInput;
    }
}

//&& (input[0] <= 2) && (input[1] <= 2)
















//
//  --------------------------------------------  OLD CODE----------------------------------



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
