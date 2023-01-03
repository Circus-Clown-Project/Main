/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class PlayerScore implements Comparable {
    String name;
    int score;

    public PlayerScore(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public String getScore() {
        return score+"";
    }
       
    public String lineRepresentation()
    {
        return name+","+score;
    }

    @Override
    public int compareTo(Object o) {
        return Integer.valueOf(this.getScore()).compareTo(Integer.valueOf(((PlayerScore)o).getScore()));
    }
    
}
