package SnakesLadders.main;

import java.util.ArrayList;

public class Board {
    private ArrayList<Snake> snakes;
    private ArrayList<Ladder> ladders;

    Board(){
        snakes = new ArrayList<>();
        ladders = new ArrayList<>();

        Snake snake1 = new Snake(3, 7, 4, 9);
        snakes.add(snake1);
    }

    ArrayList<Snake> getSnakes(){
        return snakes;
    }
}
