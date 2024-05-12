package tast02_05;

import java.util.ArrayList;

public class Snake {
    int length;
    ArrayList<Integer> xCoord;
    ArrayList<Integer> yCoord;
    Snake(int length, int[] x, int[] y){
        this.length = length;
        this.xCoord = new ArrayList<Integer>();
        this.yCoord = new ArrayList<Integer>();
        for(int i=0; i<length; i++){
            this.xCoord.add(x[i]);
            this.yCoord.add(y[i]);
        }
    }
    public void goUp(){
        for(int i=length-1; i>0; i--){
            this.xCoord.set(i, this.xCoord.get(i - 1));
            this.yCoord.set(i, this.yCoord.get(i - 1));
        }
        this.yCoord.set(0, this.yCoord.get(0) - 1);
    }
    public void goDown(){
        for(int i=length-1; i>0; i--){
            this.xCoord.set(i, this.xCoord.get(i - 1));
            this.yCoord.set(i, this.yCoord.get(i - 1));
        }
        this.yCoord.set(0, this.yCoord.get(0) + 1);
    }
    public void goRight(){
        for(int i=length-1; i>0; i--){
            this.xCoord.set(i, this.xCoord.get(i - 1));
            this.yCoord.set(i, this.yCoord.get(i - 1));
        }
        this.xCoord.set(0, this.xCoord.get(0) + 1);
    }
    public void goLeft(){
        for(int i=length-1; i>0; i--){
            this.xCoord.set(i, this.xCoord.get(i - 1));
            this.yCoord.set(i, this.yCoord.get(i - 1));
        }
        this.xCoord.set(0, this.xCoord.get(0) - 1);
    }
}
