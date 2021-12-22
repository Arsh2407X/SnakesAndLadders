package SnakesLadders.main;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Random;

public class Dice {

    private final String face1;
    private final String face2;
    private final String face3;
    private final String face4;
    private final String face5;
    private final String face6;

    private ImageView diceView;

    Dice(String face, ImageView diceView)
    {

        this.diceView = diceView;
        this.face1 = face + "1" + ".jpeg";
        this.face2 = face + "2" + ".jpeg";
        this.face3 = face + "3" + ".jpeg";
        this.face4 = face + "4" + ".jpeg";
        this.face5 = face + "5" + ".jpeg";
        this.face6 = face + "6" + ".jpeg";
        this.diceView = new ImageView(new Image(face6));

    }

    public String getFace(int x)
    {
        switch (x)
        {
            case 1: return this.face1;
            case 2: return this.face2;
            case 3: return this.face3;
            case 4: return this.face4;
            case 5: return this.face5;
            case 6: return this.face6;

        }
        return "";
    }

    public int roll()
    {
        Random random = new Random();
        return random.nextInt(1,7);
    }

    public ImageView getDiceView()
    {
        return this.diceView;
    }

    public void setFace (int face)
    {
        this.diceView.setImage(new Image(getFace(face)));

        System.out.println(getFace((face)));
    }

}
