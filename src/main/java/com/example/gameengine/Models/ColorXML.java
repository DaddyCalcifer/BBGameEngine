package com.example.gameengine.Models;

import javafx.scene.paint.Color;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class ColorXML {
    private double red;
    private double green;
    private double blue;
    private double opacity;

    // Конструктор по умолчанию для JAXB
    public ColorXML() {
    }

    public ColorXML(Color color) {
        this.red = color.getRed();
        this.green = color.getGreen();
        this.blue = color.getBlue();
        this.opacity = color.getOpacity();
    }

    public Color toColor() {
        return new Color(red, green, blue, opacity);
    }

    @XmlAttribute(name = "R")
    public double getRed() {
        return red;
    }

    public void setRed(double red) {
        this.red = red;
    }

    @XmlAttribute(name = "G")
    public double getGreen() {
        return green;
    }

    public void setGreen(double green) {
        this.green = green;
    }

    @XmlAttribute(name = "B")
    public double getBlue() {
        return blue;
    }

    public void setBlue(double blue) {
        this.blue = blue;
    }

    @XmlAttribute(name = "A")
    public double getOpacity() {
        return opacity;
    }

    public void setOpacity(double opacity) {
        this.opacity = opacity;
    }
}
