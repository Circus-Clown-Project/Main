package model;

import interfaces.Difficulty;

public class EasyWorld implements Difficulty {
     private final int speedE = 20, movingE = 20, specialShapesE = 5,colorsE=3;
    private final int gameSpeed, movingNum, specialShapesNum,colorsNum;
    private final String theme;

    public EasyWorld() {
        this.gameSpeed = speedE;
        this.movingNum = movingE;
        this.specialShapesNum = specialShapesE;
        this.colorsNum = colorsE;
        this.theme="./images/Easy.png";
    }
    
    @Override
    public int getGameSpeed() {
        return gameSpeed;
    }

    @Override
    public int getMovingNum() {
        return movingNum;
    }

    @Override
    public int getSpecialShapesNum() {
        return specialShapesNum;
    }

    @Override
    public int getColorsNum() {
        return colorsNum;
    }
    
    @Override
    public String getTheme() {
        return this.theme;
    }
}
