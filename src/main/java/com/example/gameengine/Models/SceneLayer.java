package com.example.gameengine.Models;

import com.example.gameengine.Properties;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class SceneLayer extends GameObject {

    public SceneLayer() {
        super();
        this.transform.Position.set(0, 0);
        this.transform.size.set(Properties.APP_WIDTH, Properties.APP_HEIGHT);
    }

    // Метод, добавленный для сериализации
    @XmlElement(name = "object")
    public void addObject(GameObject obj) {
        children.add(obj);
    }
}
