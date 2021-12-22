package SnakesLadders.main;

import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private ImageView intro;

    @FXML
    private ImageView creditsButton;

    private Stage primaryStage;

    @FXML
    private ImageView exitButton;

    @FXML
    private ImageView startButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Thread th1 = new Thread()
        {
            public void run()
            {
                intro.setVisible(true);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                FadeTransition fade = new FadeTransition();
                fade.setDuration(Duration.millis(500));

                fade.setFromValue(10);
                fade.setToValue(0);
                fade.setNode(intro);
                fade.play();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                intro.setX(10000);
                intro.setY(10000);
            }
        };

        th1.start();

    }
    @FXML
    void creditsShow(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../../resources/scenes/creditScene.fxml"));
        Parent root = fxmlLoader.load();
        primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        primaryStage.setScene(new Scene(root,640 ,800));
        primaryStage.setTitle("Snakes & Ladders");
        primaryStage.setResizable(false);
        primaryStage.show();
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

        // Initializing boards
        Board board1 = new Board(1);
        setUp1(board1);

        Board board2 = new Board(2);
        setUp2(board2);

        Board board3 = new Board(3);
        setUp3(board3);

        Board board4 = new Board(4);
        setUp4(board4);

        Board board5 = new Board(5);
        setUp5(board5);

        ArrayList<Board> boards = new ArrayList<>();
        boards.add(board1);
        boards.add(board2);
        boards.add(board3);
        boards.add(board4);
        boards.add(board5);

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../../resources/scenes/gameMenu.fxml"));
        Parent root = fxmlLoader.load();
        GameController c = fxmlLoader.getController();
        Random rand = new Random();
        int boardNumber = rand.nextInt(1,6);
        System.out.println("board number: " + boardNumber);
        c.setUpBoard(boardNumber, boards);
        primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        primaryStage.setScene(new Scene(root,640 ,800));
        primaryStage.setTitle("Snakes & Ladders");
        primaryStage.setResizable(false);
        primaryStage.show();
    }
    public void setUp1(Board board){
        Ladder l1 = new Ladder(21, 3);
        board.addLadder(l1);
        Ladder l2 = new Ladder(46, 8);
        board.addLadder(l2);
        Ladder l3 = new Ladder(26, 16);
        board.addLadder(l3);
        Ladder l4 = new Ladder(33, 29);
        board.addLadder(l4);
        Ladder l5 = new Ladder(70, 50);
        board.addLadder(l5);
        Ladder l6 = new Ladder(82, 61);
        board.addLadder(l6);
        Ladder l7 = new Ladder(77, 64);
        board.addLadder(l7);
        Ladder l8 = new Ladder(95, 76);
        board.addLadder(l8);
        Ladder l9 = new Ladder(91, 89);
        board.addLadder(l9);
        Ladder l10 = new Ladder(65, 37);
        board.addLadder(l10);
        //snakes
        Snake s1 = new Snake(24, 5);
        board.addSnake(s1);
        Snake s2 = new Snake(43, 22);
        board.addSnake(s2);
        Snake s3 = new Snake(56, 25);
        board.addSnake(s3);
        Snake s4 = new Snake(60, 42);
        board.addSnake(s4);
        Snake s5 = new Snake(69, 48);
        board.addSnake(s5);
        Snake s6 = new Snake(86, 53);
        board.addSnake(s6);
        Snake s7 = new Snake(96, 84);
        board.addSnake(s7);
        Snake s8 = new Snake(98, 58);
        board.addSnake(s8);
        Snake s9 = new Snake(90, 72);
        board.addSnake(s9);
        Snake s10 = new Snake(94, 73);
        board.addSnake(s10);
    }
    public void setUp2(Board board){
        Ladder l1 = new Ladder(21, 2);
        board.addLadder(l1);
        Ladder l2 = new Ladder(27, 6);
        board.addLadder(l2);
        Ladder l3 = new Ladder(33, 8);
        board.addLadder(l3);
        Ladder l4 = new Ladder(58, 38);
        board.addLadder(l4);
        Ladder l5 = new Ladder(64, 24);
        board.addLadder(l5);
        Ladder l6 = new Ladder(82, 63);
        board.addLadder(l6);
        Ladder l7 = new Ladder(97, 85);
        board.addLadder(l7);
        Ladder l8 = new Ladder(94, 73);
        board.addLadder(l8);
        Ladder l9 = new Ladder(91, 70);
        board.addLadder(l9);
        Ladder l10 = new Ladder(34, 16);
        board.addLadder(l10);

        Snake s1 = new Snake(23, 5);
        board.addSnake(s1);
        Snake s2 = new Snake(46, 25);
        board.addSnake(s2);
        Snake s3 = new Snake(32, 9);
        board.addSnake(s3);
        Snake s4 = new Snake(51, 11);
        board.addSnake(s4);
        Snake s5 = new Snake(59, 40);
        board.addSnake(s5);
        Snake s6 = new Snake(81, 62);
        board.addSnake(s6);
        Snake s7 = new Snake(98, 65);
        board.addSnake(s7);
        Snake s8 = new Snake(92, 48);
        board.addSnake(s8);
        Snake s9 = new Snake(95, 54);
        board.addSnake(s9);
        Snake s10 = new Snake(66, 56);
        board.addSnake(s10);
    }
    public void setUp3(Board board){
        Ladder l1 = new Ladder(17, 5);
        board.addLadder(l1);
        Ladder l2 = new Ladder(15, 7);
        board.addLadder(l2);
        Ladder l3 = new Ladder(13, 9);
        board.addLadder(l3);
        Ladder l4 = new Ladder(45, 35);
        board.addLadder(l4);
        Ladder l5 = new Ladder(47, 33);
        board.addLadder(l5);
        Ladder l6 = new Ladder(81, 40);
        board.addLadder(l6);
        Ladder l7 = new Ladder(83, 64);
        board.addLadder(l7);
        Ladder l8 = new Ladder(85, 66);
        board.addLadder(l8);
        Ladder l9 = new Ladder(87, 68);
        board.addLadder(l9);
        Ladder l10 = new Ladder(43, 37);
        board.addLadder(l10);

        Snake s1 = new Snake(24, 18);
        board.addSnake(s1);
        Snake s2 = new Snake(26, 16);
        board.addSnake(s2);
        Snake s3 = new Snake(28, 14);
        board.addSnake(s3);
        Snake s4 = new Snake(59, 38);
        board.addSnake(s4);
        Snake s5 = new Snake(57, 36);
        board.addSnake(s5);
        Snake s6 = new Snake(55, 34);
        board.addSnake(s6);
        Snake s7 = new Snake(99, 78);
        board.addSnake(s7);
        Snake s8 = new Snake(97, 76);
        board.addSnake(s8);
        Snake s9 = new Snake(95, 74);
        board.addSnake(s9);
        Snake s10 = new Snake(91, 50);
        board.addSnake(s10);
    }
    public void setUp4(Board board){
        Ladder l1 = new Ladder(81, 60);
        board.addLadder(l1);
        Ladder l2 = new Ladder(41, 20);
        board.addLadder(l2);
        Ladder l3 = new Ladder(24, 3);
        board.addLadder(l3);
        Ladder l4 = new Ladder(34, 7);
        board.addLadder(l4);
        Ladder l5 = new Ladder(31, 12);
        board.addLadder(l5);
        Ladder l6 = new Ladder(46, 36);
        board.addLadder(l6);
        Ladder l7 = new Ladder(63, 56);
        board.addLadder(l7);
        Ladder l8 = new Ladder(97, 78);
        board.addLadder(l8);
        Ladder l9 = new Ladder(95, 75);
        board.addLadder(l9);
        Ladder l10 = new Ladder(93, 69);
        board.addLadder(l10);

        Snake s1 = new Snake(22, 2);
        board.addSnake(s1);
        Snake s2 = new Snake(15, 5);
        board.addSnake(s2);
        Snake s3 = new Snake(33, 8);
        board.addSnake(s3);
        Snake s4 = new Snake(44, 23);
        board.addSnake(s4);
        Snake s5 = new Snake(79, 43);
        board.addSnake(s5);
        Snake s6 = new Snake(98, 82);
        board.addSnake(s6);
        Snake s7 = new Snake(85, 65);
        board.addSnake(s7);
        Snake s8 = new Snake(94, 47);
        board.addSnake(s8);
        Snake s9 = new Snake(92, 71);
        board.addSnake(s9);
        Snake s10 = new Snake(68, 50);
        board.addSnake(s10);
    }
    public void setUp5(Board board){
        Ladder l1 = new Ladder(25, 4);
        board.addLadder(l1);
        Ladder l2 = new Ladder(31, 8);
        board.addLadder(l2);
        Ladder l3 = new Ladder(48, 32);
        board.addLadder(l3);
        Ladder l4 = new Ladder(46, 28);
        board.addLadder(l4);
        Ladder l5 = new Ladder(60, 21);
        board.addLadder(l5);
        Ladder l6 = new Ladder(80, 42);
        board.addLadder(l6);
        Ladder l7 = new Ladder(98, 84);
        board.addLadder(l7);
        Ladder l8 = new Ladder(93, 69);
        board.addLadder(l8);
        Ladder l9 = new Ladder(77, 58);
        board.addLadder(l9);
        Ladder l10 = new Ladder(68, 52);
        board.addLadder(l10);

        Snake s1 = new Snake(11, 9);
        board.addSnake(s1);
        Snake s2 = new Snake(36, 14);
        board.addSnake(s2);
        Snake s3 = new Snake(56, 18);
        board.addSnake(s3);
        Snake s4 = new Snake(43, 22);
        board.addSnake(s4);
        Snake s5 = new Snake(81, 63);
        board.addSnake(s5);
        Snake s6 = new Snake(99, 78);
        board.addSnake(s6);
        Snake s7 = new Snake(96, 65);
        board.addSnake(s7);
        Snake s8 = new Snake(75, 54);
        board.addSnake(s8);
        Snake s9 = new Snake(94, 53);
        board.addSnake(s9);
        Snake s10 = new Snake(90, 50);
        board.addSnake(s10);
    }


}
