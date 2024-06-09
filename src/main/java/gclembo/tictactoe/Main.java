package gclembo.tictactoe;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * This application runs a tic-tac-toe game
 */
public class Main extends Application {

    /**
     * Runs tic-tac-toe application
     * @param stage stage to display application
     */
    @Override
    public void start(Stage stage) throws IOException {
        // sets FXML
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("main.fxml"));
        Parent root = fxmlLoader.load();

        // sets css styling
        Scene scene = new Scene(root, 600, 600);
        String css = this.getClass().getResource("application.css").toExternalForm();
        scene.getStylesheets().add(css);

        // sets window properties
        stage.getIcons().add(new Image("X.png"));
        stage.setTitle("Tic Tac Toe");

        // displays window
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}