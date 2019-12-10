
package snakegame.ui;


import java.io.IOException;
import snakegame.domain.Board;
import static snakegame.domain.Board.cornersize;
import static snakegame.domain.Board.height;
import static snakegame.domain.Board.width;
import snakegame.domain.Food;
import snakegame.domain.Point;
import snakegame.domain.Scores;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import snakegame.dao.FileDao;

public class GameUi extends Application {
    
    static Dir direction = Dir.left;
    static boolean gameOver = false;
    static double speed = 1;
    static List<Point> snake = new ArrayList<>();
    String file = "scores.txt";
    FileDao fd = new FileDao(file);
    Scores score;
    private Scene scene;
    private VBox root;
    
    public enum Dir {
	left, right, up, down
	}

    @Override
    public void start(Stage stage) {
//        try {
        Board board = new Board(20, 20, 25);
        Food food = new Food(Food.getRand().nextInt(width / 2), Food.getRand().nextInt(height / 2));
        Menu menu = new Menu("Menu");
        MenuItem m1 = new MenuItem("to opening scene");     
        menu.getItems().add(m1); 
        MenuBar mb = new MenuBar();
        mb.getMenus().add(menu);
        VBox root = new VBox(mb);
        Scene scene = new Scene(root, width * cornersize, height * cornersize);
        Canvas c = new Canvas(width * cornersize, height * cornersize);
        GraphicsContext gc = c.getGraphicsContext2D();
        root.getChildren().add(c);
        GridPane pane = new GridPane();
        Button start = new Button("Start game");
        Button sc = new Button("scores");
        VBox points = new VBox();
        Button exit = new Button("exit");
        pane.add(start, 0, 2);
        pane.add(sc, 0, 4);
        pane.setPrefSize(300, 180);
        pane.setAlignment(Pos.CENTER);
        pane.setVgap(10);
        pane.setHgap(10);
        pane.setPadding(new Insets(20, 20, 20, 20));
        Scene scoresScene = new Scene(points, width * cornersize, height * cornersize);
        Scene opening = new Scene(pane);
      
        
        sc.setOnAction((event) -> {
            stage.setScene(scoresScene);
            Label label = new Label("Top 5 scores: " + "\n" + fd.getHighscoreString()
                + "\n" + "Your score: " + Scores.getScore());
            points.getChildren().add(label);
            points.getChildren().addAll(exit);
        });
        m1.setOnAction((event) -> {
            stage.setScene(opening);
//              root.getChildren().clear();
            try {  
                fd.addScore(this.score.getScore());
            } catch (IOException ex) {
                Logger.getLogger(GameUi.class.getName()).log(Level.SEVERE, null, ex);
            }
            fd.getScores();
        });
            
        exit.setOnAction((event) -> stage.close());
            
        AnimationTimer timer = new AnimationTimer() {
                long lastTick = 0;
              
                public void handle(long now) {
                    if (lastTick == 0) {
                        try {
                            lastTick = now;
                            tick(gc);
                            return;
                        } catch (Exception ex) {
                            Logger.getLogger(GameUi.class.getName()).log(Level.SEVERE, null, ex);
                        }
					}

                    if (now - lastTick > 1000000000 / speed) {
                        try {
                            lastTick = now;
                            tick(gc);
                        } catch (Exception ex) {
                            Logger.getLogger(GameUi.class.getName()).log(Level.SEVERE, null, ex);
                        }
					}
                
                }
			};
                    

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
       
        
        snake.add(new Point(width / 4, height / 4));
        snake.add(new Point(width / 4, height / 4));
        stage.setTitle("SNAKE GAME");
   
        start.setOnAction((event) -> {
            stage.setScene(scene);
            this.score = neww();
        });
        timer.start();
        stage.setScene(opening);
        stage.show();
        
//        } catch (Exception e) {
//            e.printStackTrace();
//        
		
	}

 
    public Scores neww() {
        return new Scores(0);
        
    } 

    public void tick(GraphicsContext gc) throws Exception  {
            
       
		if (gameOver) {
            gc.setFill(Color.RED);
            gc.setFont(new Font("", 40));
            gc.fillText("GAME OVER", 40, 45);
            gc.setFill(Color.WHITE);
            gc.setFont(new Font("", 30));
            gc.fillText("Score: " + String.valueOf(Scores.getScore()), 150, 150);

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
                
        if (Food.getFoodX() == snake.get(0).x && Food.getFoodY() == snake.get(0).y) {
            snake.add(new Point(-1, -1));
            Food food = new Food(Food.getRand().nextInt(width / 2), Food.getRand().nextInt(height / 2));         
            score.increase();
            speed++;
                        
		}

        gc.setFill(Color.BLACK);
	gc.fillRect(0, 0, width * cornersize, height * cornersize);
        gc.setFill(Color.DARKRED);
        gc.fillOval(Food.getFoodX() * cornersize, Food.getFoodY() * cornersize, cornersize, cornersize);

        for (Point co : snake) {            
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
