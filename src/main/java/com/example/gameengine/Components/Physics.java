package com.example.gameengine.Components;

import com.example.gameengine.Models.Component;
import com.example.gameengine.Models.GameObject;
import com.example.gameengine.Models.SceneLayer;
import com.example.gameengine.Models.Vector2;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Physics extends Component {

    @XmlTransient
    private SceneLayer layer;

    @XmlAttribute
    private static double GRAVITY = 1.0;

    @XmlAttribute
    private double MASS = 2.0;

    public Physics() {
        // Пустой конструктор для JAXB
    }

    public Physics(GameObject obj, SceneLayer layer) {
        super(obj);
        this.layer = layer;
    }

    public void start() {
        applyGravity();
    }

    @Override
    public void update() {
        RecountPos(gameObject, layer.getChildren());
    }

    public void applyGravity() {
        gameObject.velocity.set(0, GRAVITY);
    }

    public void eulerIntegration() {
        //var inertion = new Vector2(0,GRAVITY*-0.5);
        //gameObject.velocity.add(inertion);
    }

    public void RecountPos(GameObject object, List<GameObject> obstacles) {
        for (GameObject obstacle : obstacles) {
            if (object.transform.collidesWith(obstacle.transform) && obstacle != object &&
                    obstacle != gameObject.getParent() && !gameObject.getChildren().contains(obstacle)) {
                applyGravity();
                object.velocity.set(0, 0);
            } else {
                gameObject.transform.Position.plus(gameObject.velocity);
                gameObject.velocity.multiply(1.02);
            }
        }
    }
}
