package base.Player;

import base.Renderer.AnimationRenderer;
import base.game.Settings;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class PlayerBulletType1 extends PlayerBullet {
    public PlayerBulletType1() {
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
        super.run();
        this.destroyIfNeeded();
    }

    private void destroyIfNeeded() {
        if (this.position.y < -20 || this.position.y > Settings.SCREEN_HEIGHT || this.position.x < -0 || this.position.x > Settings.BACKGROUND_WIDTH) {
            this.destroy();
        }
    }
}
