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

    Scene currentScene;

    public void setScene(Scene scene)
    {
        frame.getChildren().clear();
        intervalInMillis = (int)(100/scene.getFramerate());
        currentScene = scene;
    }
    public Scene getScene() {
        return currentScene;
    }
    private int intervalInMillis = 100;
    public RenderEngine(Pane canvas)
    {
        frame = canvas;
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(intervalInMillis), new EventHandler<ActionEvent>() {
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
        currentScene.Background.transform.draw(frame);
        currentScene.MainLayer.transform.draw(frame);
        currentScene.Foreground.transform.draw(frame);
        currentScene.UI.transform.draw(frame);
        System.out.println("xd");
    }
}
