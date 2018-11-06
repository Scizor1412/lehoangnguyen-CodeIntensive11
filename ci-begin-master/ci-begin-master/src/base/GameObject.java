package base;

import base.Renderer.Renderer;

import java.awt.*;
import java.awt.image.BufferedImage;

public class GameObject {
    // thuoc tinh
    public Vector2D position;
    public Renderer renderer;

    //phuong thuc
    public GameObject() {
        this.position = new Vector2D();
    }

    //logic
    public void run() {

    }

    //hien thi
    public void render(Graphics g) {
        if(this.renderer != null){
            this.renderer.render(g, this);
        }
    }
}
