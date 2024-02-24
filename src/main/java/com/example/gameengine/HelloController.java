package com.example.gameengine;

import com.example.gameengine.Controllers.FileManager;
import com.example.gameengine.GameLogic.RenderEngine;
import com.example.gameengine.Models.Scene;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    RenderEngine renderEngine;

    public void initialize(URL url, ResourceBundle rb)
    {
        renderEngine = new RenderEngine(canvas);
        Scene test = new Scene(30);
        renderEngine.setScene(test);
    }
    @FXML
    private Pane canvas;

}