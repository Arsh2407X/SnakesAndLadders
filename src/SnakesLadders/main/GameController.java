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



    @FXML
    private ImageView Car;

    @FXML
    private ImageView Bike;

    @FXML
    private GridPane grid1;

    @FXML
    private ImageView diceView;

    private pair bike;

    private pair car;

    @FXML
    void rollDice(MouseEvent event) throws InterruptedException {
        Random rand = new Random();
        int face = rand.nextInt(1,7);
        System.out.println(face);

//        Image img1 = new Image("C:\\Users\\arshg\\Desktop\\ApProject\\SnakesAndLadders\\src\\resources\\assets\\side1.jpeg");
//        Image img2 = new Image("C:\\Users\\arshg\\Desktop\\ApProject\\SnakesAndLadders\\src\\resources\\assets\\side2.jpeg");
//        Image img3 = new Image("C:\\Users\\arshg\\Desktop\\ApProject\\SnakesAndLadders\\src\\resources\\assets\\side3.jpeg");
//        Image img4 = new Image("C:\\Users\\arshg\\Desktop\\ApProject\\SnakesAndLadders\\src\\resources\\assets\\side4.jpeg");
//        Image img5 = new Image("C:\\Users\\arshg\\Desktop\\ApProject\\SnakesAndLadders\\src\\resources\\assets\\side5.jpeg");
//        Image img6 = new Image("C:\\Users\\arshg\\Desktop\\ApProject\\SnakesAndLadders\\src\\resources\\assets\\side6.jpeg");

//        for(int i = 0; i < 10; i++)
//        {
//            for(int j = 0 ; j < 10 ; j++)
//                grid1.add(,i,j);
//        }
//        System.out.println(grid1.getChildren().get(0).getLayoutX());
//        Bike.setX(grid1.getChildren().get(0).getLayoutX() + grid1.getLayoutX());
//        Bike.setY(grid1.getChildren().get(0).getLayoutY() + grid1.getLayoutY());

        //grid1.add(Bike,5,5);
        for(Node node : grid1.getChildren()){
            System.out.println("outside if");
            if(GridPane.getColumnIndex(node) == 5 && GridPane.getRowIndex(node) == 5){
                System.out.println("h");
                System.out.println(node.getLayoutX() + " " + node.getLayoutY());
            }
        }

        Thread th = new Thread() {
        public void run() {
                for (int i = 0; i < 6; i++) {

                    diceView.setImage(new Image("C:\\Users\\arshg\\Desktop\\ApProject\\SnakesAndLadders\\src\\resources\\assets\\side" + rand.nextInt(1, 7) + ".jpeg"));
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        System.out.println(diceView.getX());
//        diceView.setImage(img2);
//        th.sleep(200);
//        diceView.setImage(img3);
//        th.sleep(200);
//        diceView.setImage(img4);
//        th.sleep(200);
//        diceView.setImage(img5);
//        th.sleep(200);
//        diceView.setImage(img6);
//        th.sleep(200);

        th.start();

        Image diceFace = new Image("C:\\Users\\arshg\\Desktop\\ApProject\\SnakesAndLadders\\src\\resources\\assets\\side"+ face + ".jpeg");
        diceView.setImage(diceFace);
        //Node a = new Node(new Image("C:\\Users\\arshg\\Desktop\\ApProject\\SnakesAndLadders\\src\\resources\\assets\\side"+ face + ".jpeg"));
//        move();

//        for(Node node : grid1.getChildren()){
//            System.out.println("outside if");
//            if(GridPane.getColumnIndex(node) == 5 && GridPane.getRowIndex(node) == 5){
//                System.out.println("h");
//                System.out.println(node.getLayoutX() + " " + node.getLayoutY());
//            }
//        }
    }

    void move(int movePlaces){

    }

    void setUpBoard(int i){
        grid1.setStyle("-fx-background-image : url('file:/C:/Users/arshg/Desktop/ApProject/SnakesAndLadders/src/resources/assets/board" + i + ".png');" + "-fx-background-size: contain;");
    }



}
