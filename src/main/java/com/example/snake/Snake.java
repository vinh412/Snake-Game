package com.example.snake;

import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;
import java.util.List;

public class Snake {
    private final Head head;
    private final List<Dot> dots;
    private boolean up;
    private boolean down;
    private boolean left;
    private boolean right;

    public Snake(){
        head = new Head(120,40);
        dots = new ArrayList<>();
        initSnake();
    }

    private void initSnake(){
        addDot();
        up = false;
        down = false;
        left = false;
        right = false;
    }
    private void addDot(){
        if(dots.isEmpty()) {
            Dot dot = new Dot(head.getX()-40,head.getY());
            dots.add(dot);
        }
        else{
            Dot lastDot = dots.get(dots.size()-1);
            Dot dot = new Dot(lastDot.getX()-40, lastDot.getY());
            dots.add(dot);
        }

    }
    public void render(GraphicsContext gc){
        for (Dot dot: dots) {
            dot.render(gc);
        }
        head.render(gc);
    }
    public void move(){
        for(int i=dots.size()-1;i>0;i--){
            Dot dot = dots.get(i);
            dot.move(dots.get(i-1).getX(),dots.get(i-1).getY());
        }
        dots.get(0).move(head.getX(), head.getY());
        if(up)
            head.move(0,-40);
        if(down)
            head.move(0,40);
        if(left)
            head.move(-40,0);
        if(right)
            head.move(40,0);
    }
    public boolean checkEatApple(Apple apple){
        if(head.intersects(apple)){
            addDot();
            return true;
        }
        return false;
    }
    public void checkDirection(String keyInput){
        if(keyInput.equals("UP") && !down){
            up = true;
            right = false;
            left = false;
        }
        if(keyInput.equals("DOWN") && !up){
            down = true;
            right = false;
            left = false;
        }
        if(keyInput.equals("LEFT") && !right){
            up = false;
            down = false;
            left = true;
        }
        if(keyInput.equals("RIGHT") && !left){
            up = false;
            down = false;
            right = true;
        }
    }

}
