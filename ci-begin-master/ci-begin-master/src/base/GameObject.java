package base;

import base.Player.Player;
import base.Renderer.Renderer;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class GameObject {
    //static
    public static ArrayList<GameObject> gameObjects = new ArrayList<>();

    //createGameObject generic
    public static <E extends GameObject> E create(Class<E> clazz){
        try {
            E gameObject = clazz.newInstance();// = new E();
            gameObjects.add(gameObject);
            return gameObject;
        } catch (Exception ex) {
            return null;
        }
    }

    public static <E extends GameObject> E recycle(Class<E> clazz) {
        for (GameObject gameObject : gameObjects) {
            if (isValidRecycle(gameObject, clazz)) {
                gameObject.reset();
                return (E)gameObject;
            }
        }
        E newGameObject = create(clazz);
        return newGameObject;
    }

    private static boolean isValidRecycle (GameObject gameObject, Class clazz) {
        return !gameObject.isActive && gameObject.getClass().isAssignableFrom(clazz);
    }
    // thuoc tinh
    public Vector2D position;
    public Renderer renderer;
    public boolean isActive;

    //phuong thuc
    public GameObject() {
        this.position = new Vector2D();
        this.isActive = true;
    }

    public void destroy() {
        this.isActive = false;
    }

    public void reset() {
        this.isActive = true;
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
