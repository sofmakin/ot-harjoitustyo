/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static snakegame.domain.Board.height;
import static snakegame.domain.Board.width;
import snakegame.domain.Food;

/**
 *
 * @author admin
 */
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