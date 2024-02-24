package com.example.gameengine.Models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Vector2 {

    @XmlElement
    private double _x;

    @XmlElement
    private double _y;

    public Vector2() {
        set(0, 0);
    }

    public Vector2(double x, double y) {
        set(x, y);
    }

    public double getX() {
        return _x;
    }

    public void setX(double x) {
        this._x = x;
    }

    public double getY() {
        return _y;
    }

    public void setY(double y) {
        this._y = y;
    }

    public void set(double x, double y) {
        setX(x);
        setY(y);
    }
}
