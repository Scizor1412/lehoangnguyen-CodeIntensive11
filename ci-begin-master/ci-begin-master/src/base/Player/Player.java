package base.Player;

import base.FrameCounter;
import base.Renderer.AnimationRenderer;
import base.Renderer.SingleImageRenderer;
import base.game.GameCanvas;
import base.GameObject;
import base.KeyEventPress;
import base.game.Settings;
import base.physics.BoxCollider;
import base.physics.Physics;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Player extends GameObject implements Physics {
    FrameCounter fireCounter;
    BoxCollider boxCollider;

    public Player() {
        super();
        this.createRenderer();
        this.position.set(200, 300);
        this.fireCounter = new FrameCounter(20);
        this.boxCollider = new BoxCollider(this.position, 32, 48);
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
        this.move();
            if (this.fireCounter.run() && KeyEventPress.isFirePress) {
            this.fire();
        }
        super.run();
    }

    private void move() {
        // TODO upgrade
        int vx = 0;
        int vy = 0;
        if (KeyEventPress.isUpPress) {
            if (this.position.y > 0) {
                vy -= 1;
            }
        }

        if (KeyEventPress.isDownPress) {
            if (this.position.y < Settings.SCREEN_HEIGHT - 100) {
                vy +=1;
            }
        }

        if (KeyEventPress.isLeftPress) {
            if (this.position.x > 0) {
                vx-=1;
            }
        }

        if (KeyEventPress.isRightPress) {
            if (this.position.x < Settings.BACKGROUND_WIDTH - 30) {
                vx+=1;
            }
        }

        this.velocity.set(vx,vy);
    }

    private void fire() {
            PlayerBulletType1 bullet = GameObject.recycle(PlayerBulletType1.class);
            bullet.position.set(this.position);

            PlayerBulletType2 bullet2 = GameObject.recycle(PlayerBulletType2.class);
            bullet2.position.set(this.position.add(-19,0));
            bullet2.velocity.set(-2,-5);
            PlayerBulletType2 bullet3 = GameObject.recycle(PlayerBulletType2.class);
            bullet3.position.set(this.position.add(19, 0));
            bullet3.velocity.set(2,-5);
            this.fireCounter.reset();
    }

    @Override
    public void destroy() {
        super.destroy();
        PlayerExplosion playerExplosion = GameObject.recycle(PlayerExplosion.class);
        playerExplosion.position = this.position;
    }

    @Override
    public BoxCollider getBoxCollider() {
        return boxCollider;
    }
}
