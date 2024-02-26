package com.example.gameengine.Models;

import javax.xml.bind.annotation.*;

//Сериализуем без ошибок
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Vector2 {

    @XmlAttribute(name = "x")
    private double _x;

    @XmlAttribute(name = "y")
    private double _y;

    public Vector2() {
        set(0, 0);
    }
    public void multiply(double scalar) {
        _x *= scalar;
        _y *= scalar;
    }
    public void plus(Vector2 vec)
    {
        setY(getY() + vec.getY());
        setX(getX() + vec.getX());
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
