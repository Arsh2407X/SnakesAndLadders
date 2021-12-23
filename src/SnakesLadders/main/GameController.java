package SnakesLadders.main;

import com.sun.javafx.iio.ImageStorageException;
import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.PathTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;


import javax.naming.PartialResultException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;

import static javafx.scene.input.DataFormat.URL;


public class GameController implements Initializable {


    boolean isFirstPlayerTurn;

    @FXML
    private ImageView gameBoard;

    @FXML
    private ImageView Arrow;

    @FXML
    private ImageView Car;

    private Board currBoard;

    @FXML
    private ImageView Bike;

    @FXML
    private ImageView diceView;


    @FXML
    private Rectangle RP1;

    @FXML
    private Rectangle RP2;


    @FXML
    private ImageView pause;

    @FXML
    private ImageView winnerIcon;

    @FXML
    private Group pauseMenu;

    @FXML
    private ImageView exit;

    @FXML
    private Group WinBox;


    private pair bike;
    private pair car;

    private Player P1;
    private Player P2;

    @FXML
    private ImageView resume;

    @FXML
    private ImageView exitFromPause;

    @FXML
    private Text winner;

    private Dice dice;

    @FXML
    void exitGame(MouseEvent event){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("EXIT");
        alert.setHeaderText("Exit Game?");
        alert.setContentText("Are you sure You want to exit?");

        Stage primaryStage;
        if(alert.showAndWait().get() == ButtonType.OK){
            primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();

            System.out.println("Exiting the game");
            primaryStage.close();
        }
    }

    @FXML
    void resumeGame(MouseEvent event){
        Arrow.setVisible(true);
        diceView.toFront();
        diceView.setVisible(true);
        TranslateTransition translate = new TranslateTransition();
        translate.setNode(pauseMenu);
        translate.setDuration(Duration.millis(500));
        //translate.setByX(10);
        translate.setByY(-600);
        //translate.setCycleCount(Animation.INDEFINITE);
        translate.setAutoReverse(false);
        translate.play();
    }

    @FXML
    void pauseHandler(MouseEvent event) {
        diceView.setVisible(false);
        Arrow.setVisible(false);
        diceView.toBack();
        TranslateTransition translate = new TranslateTransition();
        translate.setNode(pauseMenu);
        translate.setDuration(Duration.millis(500));
        //translate.setByX(10);
        translate.setByY(600);
        //translate.setCycleCount(Animation.INDEFINITE);
        translate.setAutoReverse(false);
        pauseMenu.toFront();
        translate.play();
    }

    void winner(String w) {
        Arrow.setVisible(false);
        diceView.setVisible(false);
        Car.setVisible(false);
        Bike.setVisible(false);
        if(w.equals("1"))
            winnerIcon.setImage(new Image("C:\\Users\\arshg\\Desktop\\ApProject\\SnakesAndLadders\\src\\resources\\assets\\blueToken.png"));
        else winnerIcon.setImage(new Image("C:\\Users\\arshg\\Desktop\\ApProject\\SnakesAndLadders\\src\\resources\\assets\\greenToken.png"));
        winner.setText("GGWP Player " + w);
        TranslateTransition translate = new TranslateTransition();
        translate.setNode(WinBox);
        translate.setDuration(Duration.millis(500));
        //translate.setByX(10);
        translate.setByY(-850);
        //translate.setCycleCount(Animation.INDEFINITE);
        translate.setAutoReverse(false);
        WinBox.toFront();
        translate.play();
    }


    @Override
    public void initialize(java.net.URL url, ResourceBundle resourceBundle) {
        P1 = new Player(Bike);
        P2 = new Player(Car);

        RP1.setVisible(true);
        RP2.setVisible(false);

        bike = new pair(50,-70);
        car = new pair(50,-85);

        P1.setLocation(bike);
        P2.setLocation(car);

        dice = new Dice("file:/C:/Users/arshg/Desktop/ApProject/SnakesAndLadders/src/resources/assets/side",diceView);

        isFirstPlayerTurn = true;
        Thread th = new Thread(){
            public void run()
            {
                TranslateTransition translate = new TranslateTransition();

                translate.setNode(Arrow);
                translate.setDuration(Duration.millis(500));
                translate.setByX(10);
                translate.setByY(0);
                translate.setCycleCount(Animation.INDEFINITE);
                translate.setAutoReverse(true);
                translate.play();
            }
        };


        th.start();

    }

