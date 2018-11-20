package base.Enemy;

import base.GameObject;
import base.Player.Player;
import base.Renderer.AnimationRenderer;
import base.Renderer.SingleImageRenderer;
import base.game.Settings;
import base.physics.BoxCollider;
import base.physics.Physics;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class EnemyBullet extends GameObject implements Physics {
    BoxCollider boxCollider;

    public EnemyBullet() {
        super();
        BufferedImage image = SpriteUtils.loadImage("D:\\Techkids\\Code Intensive\\ci-begin-master\\ci-begin-master\\assets\\images\\enemies\\bullets\\blue.png");
        this.createRenderer();
        this.velocity.set(0, 5);
        this.boxCollider = new BoxCollider(this.position, 16, 16);
    }

    private void createRenderer() {
        ArrayList<BufferedImage> images = new ArrayList<>();
        images.add(SpriteUtils.loadImage("D:\\Techkids\\Code Intensive\\ci-begin-master\\ci-begin-master\\assets\\images\\enemies\\bullets\\blue.png"));
        images.add(SpriteUtils.loadImage("D:\\Techkids\\Code Intensive\\ci-begin-master\\ci-begin-master\\assets\\images\\enemies\\bullets\\cyan.png"));
        images.add(SpriteUtils.loadImage("D:\\Techkids\\Code Intensive\\ci-begin-master\\ci-begin-master\\assets\\images\\enemies\\bullets\\green.png"));
        images.add(SpriteUtils.loadImage("D:\\Techkids\\Code Intensive\\ci-begin-master\\ci-begin-master\\assets\\images\\enemies\\bullets\\pink.png"));
        images.add(SpriteUtils.loadImage("D:\\Techkids\\Code Intensive\\ci-begin-master\\ci-begin-master\\assets\\images\\enemies\\bullets\\red.png"));
        images.add(SpriteUtils.loadImage("D:\\Techkids\\Code Intensive\\ci-begin-master\\ci-begin-master\\assets\\images\\enemies\\bullets\\white.png"));
        images.add(SpriteUtils.loadImage("D:\\Techkids\\Code Intensive\\ci-begin-master\\ci-begin-master\\assets\\images\\enemies\\bullets\\yellow.png"));

        this.renderer = new AnimationRenderer(images);
    }

    @Override
    public void run() {
        super.run();
        this.destroyIfNeeded();
        this.hitPlayer();
    }

    private void hitPlayer() {
        Player player = GameObject.intersects(Player.class, this.boxCollider);
        if (player != null) {
            this.destroy();
            player.destroy();
        }
    }

    private void destroyIfNeeded() {
        if (this.position.y < -20 || this.position.y > Settings.SCREEN_HEIGHT || this.position.x < -0 || this.position.x > Settings.BACKGROUND_WIDTH) {
            this.destroy();
        }
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }

}
