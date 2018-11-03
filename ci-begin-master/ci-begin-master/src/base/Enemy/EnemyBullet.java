package base.Enemy;

import base.GameObject;
import tklibs.SpriteUtils;

public class EnemyBullet extends GameObject {
    public EnemyBullet () {
        super();
        this.image = SpriteUtils.loadImage("D:\\Techkids\\Code Intensive\\ci-begin-master\\ci-begin-master\\assets\\images\\enemies\\bullets\\blue.png");
    }

    @Override
    public void run() {
        this.position.addThis(0, 1);
    }
}
