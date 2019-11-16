
package SnakeGame.domain;

import static SnakeGame.domain.Board.cornersize;
import static SnakeGame.domain.Board.height;
import static SnakeGame.domain.Board.width;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import SnakeGame.ui.GameUi;
import javafx.scene.paint.Color;

/**
 *
 * @author admin
 */
public class Snake {
    
    static List<Corner>snake;
       static GameUi.Dir direction = GameUi.Dir.left;
  static boolean gameOver = false;
    public Snake() {
        
    this.snake = new ArrayList<>();
            
    }
    
    public static List<Corner> getSnake() {
        return snake;
    }

    public static void makeSnake(){
        snake.add(new Corner(width / 4, height / 4));
        snake.add(new Corner(width / 4, height / 4));
    }
    public static void setSnake(List<Corner> snake) {
        Snake.snake = snake;
    }
    
   public static void snakeMove(){    
       for (int i = snake.size() - 1; i >= 1; i--) {
			snake.get(i).x = snake.get(i - 1).x;
			snake.get(i).y = snake.get(i - 1).y;
		}
                
               
                        
		switch (direction) {
		case up:
			snake.get(0).y--;
			if (snake.get(0).y < 0) {
				gameOver = true;
			}
			break;
		case down:
			snake.get(0).y++;
			if (snake.get(0).y > height) {
				gameOver = true;
			}
			break;
		case left:
			snake.get(0).x--;
			if (snake.get(0).x < 0) {
				gameOver = true;
			}
			break;
		case right:
			snake.get(0).x++;
			if (snake.get(0).x > width) {
				gameOver = true;
			}
			break;
                }
   }
                
         
   }

