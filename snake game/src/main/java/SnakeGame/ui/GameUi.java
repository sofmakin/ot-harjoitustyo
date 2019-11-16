
package SnakeGame.ui;

import SnakeGame.domain.Board;
import static SnakeGame.domain.Board.cornersize;
import static SnakeGame.domain.Board.height;
import static SnakeGame.domain.Board.width;
import SnakeGame.domain.Food;
import SnakeGame.domain.Snake;
import SnakeGame.domain.Corner;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;


/**
 *
 * @author admin
 */
public class GameUi extends Application {
    
    static Dir direction = Dir.left;
    static boolean gameOver = false;
    static double speed=3;
    static List<Corner>snake=new ArrayList<>();
    
    public enum Dir {
	left, right, up, down
	}
    
    public void start (Stage stage){
        try {
           
       
    Board board = new Board(20,20,25);
    
    Food food = new Food(Food.getRand().nextInt(width/2), Food.getRand().nextInt(height/2));

    
    VBox root = new VBox();
      
    Canvas c = new Canvas(width * cornersize, height * cornersize);
    GraphicsContext gc = c.getGraphicsContext2D();
    root.getChildren().add(c);
        
        new AnimationTimer() {
	long lastTick = 0;

	public void handle(long now) {
	if (lastTick == 0) {
	lastTick = now;
	tick(gc);
	return;
					}

	if (now - lastTick > 1000000000 / speed) {
	lastTick = now;
	tick(gc);
					}
				}

			}.start();


   Scene scene = new Scene(root, width * cornersize, height * cornersize);

         
       scene.addEventFilter(KeyEvent.KEY_PRESSED, key -> {
	if (key.getCode() == KeyCode.UP) {
		direction = Dir.up;
				}
	if (key.getCode() == KeyCode.LEFT) {
		direction = Dir.left;
				}
	if (key.getCode() == KeyCode.DOWN) {
		direction = Dir.down;
				}
	if (key.getCode() == KeyCode.RIGHT) {
		direction = Dir.right;
				}

			});
       
        
        snake.add(new Corner(width / 4, height / 4));
        snake.add(new Corner(width / 4, height / 4));
        stage.setTitle("SNAKE GAME");
        stage.setScene(scene);
        stage.show();
    
        } catch (Exception e) {
	e.printStackTrace();
        
		}
	}

    public static List<Corner> getSnake() {
        return snake;
    }

    
        public static void tick(GraphicsContext gc) {
            
       
		if (gameOver) {
			gc.setFill(Color.RED);
			gc.setFont(new Font("", 50));
			gc.fillText("GAME OVER", 100, 250);
			return;
		}

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
                
                    if (Food.getFoodX() == snake.get(0).x && Food.getFoodY()== snake.get(0).y) {
                  snake.add(new Corner(-1, -1));
                  Food food = new Food(Food.getRand().nextInt(width/2), Food.getRand().nextInt(height/2));
                  speed++;
                       
               
      
		}
        
        gc.setFill(Color.BLACK);
	gc.fillRect(0, 0, width * cornersize, height * cornersize);
        gc.setFill(Color.ROSYBROWN);
        gc.fillOval(Food.getFoodX() * cornersize, Food.getFoodY()* cornersize, cornersize, cornersize);

        
        for (Corner co : snake) {            
	gc.setFill(Color.LIGHTGREEN);
	gc.fillRect(co.x * cornersize, co.y * cornersize, cornersize - 1, cornersize - 1);
	gc.setFill(Color.GREEN);
	gc.fillRect(co.x * cornersize, co.y * cornersize, cornersize - 2, cornersize - 2);
    }
        
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
    
}
