
package snakegame.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import snakegame.domain.Scores;

public class FileScoresDao {
    
    public List<Scores> scores;  
    private static final String HIGHSCORE_FILE = "scores.txt";
    ObjectOutputStream outputStream = null;
    ObjectInputStream inputStream = null;

    
    public FileScoresDao() {
      
        scores = new ArrayList<Scores>();
    }
    
   
    
    public void read()  {   
        try {          
            inputStream = new ObjectInputStream(new FileInputStream(HIGHSCORE_FILE));
            scores = (ArrayList<Scores>) inputStream.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("[Read] FNF Error: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("[Read] IO Error: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("[Read] CNF Error: " + e.getMessage());   
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.flush();
                    outputStream.close();
                }    
           
            } catch (Exception e) {
                System.out.println("[Read] IO Error: " + e.getMessage());
            }
        
        }
    }
    
    public void addToFile() {
        try {
            outputStream = new ObjectOutputStream(new FileOutputStream(HIGHSCORE_FILE));
            outputStream.writeObject(scores);
        } catch (FileNotFoundException e) {
            System.out.println("[addToFile] FNF Error: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("[addToFile] IO Error: " + e.getMessage());
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.flush();
                    outputStream.close();
                }
            } catch (IOException e) {
                System.out.println("[addToFile] Error: " + e.getMessage());
            }
        }
    }
    public List<Scores> getScores() {
        read();
        sort();
        return scores;
    }
    
    private void sort() {
        
        Collections.sort(scores);
        
    }
    
    public void addScore(int score) {
        read();
        scores.add(new Scores(score));
        addToFile();
    }
    

    
}
    
   
    
 