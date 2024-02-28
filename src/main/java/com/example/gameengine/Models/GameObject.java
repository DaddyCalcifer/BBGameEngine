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
        System.out.println("setter");
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
    @XmlElement(name = "child")
    public List<GameObject> getChildren() {return children;}

    public void setChildren(List<GameObject> children)
    {
        for (var ch: children) {
            ch.parent = this;
            this.children.add(ch);
            System.out.println("children added");
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
    @XmlTransient
    protected Color color = Color.GREEN;
    @XmlTransient
    public void setColor(Color clr)
    {
        color = clr;
    }
    protected String ColorARGB;
    @XmlElement(name = "Color")
    public void setColor(String hexARGB)
    {
        // Удаление префикса "0x", если он присутствует
        hexARGB = hexARGB.replace("0x", "");

        // Проверка на правильный формат hex-строки
        if (!hexARGB.matches("[0-9A-Fa-f]+")) {
            throw new IllegalArgumentException("Неверный формат hex-строки");
        }

        // Преобразование hex-строки в число
        long value = Long.parseLong(hexARGB, 16);

        // Извлечение компонентов ARGB
        int alpha = (int) ((value & 0xFF000000) >>> 24);
        int red = (int) ((value & 0x00FF0000) >>> 16);
        int green = (int) ((value & 0x0000FF00) >>> 8);
        int blue = (int) (value & 0x000000FF);

        // Создание объекта Color
        color = new Color(red, green, blue, alpha);
        System.out.println("colored");
    }

    public String getColor()
    {
        return color.toString();
    }
    @XmlElement
    public Vector2 velocity;

    // Конструктор по умолчанию, необходимый для JAXB
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
        System.out.println(name);

        // Перемещение инициализации компонентов после цикла
        for (Component comp : Components) {
            comp.gameObject = this;
            comp.start();
            System.out.println(comp.component);
        }
        for (var gobj : children)
        {
            gobj.initialize(url, resourceBundle);
            gobj.parent = this;
            System.out.println("parent:" + gobj.parent.name + " " + "child: " + gobj.name);
        }
    }
}
