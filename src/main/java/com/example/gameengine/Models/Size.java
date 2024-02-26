package com.example.gameengine.Models;

import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Size {

    @XmlAttribute(name = "height")
    private double _h;

    @XmlAttribute(name = "width")
    private double _w;

    public Size() {
        _h = _w = 0;
    }

    public Size(double width, double height) {
        setHeight(height);
        setWidth(width);
    }

    public double getHeight() {
        return _h;
    }

    public void setHeight(double h) {
        this._h = h;
    }

    public double getWidth() {
        return _w;
    }

    public void setWidth(double w) {
        this._w = w;
    }

    public void set(double width, double height) {
        setWidth(width);
        setHeight(height);
    }
}
