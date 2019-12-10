
package snakegame.domain;

import static snakegame.domain.Board.height;
import static snakegame.domain.Board.width;
import java.util.Random;
import snakegame.ui.GameUi;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Peliin ruoka-elementin tarjoava luokka.
 */

public class Food {
    
    static Random rand = new Random();
    static int foodX;
    static int foodY;
    static int speed = 1;

  
    /**
     * Konstruktori luo ruoka-pisteen satunnaiseen kohtaan kenttää.
     * 
     * @param foodX Satunnainen x-koordinaatti pelikentältä.
     * 
     * @param foodY Satunnainen y-koordinaatti pelikentältä.
     */
    public Food(int foodX, int foodY) {
        this.foodX = foodX;
        this.foodY = foodY;
        
    }


    public static Random getRand() {
        return rand;
    }

    public static void setRand(Random rand) {
        Food.rand = rand;
    }

    public static int getFoodX() {
        return foodX;
    }

    public static void setFoodX(int foodX) {
        foodX = rand.nextInt(width);
    }

    public static int getFoodY() {
        return foodY;
    }

    public static void setFoodY(int foodY) {
        foodY = rand.nextInt(height);
    }

    @Override
    public String toString() {
        return "Food: " + Food.getFoodX() + "," + Food.getFoodY();
    }

    
    
}
