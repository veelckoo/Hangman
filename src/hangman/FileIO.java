/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hangman;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author bw3
 */
public class FileIO {
    
    public char FileIO() throws FileNotFoundException, IOException {
        File input = new File("words.txt");
        FileInputStream in = new FileInputStream(input);

        int byteRead = ' ';
       
            while((byteRead = in.read()) != -1) {
            return ((char)byteRead);    
          
       

        }
        return ' ';
    }
    
}