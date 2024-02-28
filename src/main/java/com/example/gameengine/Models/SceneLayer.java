package com.example.gameengine.Models;

import com.example.gameengine.Properties;
import javafx.fxml.Initializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.net.URL;
import java.util.ResourceBundle;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class SceneLayer extends GameObject {

    public SceneLayer() {
        super("layer");
        this.transform.Position.set(0, 0);
        this.transform.Size.set(Properties.APP_WIDTH, Properties.APP_HEIGHT);
        transform.drawFill = false;
        transform.setGameObject(this);
    }
    // Метод, добавленный для сериализации
    public void addObject(GameObject obj) {
        getChildren().add(obj);
    }
}