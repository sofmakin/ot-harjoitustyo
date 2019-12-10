
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

/**
 * 
 * Pisteiden tallenuksesta vastaava luokka.
 */
public class FileDao {
    /**
     * Lista pisteille
     */
    public List<Integer> scores;
    private String file;

    /**
     * Metodi lukee tiedostoa.
     * @param file luokassa määritelty muuttuja
     */
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
    /**
     * Metodi tallentaa pisteet tiedostoon.
     * 
     * @throws IOException ilmoittaa mahdollisesta virheestä
     */
    public void save() throws IOException  {
        try (FileWriter writer = new FileWriter(new File(file))) {
            for (Integer sc : scores) {
                    
                System.out.println(sc);
                writer.write(sc + "\n");
                  
            }
            writer.close();
        }
        
    } 
    /**
     * Metodi lisää pisteen Scores-listaan jonka jälkeen tieto talletetaan tiedostoon.
     * 
     * @param score käyttäjän antama pistemäärä
     * 
     * @throws IOException ilmoittaa mahdollisesta virheestä
     */
    public void addScore(int score) throws IOException  {
        this.scores.add(score);                      
        save();
        System.out.println("saved");    
        
    }
    /**
     * Metodi lajittelee ensin pisteet ja tulostaa listan.
     * 
     * @return palauttaa lajitellun listan
     */
    public List<Integer> getScores() {
        sort();
       
        return scores;
    }
    /**
     * Metodi toteuttaa pisteiden lajittelun suuruusjärjestykseen
     */
    private void sort() {
        Collections.sort(scores);
        Collections.reverse(scores);
        System.out.println(this.scores);
       
    }
    /**
     * Metodi tulostaa listalta viisi korkeinta pistemäärää.
     * 
     * @return palauttaa listan jossa viisi korkeinta pistemäärää 
     */
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
    
    
    public List<Integer> getAllScores() {
        return scores;
    }
    
}
    


        
        
    
   
    
    

