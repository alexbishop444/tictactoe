import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Welcome to Tic Tac Toe!");
        System.out.println("Here's the current board:");
        Board board = new Board();
        Scanner scanner = new Scanner(System.in);
        boolean gameover;
        board.initializeBoard();
        do {
            board.printBoard();
            System.out.println("Player one enter your position");
            String player1Input = scanner.nextLine().replaceAll(",","");
            char[] player1Input2 = player1Input.toCharArray();
            int xInputPlayer1 = Character.getNumericValue(player1Input2[0]);
            int yInputPlayer1 = Character.getNumericValue(player1Input2[1]);
            board.placeMarkX(xInputPlayer1,yInputPlayer1);
            board.printBoard();
            if (board.gameState()) {
                break;
            }
            System.out.println("Player two enter your position");
            String player2Input = scanner.nextLine().replaceAll(",","");
            char[] player2Input2 = player2Input.toCharArray();
            int xInputPlayer2 = Character.getNumericValue(player2Input2[0]);
            int yInputPlayer2 = Character.getNumericValue(player2Input2[1]);
            board.placeMarkY(xInputPlayer2,yInputPlayer2);
            gameover = board.gameState();
        }while(!gameover);
    }
}
