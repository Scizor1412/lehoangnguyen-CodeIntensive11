package base.Player;

import base.GameObject;
import base.Renderer.AnimationRenderer;
import base.Renderer.SingleImageRenderer;
import base.game.Settings;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class PlayerBullet extends GameObject {
    public PlayerBullet() {
        super();
        this.velocity.set(0,-5);
    }

    @Override
    public void run() {
        super.run();
        this.destroyIfNeeded();
    }

    private void destroyIfNeeded() {
        if (this.position.y < -20 || this.position.y > Settings.SCREEN_HEIGHT || this.position.x < -0 || this.position.x > Settings.BACKGROUND_WIDTH) {
            this.destroy();
        }
    }
}
