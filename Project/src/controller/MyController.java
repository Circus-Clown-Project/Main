package controller;

import interfaces.Shapes;
import interfaces.Difficulty;
import eg.edu.alexu.csd.oop.game.GameObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import model.*;

public class MyController {

    private final PlatesFactory platesFactory;
    private final SpecialShapesFactory SpecialShapesFactory;
    private StackController stackControl;
    private final GameController gameControl;
    private final Difficulty world;
    private AudioController audio;
    private HashMap<String, Integer> controls;
    private static MyController instance = null;

    public MyController(GameController gamecontrol, Difficulty world, AudioController audio) {
        this.gameControl = gamecontrol;
        this.world = world;
        this.audio = audio;
        platesFactory = new PlatesFactory(gamecontrol.getScreenWidth(), gamecontrol.getScreenHeight());
        SpecialShapesFactory = new SpecialShapesFactory(gamecontrol.getScreenWidth(), gamecontrol.getScreenHeight(), world.getSpecialShapesNum(), world.getTheme());

    }

    public void setup(List<GameObject> constant, List<GameObject> moving, List<GameObject> control) {
        // control objects 

        control.add(ClownObject.getInstance(gameControl.getScreenWidth() / 3, (int) (gameControl.getScreenHeight() * 0.65), "./images/clown.png", 10));
//        stackControl = StackController.getInstance(gameControl.getScreenWidth(), gameControl.getScreenHeight(), control.get(0), world.getMovingNum() - world.getBombsNum() + 1, audio);
        stackControl = new StackController(gameControl.getScreenWidth(), gameControl.getScreenHeight(), control.get(0), world.getMovingNum() - world.getSpecialShapesNum() + 1, audio);

// moving objects 
        Random r = new Random();
        for (int i = 0; i < world.getMovingNum(); i++) {
            moving.add((GameObject) platesFactory.getShape(gameControl.getShapes()[r.nextInt(world.getColorsNum())]));//gamecontrol.getShapes().length
        }
        ArrayList<Shapes> specialShapes = SpecialShapesFactory.getSpecialShapes();
        for (int i = 0; i < specialShapes.size(); i++) {
            moving.add((GameObject) specialShapes.get(i));
        }

// constants objects 
        constant.add(new ImageObject(0, 0, world.getTheme(), 0));
        controls = new HashMap();
        controls.put("Speed", world.getGameSpeed());
        controls.put("ScreenW", gameControl.getScreenWidth());
        controls.put("ScreenH", gameControl.getScreenHeight());
    }

    public void update(GameObject m) {
        stackControl.refresh(m);
        gameControl.refresh(m);
        // Catching 3 of same color
        if (stackControl.verify()) {
            gameControl.setScore(gameControl.getScore() + 10);
        }
        String bombType = stackControl.handleBomb();
        if (bombType != null) {
            if (bombType.equalsIgnoreCase("tnt")) {
                gameControl.setLives(Math.max(0, gameControl.getLives().length() - 2));
            } else {
                gameControl.setLives(Math.max(0, gameControl.getLives().length() - 1));
            }
        }
        String giftType = stackControl.handleGift();
        if (giftType != null) {
            if (giftType.equalsIgnoreCase("gift")) {
                gameControl.setLives(Math.min(5, gameControl.getLives().length() + 1));
            } else {
                gameControl.setScore(gameControl.getScore() + 50);
            }
        }
    }

    public boolean check() {
        if (gameControl.isLost(stackControl)) {
            audio.playGameOver();
            audio.stopEasyMusic();
            audio.stopNormalMusic();
            audio.stopHardMusic();

            return false;
        } else {
            return true;
        }
    }

    public HashMap getControls() {
        return controls;
    }

    public String getControlStatus() {
        return ("Score= " + gameControl.getScore() + " Lives: ️" + gameControl.getLives());
    }

    public void notifyObservers() {
        stackControl.update();
        gameControl.update();
    }
}
