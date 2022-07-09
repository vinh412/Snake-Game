package com.example.snake;

import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Sprite {
    protected Image image;
    protected double x;
    protected double y;
    protected double width;
    protected double height;

    public Sprite(double x, double y){
        this.x = x;
        this.y = y;
    }
    public double getX(){return this.x;}
    public double getY(){return this.y;}
    public double getWidth(){return this.width;}
    public double getHeight(){return this.height;}
    public Image getImage(){return this.image;}
    public void setX(double x){this.x = x;}
    public void setY(double y){this.y = y;}

    public void setImage(Image image){
        this.image = image;
        this.width = image.getWidth();
        this.height = image.getHeight();
    }

    public void setImage(String filename){
        Image image = new Image(filename);
        setImage(image);
    }

    public void render(GraphicsContext gc){gc.drawImage(image,x,y);}

    public Rectangle2D getBoundary(){return new Rectangle2D(x,y,width,height);}

    public boolean intersects(Sprite sprite){ return sprite.getBoundary().intersects(this.getBoundary());}
}
