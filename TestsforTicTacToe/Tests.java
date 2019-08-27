import org.junit.*;

public class Tests {
    @Test
    public void playerOneLeftToRightDiagonalWin() {
        //Arrange
        Board board = new Board(3,3);
        board.initializeBoard();
        board.board[0][0] = 'X';
        board.board[1][1] = 'X';
        board.board[2][2] = 'X';
        boolean expected = true;
        //Act
        boolean actual = board.diagonolLeftToRight();

        //Assert
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void playerTwoLeftToRightDiagonalWin() {

        //Arrange
        Board board = new Board(3,3);
        board.initializeBoard();
        board.board[0][0] = 'O';
        board.board[1][1] = 'O';
        board.board[2][2] = 'O';
        boolean expected = true;
        //Act
        boolean actual = board.diagonolLeftToRight();

        //Assert
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void playerOneVerticalWin() {
        //Arrange
        Board board = new Board(8,8);
        board.initializeBoard();
        board.board[0][0] = 'X';
        board.board[1][0] = 'X';
        board.board[2][0] = 'X';
        boolean expected = true;
        //Act
        boolean actual = board.vertical();

        //Assert
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void playerTwoVerticalWin() {
        //Arrange
        Board board = new Board(7,7);
        board.initializeBoard();
        board.board[0][0] = 'O';
        board.board[1][0] = 'O';
        board.board[2][0] = 'O';
        boolean expected = true;
        //Act
        boolean actual = board.vertical();

        //Assert
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void playerOneHorizontalWin() {
        //Arrange
        Board board = new Board(3,3);
        board.initializeBoard();
        board.board[1][0] = 'X';
        board.board[1][1] = 'X';
        board.board[1][2] = 'X';
        boolean expected = true;
        //Act
        boolean actual = board.horizontal();

        //Assert
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void playerTwoHorizontalWin() {
        //Arrange
        Board board = new Board(3,3);
        board.initializeBoard();
        board.board[1][0] = 'O';
        board.board[1][1] = 'O';
        board.board[1][2] = 'O';
        boolean expected = true;
        //Act
        boolean actual = board.horizontal();

        //Assert
        Assert.assertEquals(expected,actual);
    }
}
