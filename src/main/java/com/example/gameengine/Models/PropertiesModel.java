package com.example.gameengine.Models;
import javax.xml.bind.*;
import javax.xml.bind.annotation.*;

@XmlRootElement
public class PropertiesModel {
    private int height;
    private int width;
    private String windowName;

    // Конструкторы, геттеры, сеттеры и другие методы

    @XmlElement
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @XmlElement
    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @XmlElement
    public String getWindowName() {
        return windowName;
    }

    public void setWindowName(String windowName) {
        this.windowName = windowName;
    }
}
