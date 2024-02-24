package com.example.gameengine.Models;

import javafx.scene.image.Image;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class GameObject {

    @XmlElement
    private boolean isVisible = true;

    @XmlElement
    public Transform transform;

    @XmlElementWrapper(name = "components")
    @XmlElement(name = "component")
    public List<Component> Components;

    @XmlElement
    protected List<GameObject> children;

    @XmlElement
    protected Image Texture;

    // Конструктор по умолчанию, необходимый для JAXB
    public GameObject() {
        transform = new Transform(this);
        Components = new ArrayList<Component>();
        children = new ArrayList<GameObject>();

        // Перемещение инициализации компонентов после цикла
        for (Component comp : Components) {
            comp.start();
        }
    }
    @XmlElement
    private GameObject parent;
    public GameObject getParent() {
        if (parent != null)
            return parent;
        else return new GameObject();
    }

    public void setVisible(boolean val) {
        isVisible = val;
    }

    public void Destroy(GameObject gameObject) {
        parent.children.remove(this);
    }
}
