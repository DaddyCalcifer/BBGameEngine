package com.example.gameengine.Models;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Transform extends Component {

    @XmlElement
    public Vector2 Position;

    @XmlElement
    public Size size;

    @XmlElement
    public float RotationAngle;

    public Transform(GameObject go) {
        super(go);
        Position = new Vector2();
        size = new Size();
    }

    public void draw(Pane canvas) {
        if (_go.children.size() != 0) {
            for (var ch : _go.children) {
                ch.transform.draw(canvas);
            }
        }
        ImageView obj_ = new ImageView();
        obj_.setImage(_go.Texture);
        obj_.setX(_go.getParent().transform.Position.getX() + this.Position.getX());
        obj_.setY(_go.getParent().transform.Position.getY() + this.Position.getY());
        obj_.resize(this.size.getWidth(), this.size.getHeight());
        obj_.setRotate(_go.getParent().transform.RotationAngle + this.RotationAngle);
    }

    @Override
    public void start() {
        // Ваш код для инициализации
    }

    @Override
    public void update() {
        // Ваш код для обновления
    }
}
