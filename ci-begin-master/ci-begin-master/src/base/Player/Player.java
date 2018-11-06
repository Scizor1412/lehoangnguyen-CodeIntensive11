package base.Player;

import base.Renderer.AnimationRenderer;
import base.Renderer.SingleImageRenderer;
import base.game.GameCanvas;
import base.GameObject;
import base.KeyEventPress;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Player extends GameObject {
    public Player() {
        super();
//        BufferedImage image = SpriteUtils.loadImage(
//                "D:\\Techkids\\Code Intensive\\ci-begin-master\\ci-begin-master\\assets\\images\\players\\straight\\0.png"
//        );
//        this.renderer = new SingleImageRenderer(image);
        this.createRenderer();
        this.position.set(200, 300);
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
