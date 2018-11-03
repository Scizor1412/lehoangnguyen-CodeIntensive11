package base.Player;

import base.game.GameCanvas;
import base.GameObject;
import base.KeyEventPress;
import tklibs.SpriteUtils;

public class Player extends GameObject {
    public Player() {
        super();
        this.image = SpriteUtils.loadImage(
                "D:\\Techkids\\Code Intensive\\ci-begin-master\\ci-begin-master\\assets\\images\\players\\straight\\0.png"
        );
        this.position.set(200, 300);
    }

    @Override
    public void run() {
        if(KeyEventPress.isUpPress) {
            this.position.substractThis(0, 1);
        };
        if(KeyEventPress.isDownPress) {
            this.position.addThis(0, 1);
        };
        if(KeyEventPress.isLeftPress) {
            this.position.substractThis(1, 0);
        };
        if(KeyEventPress.isRightPress) {
            this.position.addThis(1, 0);
        };
        if(KeyEventPress.isFirePress) {
            this.fire();
        }
    }
    int count = 0;
    private void fire() {
        if (count > 20) {
            PlayerBullet bullet = new PlayerBullet();
            bullet.position.set(this.position.x, this.position.y);

            GameCanvas.bullets.add(bullet);
            count = 0;
        } else {
            count++;
        }
    }

}
