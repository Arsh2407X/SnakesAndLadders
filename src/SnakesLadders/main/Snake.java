package SnakesLadders.main;

import javafx.scene.shape.LineTo;

public class Snake {
    private int headBox;
    private int tailBox;
    private pair tailLocation;

    private LineTo snakePath;

    Snake(int head, int tail) {
        this.headBox = head;
        this.tailBox = tail;
        if(((tailBox-1)/10)%2 == 0)
            this.tailLocation = new pair(50 + ((tailBox-1)%10)*40, -70 - (((tailBox-1)/10) * 57));

        else
            this.tailLocation = new pair(50 + (9 - (tailBox-1)%10)*40, -70 - (((tailBox-1)/10)*57));

        this.snakePath = new LineTo(tailLocation.getX(),tailLocation.getY());

    }

    int getHeadBox()
    {
        return headBox;
    }

    int getTailBox()
    {
        return tailBox;
    }

    pair getTailLocation()
    {
        return tailLocation;
    }

    LineTo getSnakePath()
    {
        return this.snakePath;
    }


}


