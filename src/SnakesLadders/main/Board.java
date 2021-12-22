package SnakesLadders.main;

import java.util.ArrayList;

public class Board {
    private int id;
    private ArrayList<Snake> snakes;
    private ArrayList<Ladder> ladders;

    Board(int id)
    {
        this.id = id;
        snakes = new ArrayList<>();
        ladders = new ArrayList<>();
    }


    public void addSnake(Snake snake)
    {
        this.snakes.add(snake);
    }

    public void addLadder(Ladder ladder)
    {
        this.ladders.add(ladder);
    }

    public ArrayList<Snake> getSnakes(){
        return snakes;
    }
    public ArrayList<Ladder> getLadders(){
        return  ladders;
    }
}
