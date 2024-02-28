package com.example.gameengine.Models;

import com.example.gameengine.Components.Physics;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

import javax.xml.bind.annotation.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class GameObject implements Initializable {
    @XmlAttribute
    public String name;
    @XmlElement
    public Transform transform;
    @XmlTransient
    private List<Component> Components;
    @XmlTransient
    private List<GameObject> children;

    @XmlElementWrapper(name = "components")
    @XmlElement(name = "component")
    public List<Component> getComponents() {
        return Components;
    }

    public void setComponents(List<Component> components) {
        this.Components.clear();
        for (var ch : components) {
            ch.setGameObject(this);
            this.Components.add(ch);
            System.out.println("component added");
        }
    }

    @XmlElementWrapper(name = "children")
    @XmlElement(name = "GameObject")
    public List<GameObject> getChildren() {return children;}

    public void setChildren(List<GameObject> children)
    {
        for (var ch: children) {
            ch.parent = this;
            this.children.add(ch);
        }
    }
    public void addChildren(GameObject child)
    {
        child.parent = this;
        children.add(child);
    }
    @XmlElement
    File ImageURL;

    public void setImage(File imageURL)
    {
        try {
            ImageURL = imageURL;
            Texture = new Image((new FileInputStream(imageURL)));
        } catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }
    @XmlTransient
    protected Image Texture;
    @XmlElement
    private ColorXML color = new ColorXML(Color.GREEN);

    public ColorXML getColor(){return color;}
    public void setColor(ColorXML color) {this.color = color;}
    @XmlElement
    public Vector2 velocity;

    GameObject() {
        if(velocity==null)
        velocity = new Vector2();
        if(transform==null)
        transform = new Transform(this);
        if(Components==null)
        Components = new ArrayList<Component>();
        if(children==null)
        children = new ArrayList<GameObject>();
        if(Texture == null)
        Texture = null;
    }
    public GameObject(String name)
    {
        velocity = new Vector2();
        transform = new Transform(this);
        Components = new ArrayList<Component>();
        children = new ArrayList<GameObject>();
        Texture = null;
        if(this.getClass() != SceneLayer.class)
        this.name = name;
    }
    @XmlTransient
    private GameObject parent;
    public GameObject getParent() {
        if (parent != null)
            return parent;
        else return new GameObject();
    }

    public void setVisible(boolean val) {
        transform.isVisible = val;
    }

    public void Destroy(GameObject gameObject) {
        parent.children.remove(this);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        transform.setGameObject(this);
        if(ImageURL != null)
            setImage(ImageURL);

        for (Component comp : Components) {
            comp.gameObject = this;

            //Class<?> loadedClass = comp.deserializeComponent();
            //if (loadedClass != null) {
            //    try {
            //        // Создание экземпляра класса, хранящегося в переменной типа Class
            //        Object instance = loadedClass.getDeclaredConstructor().newInstance();
            //        if (instance instanceof Component) {
            //            Component componentInstance = (Component) instance;
            //            Components.add(componentInstance);
            //            componentInstance.setGameObject(this); // Устанавливаем ссылку на gameObject
            //        }
            //    } catch (Exception e) {
            //        e.printStackTrace();
            //    }
            //}

            comp.start();
            System.out.println(comp.component);
        }
        for (var gobj : children)
        {
            gobj.initialize(url, resourceBundle);
            gobj.parent = this;
            if(this.getClass() != SceneLayer.class)
            System.out.println("parent:" + gobj.parent.name + " " + "child: " + gobj.name);
        }
    }
}