    @FXML
    void rollDice(MouseEvent event) throws InterruptedException {

        RP1.setVisible(!RP1.isVisible());
        RP2.setVisible(!RP2.isVisible());

        Arrow.setVisible(false);

        int face = dice.roll();

        Random rand = new Random();


        Thread th = new Thread() {
        public void run() {
                for (int i = 0; i < 6; i++) {
                    diceView.setImage(new Image("C:\\Users\\arshg\\Desktop\\ApProject\\SnakesAndLadders\\src\\resources\\assets\\side"+ dice.roll() + ".jpeg"));
                    //dice.setFace(rand.nextInt(1, 7));
                    try {
                        Thread.sleep(30);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }


                diceView.setImage(new Image("C:\\Users\\arshg\\Desktop\\ApProject\\SnakesAndLadders\\src\\resources\\assets\\side"+ face + ".jpeg"));
            }
        };

        th.start();

        if(isFirstPlayerTurn) {
            System.out.println("player 1 rolled " +face);
            if(P1.getIsLocked())
            {
                if(face == 1) {
                    P1.setIsLocked(false);
                    Bike.setX(P1.getLocation().getX());
                    Bike.setY(P1.getLocation().getY());
                    Bike.toFront();
                    P1.setBox(1);
                }
            }

             else if(P1.getBox() + face >= 100)
            {
                if(P1.getBox() + face == 100)
                    winner("1");
            }
            else {Bike.toFront();

                 //bike = updateLocation(Bike,face,box1, bike);
                    P1.setLocation(updateLocation(Bike,face,P1.getBox(),P1.getLocation()));
            }

        }
        else {
            System.out.println("player 2 rolled " + face);
            if(P2.getIsLocked())
            {
                if(face == 1) {
                    P2.setIsLocked(false);
                    Car.setX(P2.getLocation().getX());
                    Car.setY(P2.getLocation().getY());
                    Car.toFront();
                    P2.setBox(1);
                }
            }
            else if(P2.getBox() + face >= 100)
            {
                if(P2.getBox() + face == 100)
                    winner("2");
            }
            else {Car.toFront();
                P2.setLocation(updateLocation(Car,face,P2.getBox(), P2.getLocation()));
            }
        }

        isFirstPlayerTurn = !(isFirstPlayerTurn);
        Arrow.setVisible(true);

    }


    pair updateLocation(ImageView P,int dist, int box, pair location) throws InterruptedException {

        pair finalLocation = new pair(location.getX(), location.getY());
        int delay = 0;
        Path p = new Path();
        p.getElements().add(new MoveTo(location.getX(), location.getY()));

        for (int i = 0; i < dist; i++) {
            if ((box - 1) / 10 % 2 == 0) {
                if (box % 10 == 0)
                    finalLocation.set(finalLocation.getX(), finalLocation.getY() - 57);
                else
                    finalLocation.set(finalLocation.getX() + 40, finalLocation.getY());
            } else {
                if (box % 10 == 0)
                    finalLocation.set(finalLocation.getX(), finalLocation.getY() - 57);
                else
                    finalLocation.set(finalLocation.getX() - 40, finalLocation.getY());
            }

            box++;
            delay += 200;
            //System.out.println(finalLocation.getX() + " f " + finalLocation.getY());
            p.getElements().add(new LineTo(finalLocation.getX(), finalLocation.getY()));

        }

        //checking for snakes and ladders

        Ladder l = null;
        Snake s = null;
        int ladderIndex = -1;
        for(int i = 0; i < currBoard.getLadders().size(); i++){
            if(currBoard.getLadders().get(i).getBottomBox() == box){
                //System.out.println("if " + box);
                ladderIndex = i;
                break;
            }
        }
        int snakeIndex = -1;
        for(int i = 0; i < currBoard.getSnakes().size(); i++){
            if(currBoard.getSnakes().get(i).getHeadBox() == box){
                snakeIndex = i;
                break;
            }
        }
        if(ladderIndex != -1){
            l = currBoard.getLadders().get(ladderIndex);
            p.getElements().add(l.getLadderPath());
            delay += ((l.getTopBox() - l.getBottomBox())/10)*350;
            finalLocation = l.getTopLocation();
            if(isFirstPlayerTurn)
                P1.setBox(l.getTopBox());
            else
                P2.setBox(l.getTopBox());
        }
        else if(snakeIndex != -1){
            s = currBoard.getSnakes().get(snakeIndex);
            p.getElements().add(s.getSnakePath());
            delay += ((s.getHeadBox() - s.getTailBox())/10)*1000;
            finalLocation = s.getTailLocation();
            if(isFirstPlayerTurn)
                P1.setBox(s.getTailBox());
            else
                P2.setBox(s.getTailBox());
        }
        else {
         if(isFirstPlayerTurn) P1.setBox(P1.getBox() + dist);
         else P2.setBox(P2.getBox() + dist);
        }

//        System.out.println("bike2" + box1);
//        System.out.println("car2" + box2);

        PathTransition pathTransition = new PathTransition();
        pathTransition.setNode(P);
        pathTransition.setDuration(Duration.millis(delay));
        pathTransition.setPath(p);
        pathTransition.play();
        //System.out.println(finalLocation.getX() + " g " + finalLocation.getY());

        return finalLocation;
    }


    void setUpBoard(int i, ArrayList<Board> boards){
        gameBoard.setImage(new Image("file:/C:/Users/arshg/Desktop/ApProject/SnakesAndLadders/src/resources/assets/board" + i + ".png"));
        currBoard = boards.get(i - 1);
    }



}
