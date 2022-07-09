package com.example.snake;

public class Dot extends Sprite{
    public Dot(double x, double y){
        super(x,y);
        initDot();
    }
    private void initDot(){
        setImage("D:\\Code\\JavaCode\\ZetCode\\images\\ball.png");
    }

    public void move(double x,double y){
        this.x = x;
        this.y = y;
    }
}
