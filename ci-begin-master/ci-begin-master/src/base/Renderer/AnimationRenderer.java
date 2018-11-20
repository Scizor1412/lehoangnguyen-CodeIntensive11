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
    boolean isOnce;

    public AnimationRenderer(ArrayList<BufferedImage> images) {
        this(images, 10, false);
    }

    public AnimationRenderer(ArrayList<BufferedImage> images, int maxFramecount) {
        this(images, maxFramecount, false);
    }

    public AnimationRenderer (ArrayList<BufferedImage> images, int maxFramecount, boolean isOnce) {
        this.images = images;
        currentImageIndex = 0;
        this.countAnimation = new FrameCounter(maxFramecount);
        this.isOnce = isOnce;
    }

    @Override
    public void render(Graphics g, GameObject master) {
        g.drawImage(this.images.get(currentImageIndex), (int) master.position.x, (int) master.position.y, null);
        if (this.countAnimation.run()) {
            this.currentImageIndex++;
            if (this.currentImageIndex >= this.images.size()
             && this.isOnce) {
                master.destroy();
            }
            if (this.currentImageIndex >= this.images.size()) {
                this.currentImageIndex = 0;
            }
            this.countAnimation.reset();
        }
    }
}
