package SnakesLadders.main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Random;

public class Controller {
    @FXML
    private ImageView creditsButton;

    private Stage primaryStage;

    @FXML
    private ImageView exitButton;

    @FXML
    private ImageView startButton;

    @FXML
    void creditsShow(MouseEvent event) {

    }

    @FXML
    void exitGame(MouseEvent event)
    {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("EXIT");
        alert.setHeaderText("Exit Game?");
        alert.setContentText("Are you sure You want to exit?");

        if(alert.showAndWait().get() == ButtonType.OK){
            primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();

            System.out.println("Exiting the game");
            primaryStage.close();
        }
    }
    @FXML
    void startGame(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../../resources/scenes/gameMenu.fxml"));
        //Parent root = FXMLLoader.load(getClass().getResource("../../resources/scenes/startMenu.fxml"));
        Parent root = fxmlLoader.load();
        GameController c = fxmlLoader.getController();
        Random rand = new Random();
        int boardNumber = rand.nextInt(1,6);
        System.out.println(boardNumber);
        c.setUpBoard(boardNumber);
        primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        primaryStage.setScene(new Scene(root,640 ,800));
        primaryStage.setTitle("Snakes & Ladders");
        primaryStage.setResizable(false);
        // Scene startMenu = new Scene(root);
        // primaryStage.setScene(startMenu);
        primaryStage.show();
    }
}
