package hangman;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

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
