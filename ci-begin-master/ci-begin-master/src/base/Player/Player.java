package base.Player;

import base.FrameCounter;
import base.Renderer.AnimationRenderer;
import base.Renderer.SingleImageRenderer;
import base.game.GameCanvas;
import base.GameObject;
import base.KeyEventPress;
import base.game.Settings;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Player extends GameObject {
    FrameCounter fireCounter;

    public Player() {
        super();
        this.createRenderer();
        this.position.set(200, 300);
        this.fireCounter = new FrameCounter(20);
    }

    private void createRenderer() {
        // Arraylist BufferedImage images
        // AnimationRenderer
        ArrayList<BufferedImage> images = new ArrayList<>();
        images.add(SpriteUtils.loadImage(("D:\\Techkids\\Code Intensive\\ci-begin-master\\ci-begin-master\\assets\\images\\players\\straight\\0.png")));
        images.add(SpriteUtils.loadImage(("D:\\Techkids\\Code Intensive\\ci-begin-master\\ci-begin-master\\assets\\images\\players\\straight\\1.png")));
        images.add(SpriteUtils.loadImage(("D:\\Techkids\\Code Intensive\\ci-begin-master\\ci-begin-master\\assets\\images\\players\\straight\\2.png")));
        images.add(SpriteUtils.loadImage(("D:\\Techkids\\Code Intensive\\ci-begin-master\\ci-begin-master\\assets\\images\\players\\straight\\3.png")));
        images.add(SpriteUtils.loadImage(("D:\\Techkids\\Code Intensive\\ci-begin-master\\ci-begin-master\\assets\\images\\players\\straight\\4.png")));
        images.add(SpriteUtils.loadImage(("D:\\Techkids\\Code Intensive\\ci-begin-master\\ci-begin-master\\assets\\images\\players\\straight\\5.png")));
        images.add(SpriteUtils.loadImage(("D:\\Techkids\\Code Intensive\\ci-begin-master\\ci-begin-master\\assets\\images\\players\\straight\\6.png")));

        this.renderer = new AnimationRenderer(images);
    }

    @Override
    public void run() {
        if (KeyEventPress.isUpPress) {
            if (this.position.y >0) {
                this.position.substractThis(0, 1);
            }

        }
        ;
        if (KeyEventPress.isDownPress) {
            if (this.position.y < Settings.SCREEN_HEIGHT - 100) {
                this.position.addThis(0, 1);
            }

        }
        ;
        if (KeyEventPress.isLeftPress) {
            if (this.position.x > 0) {
                this.position.substractThis(1, 0);
            }

        }
        ;
        if (KeyEventPress.isRightPress) {
            if (this.position.x < Settings.SCREEN_WIDTH/2 - 50) {
                this.position.addThis(1, 0);
            }

        }
        ;
        if (KeyEventPress.isFirePress) {
            this.fire();
        }
    }

    private void fire() {
        if (this.fireCounter.run()) {
            PlayerBullet bullet = GameObject.recycle(PlayerBullet.class);
            bullet.position.set(this.position);
            this.fireCounter.reset();
        }

    }
}
