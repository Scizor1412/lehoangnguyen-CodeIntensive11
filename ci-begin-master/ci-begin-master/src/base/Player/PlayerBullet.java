package base.Player;

import base.GameObject;
import base.Renderer.SingleImageRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;

public class PlayerBullet extends GameObject {
    public PlayerBullet () {
        super();
        BufferedImage image = SpriteUtils.loadImage("D:\\Techkids\\Code Intensive\\ci-begin-master\\ci-begin-master\\assets\\images\\player-bullets\\a\\0.png");
        this.renderer = new SingleImageRenderer(image);
    }

    @Override
    public void run() {
        this.position.addThis(0, -1);
    }
}
