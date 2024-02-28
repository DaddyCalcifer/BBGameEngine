package com.example.gameengine.GameLogic;

import com.example.gameengine.Models.Scene;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.util.Timer;

public class RenderEngine {
    Pane frame;

    private int intervalInMillis() {
        if(currentScene != null)
            return (int)(1000/currentScene.getFramerate());
        else return 32;
    }
    double deltaTime()
    {
        return 1/intervalInMillis();
    }

    Scene currentScene;

    public void setScene(Scene scene)
    {
        frame.getChildren().clear();
        currentScene = scene;
    }
    public Scene getScene() {
        return currentScene;
    }
    public RenderEngine(Pane canvas)
    {
        frame = canvas;
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(intervalInMillis()), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // Метод, который будет вызываться по истечении интервала
                RenderFrame();
            }
        }));
        timeline.setCycleCount(Timeline.INDEFINITE); // Запуск таймлайна в бесконечном цикле
        timeline.play();
    }

    public void RenderFrame()
    {
        frame.getChildren().clear();
        currentScene.getBackground().transform.draw(frame);
        currentScene.getMainLayer().transform.draw(frame);
        currentScene.getForeground().transform.draw(frame);
        currentScene.getUI().transform.draw(frame);

        for (var child : currentScene.getMainLayer().getChildren()) {
            for (var comp : child.getComponents()) {
                comp.update();
            }
        }
    }
}
