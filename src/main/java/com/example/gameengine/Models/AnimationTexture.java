package com.example.gameengine.Models;

import javafx.scene.image.Image;

import java.util.List;

public class AnimationTexture implements IAnimation{
    public List<Image> frames;
    @Override
    public List<Image> getFrames()
    {
        return frames;
    }

    @Override
    public void setFrames(List<?> frames) {
        this.frames.clear();
        this.frames.addAll((List<Image>)frames);
    }
    @Override
    public Image getFrame(int id)
    {
        if(id < frames.size())
            return frames.get(id);
        else return null;
    }
}
