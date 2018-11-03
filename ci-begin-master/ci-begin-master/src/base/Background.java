package base;

import base.game.Settings;
import tklibs.SpriteUtils;

public class Background extends GameObject {
    public Background() {
        super();
        this.image = SpriteUtils.loadImage(
                "D:\\Techkids\\Code Intensive\\ci-begin-master\\ci-begin-master\\assets\\images\\background\\0.png"
        );
        this.position.set(0, Settings.SCREEN_HEIGHT - this.image.getHeight());
    }

    @Override
    public void run() {
        if (this.position.y < 0) {
            this.position.addThis (0, 10);
    }}
}
