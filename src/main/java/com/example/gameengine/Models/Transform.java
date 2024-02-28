package com.example.gameengine.Models;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;

import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Transform extends Component {
    @XmlTransient
    protected boolean drawFill = true;
    protected boolean isVisible = true;
    @XmlElement
    public Vector2 Position;

    @XmlElement
    public Size Size;

    @XmlElement
    public double RotationAngle;

    public Transform(GameObject gameObject) {
        super(gameObject);
        Position = new Vector2();
        Size = new Size();
    }
    public boolean collidesWith(Transform other) {
        double thisLeft = this.Position.getX();
        double thisRight = this.Position.getX() + this.Size.getWidth();
        double thisTop = this.Position.getY();
        double thisBottom = this.Position.getY() + this.Size.getHeight();

        double otherLeft = other.Position.getX();
        double otherRight = other.Position.getX() + other.Size.getWidth();
        double otherTop = other.Position.getY();
        double otherBottom = other.Position.getY() + other.Size.getHeight();

        return thisLeft < otherRight && thisRight > otherLeft &&
                thisTop < otherBottom && thisBottom > otherTop;
    }
    public Transform() {
        super(new GameObject()); // или другой способ инициализации по умолчанию
        Position = new Vector2();
        Size = new Size();
    }

    public void draw(Pane canvas) {
        if(isEnable && isVisible) {
            if(gameObject.getClass() != SceneLayer.class){
            ImageView obj_ = new ImageView();
            Rectangle rectangle = new Rectangle();
            Rotate rotate = new Rotate();
            rotate.setPivotX(Position.getX());
            rotate.setPivotY(Position.getY());
            rotate.setAngle(gameObject.getParent().transform.RotationAngle + this.RotationAngle);
            if (gameObject.Texture != null) {
                obj_.setImage(gameObject.Texture);
                obj_.setX(gameObject.getParent().transform.Position.getX() + this.Position.getX());
                obj_.setY(gameObject.getParent().transform.Position.getY() + this.Position.getY());
                obj_.setFitHeight(gameObject.transform.Size.getHeight());
                obj_.setFitWidth(gameObject.transform.Size.getWidth());
                obj_.setRotate(gameObject.getParent().transform.RotationAngle + RotationAngle);
                canvas.getChildren().add(obj_);
            } else if (drawFill) {
                rectangle.setX(gameObject.getParent().transform.Position.getX() + this.Position.getX());
                rectangle.setY(gameObject.getParent().transform.Position.getY() + this.Position.getY());
                rectangle.setHeight(Size.getHeight());
                rectangle.setWidth(Size.getWidth());
                rectangle.setFill(gameObject.getColor().toColor());
                rectangle.setRotate(gameObject.getParent().transform.RotationAngle + RotationAngle);
                canvas.getChildren().add(rectangle);
            }
        }
            if (gameObject.getChildren().size() != 0) {
                for (var ch : gameObject.getChildren()) {
                    ch.transform.draw(canvas);
                }
            }
        }
    }

    @Override
    public void start() {
        // Ваш код для инициализации
    }
    @Override
    public void setGameObject(GameObject gameObject)
    {
        super.setGameObject(gameObject);
        if(gameObject.ImageURL == null)
            drawFill = true;
    }

    @Override
    public void update() {
        // Ваш код для обновления
    }
}
