package com.example.gameengine;

import com.example.gameengine.Components.Physics;
import com.example.gameengine.Controllers.FileManager;
import com.example.gameengine.GameLogic.RenderEngine;
import com.example.gameengine.Models.GameObject;
import com.example.gameengine.Models.Scene;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.io.File;

public class HelloController implements EventHandler<KeyEvent> {
    RenderEngine renderEngine;
    GameObject testo;

    public void initialize()
    {
        canvas.toFront();
        canvas.setOnKeyPressed(this::handle);
        renderEngine = new RenderEngine(canvas);
        Scene test = new Scene(60);

        //testo = new GameObject("knight");
        //testo.transform.Size.set(100,200);
        //testo.transform.Position.set(500,300);
        //testo.setColor(Color.LAVENDER);
        ////testo.transform.RotationAngle = 25;
        //testo.setImage(new File("C:\\Users\\Nikita\\IdeaProjects\\GameEngine\\src\\main\\resources\\com\\example\\gameengine\\i.png"));
        //testo.getComponents().add(new Physics(testo,test.getMainLayer()));
        //GameObject ground = new GameObject("ground");
        //ground.transform.Size.set(1280,50);
        //ground.transform.Position.set(0,700);
        //GameObject testo2 = new GameObject("knight child");
        //testo2.transform.Size.set(50,25);
        //testo2.transform.Position.set(-10,-10);
        //testo2.transform.RotationAngle = 25;
        //testo2.setColor(Color.GOLD);
        //testo2.Components.add(new Physics(testo2,test.getMainLayer()));


        //testo.addChildren(testo2);
        //test.getMainLayer().addObject(testo);
        //test.getMainLayer().addObject(ground);

        Scene readed = FileManager.deserializeScene("test.scene");
        test = readed.Extract(test);
        System.out.println(test.getFramerate());

        renderEngine.setScene(test);
        //FileManager.TestScriptLoader();
        //FileManager.serializeScene(test,"readed.scene");
    }
    @Override
    public void handle(KeyEvent e) {
        if (e.getCode() == KeyCode.W)
            testo.transform.Position.setY(testo.transform.Position.getY()+5);
        if (e.getCode() == KeyCode.A)
            testo.transform.Position.setX(testo.transform.Position.getX()-5);
        if (e.getCode() == KeyCode.S)
            testo.transform.Position.setY(testo.transform.Position.getY()-5);
        if (e.getCode() == KeyCode.D)
            testo.transform.Position.setX(testo.transform.Position.getX()+5);

       System.out.println("pressed");
    }
    @FXML
    private Pane canvas;

}