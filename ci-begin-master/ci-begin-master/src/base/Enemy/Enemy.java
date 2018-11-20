package base.Enemy;

import base.FrameCounter;
import base.GameObject;
import base.Renderer.AnimationRenderer;
import base.Renderer.SingleImageRenderer;
import base.game.GameCanvas;
import base.physics.BoxCollider;
import base.physics.Physics;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Enemy extends GameObject implements Physics {
    FrameCounter enemyFireCounter;
    FrameCounter enemyCreateCounter;
    BoxCollider boxCollider;

    public Enemy() {
        super();
        BufferedImage image = SpriteUtils.loadImage("D:\\Techkids\\Code Intensive\\ci-begin-master\\ci-begin-master\\assets\\images\\enemies\\level0\\black\\0.png");
        this.createRenderer();
        this.position.set((float) Math.random() * 300 + 1, -50);
        this.enemyFireCounter = new FrameCounter(20);
        this.enemyCreateCounter = new FrameCounter(50);
        this.velocity.set(1,3);
        this.boxCollider = new BoxCollider(this.position, 28, 28);
    }

    @Override
    public void run() {
        super.run();
        if (this.position.y >= 300) {
            this.velocity.set(0,0);
        }
        this.fire();
        if (this.enemyCreateCounter.run()) {
            GameObject.create(Enemy.class);
            this.enemyCreateCounter.reset();
        }
    }

    private void createRenderer() {
        ArrayList<BufferedImage> images = SpriteUtils.loadImages("D:\\Techkids\\Code Intensive\\ci-begin-master\\ci-begin-master\\assets\\images\\enemies\\level0\\pink\\0.png",
                "D:\\Techkids\\Code Intensive\\ci-begin-master\\ci-begin-master\\assets\\images\\enemies\\level0\\pink\\1.png",
                "D:\\Techkids\\Code Intensive\\ci-begin-master\\ci-begin-master\\assets\\images\\enemies\\level0\\pink\\2.png",
                "D:\\Techkids\\Code Intensive\\ci-begin-master\\ci-begin-master\\assets\\images\\enemies\\level0\\pink\\3.png");
        this.renderer = new AnimationRenderer(images);
    }


    private void fire() {
        if (this.enemyFireCounter.run()) {
            EnemyBullet enemyBullet = GameObject.recycle(EnemyBullet.class);
            enemyBullet.position.set(this.position);
            this.enemyFireCounter.reset();
        }
    }

    @Override
    public void destroy() {
        super.destroy();
        EnemyExplosion explosion = GameObject.recycle(EnemyExplosion.class);
        explosion.position.set(this.position);
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }
}
