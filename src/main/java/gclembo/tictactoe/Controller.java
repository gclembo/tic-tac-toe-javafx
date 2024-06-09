package gclembo.tictactoe;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

/**
 * This is a controller which handles user input and output
 */
public class Controller {
    @FXML
    private Label displayLabel;
    @FXML
    private Button restartButton;
    @FXML
    private GridPane board;
    private TicTacToe game;

    /**
     * Constructs controller with a new Tic-Tac-Toe game
     */
    public Controller() {
        game = new TicTacToe();
    }

    /**
     * Initializes controller
     */
    public void initialize() {
        restartButton.setVisible(false);
    }

    /**
     * Starts a new Tic-Tac-Toe game, clearing the previous game
     */
    public void restartGame() {
        game = new TicTacToe();
        restartButton.setVisible(false);
        displayLabel.setText("Welcome to Tic-Tac-Toe");
        for (Node node : board.getChildren()) {
            if (node instanceof Button) {
                ((Button) node).setText("");
            }
        }
    }

    /**
     * Makes a move on the square clicked on the board
     * @param event button press from the square clicked by the user
     */
    public void makeMove(ActionEvent event) {
        Button button = (Button) event.getSource();
        int row = GridPane.getRowIndex(button);
        int col = GridPane.getColumnIndex(button);

        if (!game.isGameOver()) {
            try {
                char playerMarker = game.isXTurn() ? 'X' : 'O';
                game.makeMove(row, col);

                button.setText(playerMarker + "");

                if (game.isGameOver()) {
                    restartButton.setVisible(true);
                    char winner = game.getWinner();
                    if (winner == 'X' || winner == 'O') {
                        displayLabel.setText(game.getWinner() + " has won the game");
                    } else {
                        displayLabel.setText("It's a tie!");
                    }
                }
            } catch (IllegalArgumentException e) {
                displayLabel.setText(e.getMessage());
            } catch (Exception e) {
                displayLabel.setText("An Error Has Occurred");
            }
        }
    }
}