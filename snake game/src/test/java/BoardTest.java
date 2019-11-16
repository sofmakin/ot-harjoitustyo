/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import SnakeGame.domain.Board;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author admin
 */
public class BoardTest {
    
    Board board;
    
    public BoardTest() {
    }
    
    
    @Before
    public void setUp() {
        board= new Board(20,20, 25);
    }
    
  
    @Test
    public void constructorSetsRight(){
        String answer = board.toString();
        assertEquals( "20 20 25", answer);
    }
    @Test
    public void getHeightIsRight(){
        int answer = board.getHeight();
        assertEquals(20, answer);
    }
     @Test
    public void getWidthIsRight(){
        int answer = board.getWidth();
        assertEquals(20, answer);
    }
    
     @Test
    public void getCornersizeIsRight(){
        int answer = board.getCornersize();
        assertEquals(25, answer);
    }
}
