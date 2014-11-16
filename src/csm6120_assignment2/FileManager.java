/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csm6120_assignment2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author stefan
 */
public class FileManager {
    
    public FileManager(){
        
    }
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
