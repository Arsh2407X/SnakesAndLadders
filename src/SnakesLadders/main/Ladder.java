package SnakesLadders.main;

import javafx.scene.shape.LineTo;

public class Ladder {

    private int topBox;
    private int bottomBox;
    private pair topLocation;

    private LineTo ladderPath;

    Ladder(int top, int bottom) {
        this.topBox = top;
        this.bottomBox = bottom;
        if(((topBox-1)/10)%2 == 0)
            this.topLocation = new pair(50 + ((topBox-1)%10)*40, -70 -(((topBox-1)/10)*57));

        else
            this.topLocation = new pair(50 + (9 - (topBox-1)%10)*40, -70 - (((topBox-1)/10)*57));
        this.ladderPath = new LineTo(topLocation.getX(),topLocation.getY());

    }

    int getTopBox(){
        return topBox;
    }

    int getBottomBox(){
        return bottomBox;
    }

    pair getTopLocation(){
        return topLocation;
    }

    LineTo getLadderPath()
    {
        return this.ladderPath;
    }
}
