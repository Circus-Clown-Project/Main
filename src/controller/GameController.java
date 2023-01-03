/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import eg.edu.alexu.csd.oop.game.GameObject;

public class GameController {

    private final int screenWidth;
    private final int screenHeight;
    private int score = 0;
    private String heart = "♥";
    private String lives;
    private static GameController instance = null;
    private AudioController audio;

    public GameController(int screenWidth, int screenHeight, AudioController audio) {
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        this.lives = heart.repeat(5);
        this.audio = audio;
    }

    public static synchronized GameController getInstance(int screenWidth, int screenHeight, AudioController audio) {
        if (instance == null) {
            instance = new GameController(screenWidth, screenHeight, audio);
        }
        return instance;
    }

    public String[] getShapes() {
        String[] shapes = new String[8];
        shapes[0] = "RedPlate";
        shapes[1] = "GreenPlate";
        shapes[2] = "BluePlate";
        shapes[3] = "YellowPlate";
        shapes[4] = "OrangePlate";
        shapes[5] = "RedPlate";
        shapes[6] = "OrangePlate";
        shapes[7] = "PinkPlate";

        return shapes;
    }

    public int getScreenWidth() {
        return screenWidth;
    }

    public int getScreenHeight() {
        return screenHeight;
    }

    public String getLives() {
        return lives;
    }

    public void setLives(int n) {
        if (n > 0) {
            this.lives = heart.repeat(n);
        } else {
            this.lives = heart.repeat(0);
        }
    }

    public int getScore() {
        return this.score;
    }

    public void setScore(int score) {
        this.score = score;
    }


    public void refresh(GameObject m) {
        if (m.getY() > screenHeight) {
                    m.setY(-1 * (int) (Math.random() * screenHeight));
        m.setX((int) (Math.random() * screenWidth));
        }
    }

    public void initialize(GameObject m) {
        m.setY(-1 * (int) (Math.random() * screenHeight));
        m.setX((int) (Math.random() * screenWidth));

    }

    public boolean isLost(StackController stackController) {
        if (stackController.getLeftPeek() <= 100 && stackController.getLeftPeek() != 0) {
            return true;
        }
        if (stackController.getRightPeek() <= 100 && stackController.getRightPeek() != 0) {
            return true;
        }
        if (stackController.getMovingSize() == stackController.getStacksSize()) {
            return true;
        }
        if (getLives().length() <= 0) {
            return true;
        }

        return false;
    }

    public void update() {
        instance = null;
    }
}
