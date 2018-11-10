package base.game;

import base.Background;
import base.Enemy.Enemy;
import base.Enemy.EnemyBullet;
import base.GameObject;
import base.Player.Player;
import base.Player.PlayerBullet;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GameCanvas extends JPanel {
    public GameObject background;
    public GameObject player;



    public GameCanvas(){
        this.background = GameObject.recycle(Background.class);
        this.player = GameObject.recycle(Player.class);
        Enemy enemy = GameObject.recycle(Enemy.class);
    }

    @Override
    protected void paintComponent(Graphics g) {
//        for (GameObject gameObject: GameObject.gameObjects) {
        for (int i =0; i < GameObject.gameObjects.size(); i++) {
            GameObject gameObject = GameObject.gameObjects.get(i);
            if (gameObject.isActive) {
                gameObject.render(g);
            }
        }
    }

    public void gameLoop() {
        int delay = 1000/60;
        long lastRun = 0;
        while(true) {
            long currentTime = System.currentTimeMillis();
            if (currentTime - lastRun > delay) {
                this.runAll();
                this.renderAll();
                lastRun = currentTime;
            }
        }
    }

    public void runAll() {
//        for(GameObject gameObject: GameObject.gameObjects) {
        for (int i=0; i < GameObject.gameObjects.size(); i++) {
            GameObject gameObject = GameObject.gameObjects.get(i);
            if (gameObject.isActive) {
                gameObject.run();
            }
        }
    }

    public void renderAll() {
        this.repaint();
    }
}
