package gclembo.tictactoe;

/**
 * This is a Tic Tac Toe game
 */
public class TicTacToe {
    private final char[][] board;
    private boolean isXTurn;
    private char winner;
    private boolean isGameOver;
    private int moves;



    /**
     * Creates a new tic-tac-toe game
     */
    public TicTacToe() {
        this.board = new char[3][3];
        clearBoard();
        this.moves = 0;
        this.isXTurn = true;
        this.winner = '_';
        this.isGameOver = false;
    }

    /**
     * Sets the game board to an empty board
     */
    private void clearBoard() {
        for (int i = 0; i < this.board.length; i++) {
            for (int j = 0; j < this.board[0].length; j++) {
                this.board[i][j] = '_';
            }
        }
    }

    /**
     * @return if it is player X's turn
     */
    public boolean isXTurn() {
        return this.isXTurn;
    }

    /**
     * @return which player X or O is the winner
     * @throws IllegalStateException if the game is not over yet
     */
    public char getWinner() {
        if (!isGameOver) {
            throw new IllegalStateException("Game is not over yet");
        }
        return this.winner;
    }

    /**
     * @return whether the game is over
     */
    public boolean isGameOver() {
        return this.isGameOver;
    }

    /**
     * Makes a move for the given player at the specified row and column
     * @param row row to place move
     * @param col column to place move
     * @throws IllegalArgumentException if the given space is not on the board or
     * if the space is already marked
     */
    public void makeMove(int row, int col) {
        if (row < 0 || row > 2 || col < 0 || col > 2) {
            throw new IllegalArgumentException("Space not on board");
        }
        if (this.board[row][col] != '_') {
            throw new IllegalArgumentException("Space is already full");
        }
        this.board[row][col] = this.isXTurn ? 'X' : 'O';
        this.moves++;
        checkForWinner(row, col);
        this.isXTurn = !this.isXTurn;

        if (moves == 9) {
            this.isGameOver = true;
        }
    }

    /**
     * Checks if either player has 3 markers in a row given location of last move made.
     * Three markers can be horizontal, vertical, or horizontal for a win.
     * @param row row of the last move
     * @param col column of the last move
     */
    private void checkForWinner(int row, int col) {

        // checks row of most recent move
        if (this.board[row][0] == this.board[row][1]
                && this.board[row][1] == this.board[row][2]) {
            this.isGameOver = true;
            this.winner = this.board[row][0];
            return;
        }

        // checks col of most recent move
        if (this.board[0][col] == this.board[2][col]
                && this.board[1][col] == this.board[2][col]) {
            this.isGameOver = true;
            this.winner = this.board[0][col];
            return;
        }

        // checks main diagonal if move is on diagonal
        if (col == row && this.board[0][0] == this.board[1][1]
                && this.board[1][1] == this.board[2][2]) {
            this.winner = this.board[1][1];
            this.isGameOver = true;
        }

        // checks anti diagonal if move is on diagonal
        if (row + col == 2 && this.board[2][0] == this.board[1][1]
                && this.board[1][1] == this.board[0][2]) {
            this.winner = this.board[1][1];
            this.isGameOver = true;
        }
    }
}
