package SnakesLadders.main;

public class Snake {
    private pair head;
    private pair tail;
    Snake(int hx, int hy, int tx, int ty){
        head = new pair(hx, hy);
        tail = new pair(tx, ty);
    }
    pair getHead(){
        return head;
    }
    pair getTail()
    {
       return tail;
    }
//    int getTailX(){
//        return tail.getX();
//    }
//    int getTailY(){
//        return tail.getY();
//    }
}
