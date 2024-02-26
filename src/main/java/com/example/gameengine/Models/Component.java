package com.example.gameengine.Models;

import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class Component {
    @XmlAttribute
    public boolean isEnable = true;
    @XmlAttribute
    protected boolean isVisible = true;
    @XmlTransient
    protected GameObject gameObject;
    public GameObject gameObject() { return gameObject;}
    public abstract void start();
    public abstract void update();
    // Конструктор по умолчанию, необходимый для JAXB
    public Component() {
        start();
    }
    public Component(GameObject gameObject)
    {
        this.gameObject = gameObject;
        start();
    }
}
