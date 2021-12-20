package SnakesLadders.main;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import java.util.ArrayList;
import java.util.Random;


public class GameController {

    boolean isFirstPlayerTurn = true;

    @FXML
    private ImageView Car;

    private Board currBoard;

    @FXML
    private ImageView Bike;

    @FXML
    private GridPane grid1;

    @FXML
    private ImageView diceView;

    private pair bike = new pair(0,9);

    private pair car = new pair(0,9);

    @FXML
    void rollDice(MouseEvent event) throws InterruptedException {
        Random rand = new Random();
        int face = rand.nextInt(1,7);
        System.out.println(face);


        //arrive at snake head code

//        Bike.setX(5);
//        Bike.setY(-60);


//        Bike.setX(100);
//        Bike.setY(100);


//        for(Node node : grid1.getChildren()){
//            System.out.println("outside if");
//            if(GridPane.getColumnIndex(node) == 5 && GridPane.getRowIndex(node) == 5){
//                System.out.println("h");
//                System.out.println(node.getLayoutX() + " " + node.getLayoutY());
//            }
//        }

//        Thread th = new Thread() {
//        public void run() {
//                for (int i = 0; i < 6; i++) {
//
//                    diceView.setImage(new Image("C:\\Users\\arshg\\Desktop\\ApProject\\SnakesAndLadders\\src\\resources\\assets\\side" + rand.nextInt(1, 7) + ".jpeg"));
//                    try {
//                        Thread.sleep(100);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        };
        //System.out.println(diceView.getX());
        //th.start();
        //Thread.sleep(100);
        //th.join();
        Image diceFace = new Image("C:\\Users\\arshg\\Desktop\\ApProject\\SnakesAndLadders\\src\\resources\\assets\\side"+ face + ".jpeg");
        diceView.setImage(diceFace);

        if(isFirstPlayerTurn) {
            Thread th = new Thread() {
                public void run() {
                    for(int i = 0 ; i < 3; i++) {
                        try {

                            bike = updateLocation(Bike, face, bike);
                            Thread.sleep(200);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            };
            th.start();
        }
        else car = updateLocation(Car,face,car);

        isFirstPlayerTurn = !(isFirstPlayerTurn);

    }

    pair updateLocation(Node node,int dist, pair location) throws InterruptedException {


        int x, y;

        //Thread th = new Thread() {
            pair finalLocation;
            //public void run() {
                //for (int i = 0; i < dist; i++) {

                    if (location.getY() % 2 == 0) {
                        if (location.getX() == 0)
                            finalLocation = new pair(location.getX(), location.getY() - 1);
                        else
                            finalLocation = new pair(location.getX() - 1, location.getY());
                    } else {
                        if (location.getX() == 9)
                            finalLocation = new pair(location.getX(), location.getY() - 1);
                        else
                            finalLocation = new pair(location.getX() + 1, location.getY());
                    }

                    grid1.getChildren().remove(node);
                    grid1.add(node,finalLocation.getX(),finalLocation.getY());

                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                //}
            //}
        //};

        //th.start();
        //th.join();
        return finalLocation;
    }
    void checkSnakes()
    {
        for(int i = 0; i < currBoard.getSnakes().size(); i++){
            if(currBoard.getSnakes().get(i).getHead().compare(bike)){


                        grid1.add(Bike,currBoard.getSnakes().get(i).getTail().getX(), currBoard.getSnakes().get(i).getTail().getY());
            }
        }
    }

    void move(Node object, pair p){

    }

    void setUpBoard(int i, ArrayList<Board> boards){
        grid1.setStyle("-fx-background-image : url('file:/C:/Users/arshg/Desktop/ApProject/SnakesAndLadders/src/resources/assets/board" + i + ".png');" + "-fx-background-size: contain;");
        currBoard = boards.get(0);
    }



}
