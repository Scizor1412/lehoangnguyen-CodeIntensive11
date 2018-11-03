package base.Enemy;

import base.GameObject;
import base.game.GameCanvas;
import tklibs.SpriteUtils;

public class Enemy extends GameObject {
    public Enemy() {
        super();
        this.image = SpriteUtils.loadImage("D:\\Techkids\\Code Intensive\\ci-begin-master\\ci-begin-master\\assets\\images\\enemies\\level0\\black\\0.png");
        this.position.set(100, 400);
    }

    int count = 0;
    @Override
    public void run() {
        this.position.addThis(0,0);
        if (count > 20) {
            EnemyBullet enemyBullet = new EnemyBullet();
            enemyBullet.position.set(this.position.x, this.position.y);

            GameCanvas.enemyBullets.add(enemyBullet);
            count = 0;
        } else {
            count++;
        }
    }
}
