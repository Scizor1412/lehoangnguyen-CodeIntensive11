package base.Enemy;

import base.GameObject;
import base.Renderer.AnimationRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class EnemyExplosion extends GameObject {
    public EnemyExplosion() {
        super();
        this.createAnimation();
    }

    private void createAnimation() {
        ArrayList<BufferedImage> images = SpriteUtils.loadImages("D:\\Techkids\\Code Intensive\\ci-begin-master\\ci-begin-master\\assets\\images\\enemies\\explosion\\0.png",
                "D:\\Techkids\\Code Intensive\\ci-begin-master\\ci-begin-master\\assets\\images\\enemies\\explosion\\1.png",
                "D:\\Techkids\\Code Intensive\\ci-begin-master\\ci-begin-master\\assets\\images\\enemies\\explosion\\2.png",
                "D:\\Techkids\\Code Intensive\\ci-begin-master\\ci-begin-master\\assets\\images\\enemies\\explosion\\3.png",
                "D:\\Techkids\\Code Intensive\\ci-begin-master\\ci-begin-master\\assets\\images\\enemies\\explosion\\4.png",
                "D:\\Techkids\\Code Intensive\\ci-begin-master\\ci-begin-master\\assets\\images\\enemies\\explosion\\5.png",
                "D:\\Techkids\\Code Intensive\\ci-begin-master\\ci-begin-master\\assets\\images\\enemies\\explosion\\6.png");
        this.renderer = new AnimationRenderer(images, 5, true);
    }
}
