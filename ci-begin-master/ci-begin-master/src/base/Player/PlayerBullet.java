package base.Player;

import base.GameObject;
import tklibs.SpriteUtils;

public class PlayerBullet extends GameObject {
    public PlayerBullet () {
        super();
        this.image = SpriteUtils.loadImage("D:\\Techkids\\Code Intensive\\ci-begin-master\\ci-begin-master\\assets\\images\\player-bullets\\a\\0.png");
    }

    @Override
    public void run() {
        this.position.addThis(0, -1);
    }
}
