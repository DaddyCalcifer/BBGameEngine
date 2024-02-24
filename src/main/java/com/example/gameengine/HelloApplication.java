package com.example.gameengine;

import com.example.gameengine.Controllers.FileManager;
import com.example.gameengine.GameLogic.RenderEngine;
import com.example.gameengine.Models.PropertiesModel;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        PropertiesModel model = FileManager.loadProp();

        Properties.setValues(model);

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), Properties.APP_WIDTH, Properties.APP_HEIGHT);
        stage.setTitle(Properties.APP_TITLE);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}