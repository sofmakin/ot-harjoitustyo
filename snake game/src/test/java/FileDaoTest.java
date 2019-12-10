
import java.io.File;
import java.io.FileWriter;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.TemporaryFolder;
import snakegame.dao.FileDao;


public class FileDaoTest {
    @Rule
    public TemporaryFolder testFolder = new TemporaryFolder();    
    File scoreFile;
    FileDao fd;
  
    
    @Before
    public void setUp() throws Exception{
        scoreFile = testFolder.newFile("testfile_scores.txt");
        
        try (FileWriter file = new FileWriter(scoreFile.getAbsolutePath())) {
            file.write(3 + "\n");
            file.write(5 + "\n");
        
        }
        fd = new FileDao(scoreFile.getAbsolutePath());

    }
    
    @Test
    public void scoresAreReadCorrectly() {
        List<Integer>scores=fd.getAllScores();
        assertEquals(2, scores.size());
        assertEquals( "[5, 3]",String.valueOf( fd.getScores()));
       
        
    }
    
    @After
    public void tearDown() {
        scoreFile.delete();
    }


}
