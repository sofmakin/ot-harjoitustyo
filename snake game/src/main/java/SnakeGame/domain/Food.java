
package SnakeGame.domain;

import static SnakeGame.domain.Board.height;
import static SnakeGame.domain.Board.width;
import java.util.Random;
import SnakeGame.ui.GameUi;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author admin
 */
public class Food {
    
    static Random rand = new Random();
    static int foodX;
    static int foodY;
    static int speed=1;

  
    
    public Food(int foodX, int foodY) {
        this.foodX = foodX;
	this.foodY= foodY;
        
    }
    public static void generateFood(){
        while(true)
            start:  for (Corner co : GameUi.getSnake()) {
            if(co.x==foodX && co.y==foodY){
                continue start;
            }
            break;
        }
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

    
    
}
