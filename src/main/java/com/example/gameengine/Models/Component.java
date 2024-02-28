package com.example.gameengine.Models;

import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Component implements IComponent {
    @XmlAttribute
    public boolean isEnable = true;

    @XmlAttribute
    protected String component;

    public void start(){}
    public void update(){}

    @XmlTransient
    protected GameObject gameObject;

    public void setGameObject(GameObject gameObject)
    {
        this.gameObject = gameObject;
    }
    public GameObject gameObject() { return gameObject;}
    private boolean hasDefaultConstructor(Class<?> clazz) {
        try {
            clazz.getDeclaredConstructor();
            return true;
        } catch (NoSuchMethodException e) {
            return false;
        }
    }
    public Component() {
    }
    public Class<?> deserializeComponent() {
        try {
            return Class.forName(component);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Component(GameObject gameObject)
    {
        this.gameObject = gameObject;
        start();
    }
}