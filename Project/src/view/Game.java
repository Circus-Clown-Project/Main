package view;

import controller.*;
import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.World;
import interfaces.Observer;
import interfaces.Subject;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Game implements World, Subject {

    private List<GameObject> constant = new LinkedList<>();
    private List<GameObject> moving = new LinkedList<>();
    private List<GameObject> control = new LinkedList<>();
    private ArrayList<Observer> observers;
    private MyController myController;

    public Game(MyController myController) {
        this.myController = myController;
        observers = new ArrayList<>();
        myController.setup(constant, moving, control);
    }

    @Override
    public boolean refresh() {
        for (GameObject m : moving) {
            myController.update(m);
        }
        if (!myController.check()) {
            this.notifyObservers();
            return false;
        }
        return true;
    }

    @Override
    public int getSpeed() {
        return (int) myController.getControls().get("Speed");
    }

    @Override
    public int getControlSpeed() {
        return 10;
    }

    @Override
    public List<GameObject> getConstantObjects() {
        return constant;
    }

    @Override
    public List<GameObject> getMovableObjects() {
        return moving;
    }

    @Override
    public List<GameObject> getControlableObjects() {
        return control;
    }

    @Override
    public int getWidth() {
        
        return (int) myController.getControls().get("ScreenW");
    }

    @Override
    public int getHeight() {
        return (int) myController.getControls().get("ScreenH");
    }

    @Override
    public String getStatus() {
        return myController.getControlStatus();	// update status
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (int i = 0; i < observers.size(); i++) {
            observers.get(i).update();
        }
    }
}
