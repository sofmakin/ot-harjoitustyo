
package snakegame.domain;

import java.io.Serializable;


public class Scores  {
    
    public static int score;
    
    public Scores(int score) {
        this.score = score;
    }

    public static int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
    
    public static int increase() {   
        score++;
        return score;
    }

    @Override
    public String toString() {
        return "Scores: " + score;
    }
    
    
}

   
    
    
    

