package com.example.snake;

public class Head extends Sprite{
    public Head(double x,double y){
        super(x,y);
        initHead();
    }
    private void initHead(){
        setImage(Common.baseURL + "\\src\\main\\resources\\images\\head.png");
    }

    public void move(double dx, double dy){
        x += dx;
        y += dy;
    }
}
