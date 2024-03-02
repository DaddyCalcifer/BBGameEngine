package com.example.gameengine.Models;

import javafx.scene.image.Image;

import java.util.List;

public class AnimationPrompt implements IAnimation{
    public List<Transform> frames;
    @Override
    public List<Transform> getFrames()
    {
        return frames;
    }

    @Override
    public void setFrames(List<?> frames) {
        this.frames.clear();
        this.frames.addAll((List<Transform>)frames);
    }
    @Override
    public Transform getFrame(int id)
    {
        if(id < frames.size())
            return frames.get(id);
        else return null;
    }
}
