package com.example.snake;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {
    private Snake snake;
    private String keyInput;
    private Apple apple;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        Scene scene = new Scene(root, Color.BLACK);

        Canvas canvas = new Canvas(Common.WIDTH,Common.HEIGHT);
        root.getChildren().add(canvas);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        snake = new Snake();
        apple = new Apple(400,400);

        keyInput = "";
        scene.setOnKeyPressed(keyEvent -> {
            keyInput = keyEvent.getCode().toString();
            snake.checkDirection(keyInput);
        });

        KeyFrame keyFrame = new KeyFrame(Duration.millis(200), event -> {
            gc.clearRect(0,0,Common.WIDTH,Common.HEIGHT);
            apple.render(gc);
            snake.render(gc);
            if(snake.checkEatApple(apple))
                apple.randomApple();
            snake.move();
        });
        Timeline timeline = new Timeline(keyFrame);
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();

        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
