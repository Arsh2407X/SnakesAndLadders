package SnakesLadders.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../../resources/scenes/startMenu.fxml"));
        //Parent root = FXMLLoader.load(getClass().getResource("../../resources/scenes/startMenu.fxml"));
        Parent root = fxmlLoader.load();
        Controller c = fxmlLoader.getController();
        primaryStage.setScene(new Scene(root,640 ,800));
        primaryStage.setTitle("Snakes & Ladders");
        primaryStage.setResizable(false);
        //Scene startMenu = new Scene(root);
//        primaryStage.setScene(startMenu);
        primaryStage.show();

        primaryStage.setOnCloseRequest(event->
        {   event.consume();
            exit(primaryStage);
        });
    }

    void exit(Stage stage)
    {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("EXIT");
        alert.setHeaderText("Exit Game?");
        alert.setContentText("Are you sure You want to exit?");

        if(alert.showAndWait().get() == ButtonType.OK){

            System.out.println("Exiting the game");
            stage.close();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
