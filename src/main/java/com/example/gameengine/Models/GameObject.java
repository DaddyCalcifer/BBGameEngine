package com.example.gameengine.Models;

import com.example.gameengine.Components.Physics;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

import javax.xml.bind.annotation.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class GameObject {
    @XmlAttribute
    public String name;
    @XmlElement
    public Transform transform;

    //@XmlElementWrapper(name = "components")
    //@XmlElement(name = "component")
    @XmlTransient
    public List<Component> Components;

    @XmlElementWrapper(name = "children")
    @XmlElement(name = "child")
    protected List<GameObject> children;

    public List<GameObject> getChildren() {return children;}
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
    @XmlElement(name = "Color")
    public String getColorText()
    {
        return color.toString();
    }
    @XmlElement
    public Vector2 velocity;

    // Конструктор по умолчанию, необходимый для JAXB
    public GameObject() {
        velocity = new Vector2();
        transform = new Transform(this);
        Components = new ArrayList<Component>();
        children = new ArrayList<GameObject>();

        // Перемещение инициализации компонентов после цикла
        for (Component comp : Components) {
            comp.start();
        }
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
}
