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
}