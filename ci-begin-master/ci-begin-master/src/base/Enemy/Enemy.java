package base.Enemy;

import base.GameObject;
import base.Renderer.AnimationRenderer;
import base.Renderer.SingleImageRenderer;
import base.game.GameCanvas;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Enemy extends GameObject {
    public Enemy() {
        super();
        BufferedImage image = SpriteUtils.loadImage("D:\\Techkids\\Code Intensive\\ci-begin-master\\ci-begin-master\\assets\\images\\enemies\\level0\\black\\0.png");
        this.createRenderer();
        this.position.set((float)Math.random()*300 +1, 50);
    }

    @Override
    public void run() {
        super.run();
        if (this.position.y < 300) {
            this.position.addThis(0, 1);
        }
        this.fire();
    }

    private void createRenderer() {
        ArrayList<BufferedImage> images = new ArrayList<>() ;
        images.add(SpriteUtils.loadImage("D:\\Techkids\\Code Intensive\\ci-begin-master\\ci-begin-master\\assets\\images\\enemies\\explosion\\0.png"));
        images.add(SpriteUtils.loadImage("D:\\Techkids\\Code Intensive\\ci-begin-master\\ci-begin-master\\assets\\images\\enemies\\explosion\\1.png"));
        images.add(SpriteUtils.loadImage("D:\\Techkids\\Code Intensive\\ci-begin-master\\ci-begin-master\\assets\\images\\enemies\\explosion\\2.png"));
        images.add(SpriteUtils.loadImage("D:\\Techkids\\Code Intensive\\ci-begin-master\\ci-begin-master\\assets\\images\\enemies\\explosion\\3.png"));
        images.add(SpriteUtils.loadImage("D:\\Techkids\\Code Intensive\\ci-begin-master\\ci-begin-master\\assets\\images\\enemies\\explosion\\4.png"));
        images.add(SpriteUtils.loadImage("D:\\Techkids\\Code Intensive\\ci-begin-master\\ci-begin-master\\assets\\images\\enemies\\explosion\\5.png"));
        images.add(SpriteUtils.loadImage("D:\\Techkids\\Code Intensive\\ci-begin-master\\ci-begin-master\\assets\\images\\enemies\\explosion\\6.png"));
        images.add(SpriteUtils.loadImage("D:\\Techkids\\Code Intensive\\ci-begin-master\\ci-begin-master\\assets\\images\\enemies\\explosion\\7.png"));

        this.renderer = new AnimationRenderer(images);
    }

    int count = 0;

    private void fire() {
        if (count >= 20) {
            EnemyBullet enemyBullet = new EnemyBullet();
            enemyBullet.position.set(this.position.x, this.position.y);

            GameCanvas.enemyBullets.add(enemyBullet);
            count = 0;
        } else {
            count++;
        }
    }
}
