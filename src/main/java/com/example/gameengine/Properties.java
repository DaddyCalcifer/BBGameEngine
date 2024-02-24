package com.example.gameengine;

import com.example.gameengine.Models.PropertiesModel;

public class Properties {
    public static int APP_WIDTH = 800, APP_HEIGHT = 600;
    public static String APP_TITLE = "My game";

    public static void setValues(PropertiesModel model)
    {
        APP_WIDTH = model.getWidth();
        APP_HEIGHT = model.getHeight();
        APP_TITLE = model.getWindowName();
    }

}
