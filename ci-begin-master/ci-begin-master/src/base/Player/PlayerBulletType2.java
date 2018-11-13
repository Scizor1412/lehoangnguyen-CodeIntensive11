package base.Player;

import base.Enemy.Enemy;
import base.GameObject;
import base.Renderer.AnimationRenderer;
import base.Renderer.SingleImageRenderer;
import base.Vector2D;
import base.game.Settings;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class PlayerBulletType2 extends PlayerBullet {
    public PlayerBulletType2 () {
        super();
        this.createRenderer();
    }

    private void moveToEnemy() {
        Enemy enemy  = null;
        for (GameObject gameObject: GameObject.gameObjects ) {
            if (gameObject.isActive && gameObject instanceof Enemy) {
                enemy = (Enemy) gameObject;
                break;
            }

        }
        if (enemy != null) {
            Vector2D enemyPosition = enemy.position;
            Vector2D result = enemyPosition.substract(this.position);
            result.addThis(this.velocity);
            result.setLength(5);
            this.velocity.set(result);
        }

    }

    private void createRenderer() {
        ArrayList<BufferedImage> images = SpriteUtils.loadImages("D:\\Techkids\\Code Intensive\\ci-begin-master\\ci-begin-master\\assets\\images\\enemies\\bullets\\blue.png",
                "D:\\Techkids\\Code Intensive\\ci-begin-master\\ci-begin-master\\assets\\images\\enemies\\bullets\\cyan.png",
                "D:\\Techkids\\Code Intensive\\ci-begin-master\\ci-begin-master\\assets\\images\\enemies\\bullets\\green.png",
                "D:\\Techkids\\Code Intensive\\ci-begin-master\\ci-begin-master\\assets\\images\\enemies\\bullets\\pink.png",
                "D:\\Techkids\\Code Intensive\\ci-begin-master\\ci-begin-master\\assets\\images\\enemies\\bullets\\red.png",
                "D:\\Techkids\\Code Intensive\\ci-begin-master\\ci-begin-master\\assets\\images\\enemies\\bullets\\white.png");

        this.renderer = new AnimationRenderer(images);
    }

    @Override
    public void run() {
        super.run();
        this.moveToEnemy();
    }
}
