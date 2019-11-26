/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.TemporaryFolder;
import snakegame.dao.FileScoresDao;

/**
 *
 * @author admin
 */
public class FileScoresDaoTest {
     @Rule
    public TemporaryFolder testFolder = new TemporaryFolder();    
    FileScoresDao fileScoresDao;
    File scoreFile;
    
    public FileScoresDaoTest() {
    }
 
    
    @Before
    public void setUp() throws Exception {
        scoreFile = testFolder.newFile("testfile_score.txt");  
    }
    
    @Test
    public void addScoreWorks() {
        
      
    }
  
}
