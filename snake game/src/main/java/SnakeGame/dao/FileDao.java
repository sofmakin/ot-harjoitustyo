
package snakegame.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileDao {
  
    public List<Integer> scores;
    private String file;


    public FileDao(String file) {
        this.scores = new ArrayList<>();
        this.file = file;
  
        try {
            Scanner reader = new Scanner(new File(file));
            while (reader.hasNext()) {               
                int value = Integer.valueOf(reader.next());
                this.scores.add(value);
           
            }
            reader.close();
        } catch (Exception e) {
            FileWriter writer = null;
            try {
                writer = new FileWriter(new File(file));
                writer.close();
            } catch (IOException ex) {
                Logger.getLogger(FileDao.class.getName()).log(Level.SEVERE, null, ex);
           
            }
        }
        System.out.println("file " + this.scores);
      
        
       
                
    }
        
    public void save() throws IOException  {
        try (FileWriter writer = new FileWriter(new File(file))) {
            for (Integer sc : scores) {
                    
                System.out.println(sc);
                writer.write(sc + "\n");
                  
            }
            writer.close();
        }
        
    } 
    public void addScore(int score) throws IOException  {
        this.scores.add(score);                      
        save();
        System.out.println("saved");    
        
    }

    public List<Integer> getScores() {
        System.out.println("get score");
        sort();
       
        return scores;
    }
    
    private void sort() {
        System.out.println("sort");
        Collections.sort(scores);
        Collections.reverse(scores);
        System.out.println(this.scores);
       
    }
    
    public String getHighscoreString() {
        System.out.println("getHighScoreString");
        String highscoreString = "";
        int max = 5;

        List<Integer> sc = this.scores;

        int i = 0;
        int x = sc.size();
        if (x > max) {
            x = max;
        }
        while (i < x) {
            highscoreString += (i + 1) + ".\t"  + "\t\t" + sc.get(i) + "\n";
            i++;
        }
        return highscoreString;
    }
    

    
}
    


        
        
    
   
    
    

