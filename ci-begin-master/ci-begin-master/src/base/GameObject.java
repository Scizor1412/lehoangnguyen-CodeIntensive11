package base;

import java.awt.*;
import java.awt.image.BufferedImage;

public class GameObject {
    // thuoc tinh
    public BufferedImage image;
    public Vector2D position;

    //phuong thuc
    public GameObject() {
        this.position = new Vector2D();
    }

    //logic
    public void run() {

    }

    //hien thi
    public void render(Graphics g) {
        g.drawImage(this.image, (int)this.position.x, (int)this.position.y, null);
    }
}
