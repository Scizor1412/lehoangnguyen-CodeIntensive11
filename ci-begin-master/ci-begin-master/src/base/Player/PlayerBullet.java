package base.Player;

import base.GameObject;
import base.Renderer.AnimationRenderer;
import base.Renderer.SingleImageRenderer;
import base.game.Settings;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class PlayerBullet extends GameObject {
    public PlayerBullet () {
        super();
        this.createRenderer();
    }

    private void createRenderer() {
        ArrayList<BufferedImage> images = SpriteUtils.loadImages("D:\\Techkids\\Code Intensive\\ci-begin-master\\ci-begin-master\\assets\\images\\player-bullets\\a\\0.png",
                "D:\\Techkids\\Code Intensive\\ci-begin-master\\ci-begin-master\\assets\\images\\player-bullets\\a\\1.png",
                "D:\\Techkids\\Code Intensive\\ci-begin-master\\ci-begin-master\\assets\\images\\player-bullets\\a\\2.png",
                "D:\\Techkids\\Code Intensive\\ci-begin-master\\ci-begin-master\\assets\\images\\player-bullets\\a\\3.png");

        this.renderer = new AnimationRenderer(images);
    }

    @Override
    public void run() {
        this.position.addThis(0, -5);
        if(this.position.y < -20 || this.position.y > Settings.SCREEN_HEIGHT + 20 || this.position.x < -20 || this.position.x > Settings.SCREEN_WIDTH + 20) {
            this.destroy();
        }
    }
}
