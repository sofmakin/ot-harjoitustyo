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
import snakegame.domain.Point;

/**
 *
 * @author admin
 */
public class PointTest {
    
    Point point;
    
    public PointTest() {
    }
    
    
    @Before
    public void setUp() {
        point = new Point(2,4);
    }
    @Test
    public void constructorSetsRight(){
        String answer = point.toString();
        assertEquals( "Point:x=2, y=4", answer);
    
    }
    @Test
    public void setPointsXandYWorks() {
        point.setX(2);
        point.setY(5);
        assertEquals("Point:x=2, y=5", point.toString());
        
    }
    @Test
    public void getXandYIsRight() {
        point.getX();
        point.getY();
        assertEquals("Point:x=2, y=4", point.toString());
    }
}
