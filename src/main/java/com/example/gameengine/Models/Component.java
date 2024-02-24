package com.example.gameengine.Models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class Component {
    @XmlElement
    public boolean isEnable = true;
    @XmlElement
    protected GameObject _go;
    public GameObject gameObject() { return _go;}
    public abstract void start();
    public abstract void update();
    // Конструктор по умолчанию, необходимый для JAXB
    public Component() {
    }
    public Component(GameObject gameObject)
    {
        _go = gameObject;
    }
}
