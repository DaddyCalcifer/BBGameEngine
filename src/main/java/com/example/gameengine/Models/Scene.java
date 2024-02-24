package com.example.gameengine.Models;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Scene {
    public Scene(int framerate)
    {
        SCENE_FRAMERATE = framerate;
        Background = new SceneLayer();
        MainLayer = new SceneLayer();
        Foreground = new SceneLayer();
        UI = new SceneLayer();
    }
    private int SCENE_FRAMERATE;
    public int getFramerate()
    {
        return SCENE_FRAMERATE;
    }
    public SceneLayer Background;
    public SceneLayer MainLayer;
    public SceneLayer Foreground;
    public SceneLayer UI;
}
