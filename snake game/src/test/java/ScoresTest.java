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
import snakegame.domain.Scores;

/**
 *
 * @author admin
 */
public class ScoresTest {
    
    Scores score;
    
    public ScoresTest() {
    }
       
    @Before
    public void setUp() {
        score = new Scores(0);
    }
    
    @Test
    public void methodIncreaseIsRight() {
        Scores.increase();
        Scores.increase();
        assertEquals("Scores: 2", score.toString());
    }
  


}
