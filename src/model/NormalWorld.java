
package model;

import interfaces.Difficulty;

public class NormalWorld implements Difficulty {

    private final int speedN = 15, movingN = 30, specialShapesN = 7,colorsN=5;
    private final int gameSpeed, movingNum, specialShapesNum,colorsNum;
    private final String theme;

    public NormalWorld() {
        this.gameSpeed = speedN;
        this.movingNum = movingN;
        this.specialShapesNum = specialShapesN;
        this.colorsNum = colorsN;
        this.theme = "./images/Normal.png";
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
