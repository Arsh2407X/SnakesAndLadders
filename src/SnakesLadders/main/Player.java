package SnakesLadders.main;

import javafx.scene.image.ImageView;

public class Player {
    private ImageView player;
    private int box;
    private pair location;
    private boolean isLocked;

    Player(ImageView player){
        this.player = player;
        this.box = 0;
        this.location = new pair(50,-70);
        isLocked = true;
    }

    ImageView getPlayer()
    {
        return this.player;
    }
    int getBox()
    {
        return box;
    }
    void setBox(int b)
    {
        this.box = b;
    }

    pair getLocation()
    {
        return location;
    }
    void setLocation(pair l)
    {
        this.location = l;
    }
    boolean getIsLocked()
    {
        return isLocked;
    }
    void setIsLocked(boolean x)
    {
        this.isLocked = x;
    }
}
