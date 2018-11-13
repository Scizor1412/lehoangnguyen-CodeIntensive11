package base;

import base.Renderer.SingleImageRenderer;
import base.game.Settings;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;

public class Background extends GameObject {
    public Background() {
        super();
        BufferedImage image = SpriteUtils.loadImage("D:\\Techkids\\Code Intensive\\ci-begin-master\\ci-begin-master\\assets\\images\\background\\0.png");

        this.position.set(0, Settings.SCREEN_HEIGHT - image.getHeight());
        this.renderer = new SingleImageRenderer(image);
        this.velocity.set(0, 10);
    }

    @Override
    public void run() {
        super.run();
        if (this.position.y >=0 ) {
            this.velocity.set(0,0);
        }
    }
}
