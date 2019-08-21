import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Welcome to Tic Tac Toe!");
        System.out.println("Here's the current board:");
        Board board = new Board();
        Scanner scanner = new Scanner(System.in);
        boolean gameover = false;
        board.initializeBoard();
        do {
            board.printBoard();
            System.out.println("Player one enter your position");
            String player1Input = scanner.nextLine().replaceAll(",","");
            char[] player1Input2 = player1Input.toCharArray();
            int xInputPlayer1 = Character.getNumericValue(player1Input2[0]);
            int yInputPlayer2 = Character.getNumericValue(player1Input2[1]);

        }while(!gameover);
    }
}
