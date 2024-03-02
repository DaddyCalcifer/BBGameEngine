package com.example.gameengine.Models;

import javafx.fxml.Initializable;

import java.util.List;

public interface IAnimation{
    public List<?> getFrames();
    public void setFrames(List<?> frames);
    public Object getFrame(int id);
}
