
package csm6120_assignment2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class holds methods to manipulate the input files.
 * 
 * @author stefan
 */
public class FileManager {
    
    public FileManager(){
        
    }
    /**
     * Read a given file path and calls the findInteger() method. 
     * This is used to read the input files and read them line for line.
     * 
     * @param s - The State object to save too
     * @param path - The path of the input file
     */
    public void reader(State s, File path){
        try{
           BufferedReader bReader = new BufferedReader
                (new java.io.FileReader(path)); 
           String linecontent;
           while((linecontent = bReader.readLine()) != null){
               findInteger(linecontent, s);
           }
           bReader.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Changes the input line from being Strings to single Integers.
     * @param s - The String to analyse and change
     * @param state - The State object to save too
     */
    public void findInteger(String s, State state){
        String[] parts = s.split(",");
        for (int i = 0; i < parts.length; i++){
            try{
                int j = Integer.parseInt(parts[i]);
                state.addState(j);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}
