
import java.util.Random;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static snakegame.domain.Board.height;
import static snakegame.domain.Board.width;
import snakegame.domain.Food;


public class FoodTest {
   
    Food food;
    
    public FoodTest() {
    }
    
  
    
    @Before
    public void setUp() {
     
    }
    
    @Test
    public void constructorSetsRight() {
        food = new Food(2,3);
           assertEquals("Food: 2,3", food.toString());   
    }
   
}

