package base.Renderer;

import base.FrameCounter;
import base.GameObject;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class AnimationRenderer extends  Renderer{
    ArrayList<BufferedImage> images;
    FrameCounter countAnimation;
    int currentImageIndex;
    public AnimationRenderer(ArrayList<BufferedImage> images) {
        this.images = images;
        this.currentImageIndex = 0;
        this.countAnimation = new FrameCounter(10);
    }

    @Override
    public void render(Graphics g, GameObject master) {
        g.drawImage(this.images.get(currentImageIndex), (int) master.position.x, (int) master.position.y, null);
        if (this.countAnimation.run()) {
            this.currentImageIndex++;
            if (this.currentImageIndex >= this.images.size()) {
                this.currentImageIndex = 0;
            }
            this.countAnimation.reset();
        }
    }
}
