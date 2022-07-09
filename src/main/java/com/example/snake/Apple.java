package com.example.snake;

public class Apple extends Sprite{
    public Apple(double x,double y){
        super(x,y);
        initApple();
    }
    private void initApple(){
        setImage(Common.baseURL + "\\src\\main\\resources\\images\\apple.png");
    }
    public void randomApple(){
        this.x = (int)(Math.random()*29)*40;
        this.y = (int)(Math.random()*19)*40;
    }
}
