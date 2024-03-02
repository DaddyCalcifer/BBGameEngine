package com.example.gameengine.Controllers;

import com.example.gameengine.Models.*;
import javafx.scene.image.Image;

import java.util.List;

public class AnimationController extends Component {
    private boolean isPlaying = false;
    public IAnimation currentAnim;
    public List<IAnimation> animations;
    public int frameTime = 1;
    private int currentFrame = 0;
    int frameCount = 0;
    GameObject gameObject;
    public void Play(){
        isPlaying = true;
    }
    public void Pause(){
        isPlaying = false;
    }
    public void Stop(){
        //currentframe = 0;
        isPlaying = true;
    }
    @Override
    public void update()
    {
        if(frameCount < 10)
            frameCount++;
        else frameCount = 0;

        if ((frameCount % frameTime) == 0) {
            if (currentFrame == currentAnim.getFrames().size() - 1)
                currentFrame = 0;

            if (currentAnim.getClass() == AnimationTexture.class)
                gameObject.setImage((Image) currentAnim.getFrame(currentFrame));
            if(currentAnim.getClass() == AnimationPrompt.class)
                gameObject.transform.set((Transform)currentAnim.getFrame(currentFrame));
        }
    }
}
