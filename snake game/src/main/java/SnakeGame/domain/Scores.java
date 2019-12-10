
package snakegame.domain;

import java.io.Serializable;
/**
 * 
 * Luokka tarjoaa pelin pistemäärän sekä metodin pisteiden kasvattamiseen.
 */

public class Scores  {
    
    public static int score;
    
    /**
     * Konstruktori asettaa uuden pisteen
     * 
     * @param score käyttäjän antama pistemäärä
     * 
     */
    public Scores(int score) {
        this.score = score;
    }

    public static int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
    
     /**
     * Metodi kasvattaa pistemäärää.
     * 
     * @return kasvatettu pistemäärä
     */
    public static int increase() {   
        score++;
        return score;
    }

    @Override
     
    public String toString() {
        return "Scores: " + score;
    }
    
    
}

   
    
    
    

