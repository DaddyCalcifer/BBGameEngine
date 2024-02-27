package com.example.gameengine.Models;

import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Scene {
    @XmlAttribute
    private int SCENE_FRAMERATE;
    @XmlElement
    private SceneLayer Background;
    @XmlElement
    private SceneLayer MainLayer;
    @XmlElement
    private SceneLayer Foreground;
    @XmlElement
    private SceneLayer UI;

    public Scene() {
        // Пустой конструктор требуется для JAXB
    }

    public Scene(int framerate) {
        this.SCENE_FRAMERATE = framerate;
        this.Background = new SceneLayer();
        this.MainLayer = new SceneLayer();
        this.Foreground = new SceneLayer();
        this.UI = new SceneLayer();
    }
    public int getFramerate() {
        return SCENE_FRAMERATE;
    }

    public void setFramerate(int framerate) {
        this.SCENE_FRAMERATE = framerate;
    }

    public SceneLayer getBackground() {
        return Background;
    }

    public void setBackground(SceneLayer background) {
        this.Background = background;
    }

    public SceneLayer getMainLayer() {
        return MainLayer;
    }

    public void setMainLayer(SceneLayer mainLayer) {
        this.MainLayer = mainLayer;
    }

    public SceneLayer getForeground() {
        return Foreground;
    }

    public void setForeground(SceneLayer foreground) {
        this.Foreground = foreground;
    }

    public SceneLayer getUI() {
        return UI;
    }

    public void setUI(SceneLayer ui) {
        this.UI = ui;
    }
    public Scene Extract(Scene extractTo)
    {
        extractTo = new Scene(this.getFramerate());

        extractTo.Background.transform.Position.set(this.Background.transform.Position.getX(),
                this.Background.transform.Position.getY());
        extractTo.Background.transform.Size.set(this.Background.transform.Size.getWidth(),
                this.Background.transform.Size.getHeight());
        extractTo.Background.transform.RotationAngle = this.Background.transform.RotationAngle;
        for (var obj:
             this.Background.getChildren()) {
            extractTo.Background.addObject(obj);
        }

        extractTo.MainLayer.transform.Position.set(this.MainLayer.transform.Position.getX(),
                this.MainLayer.transform.Position.getY());
        extractTo.MainLayer.transform.Size.set(this.MainLayer.transform.Size.getWidth(),
                this.MainLayer.transform.Size.getHeight());
        extractTo.MainLayer.transform.RotationAngle = this.MainLayer.transform.RotationAngle;
        for (var obj:
                this.MainLayer.getChildren()) {
            extractTo.MainLayer.addObject(obj);
        }

        extractTo.Foreground.transform.Position.set(this.Foreground.transform.Position.getX(),
                this.Foreground.transform.Position.getY());
        extractTo.Foreground.transform.Size.set(this.Foreground.transform.Size.getWidth(),
                this.Foreground.transform.Size.getHeight());
        extractTo.Foreground.transform.RotationAngle = this.Foreground.transform.RotationAngle;
        for (var obj:
                this.Foreground.getChildren()) {
            extractTo.Foreground.addObject(obj);
        }

        extractTo.UI.transform.Position.set(this.UI.transform.Position.getX(),
                this.UI.transform.Position.getY());
        extractTo.UI.transform.Size.set(this.UI.transform.Size.getWidth(),
                this.UI.transform.Size.getHeight());
        extractTo.UI.transform.RotationAngle = this.UI.transform.RotationAngle;
        for (var obj:
                this.UI.getChildren()) {
            extractTo.UI.addObject(obj);
        }

        return extractTo;
    }
}