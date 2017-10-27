/*
 * Macewan University CMPT 305 Professor: Brian Brookwell
 */
package lab4;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author adriedger
 */
public class ReadDict {
    
    private File text = new File("dict.txt");
    private List<String> words = new ArrayList<>();
    private Map<String, List<String>> map = new HashMap<>();
    
    public void buildMap(){
        try{
            Scanner input = new Scanner(text);
            while(input.hasNextLine()){
                String line = input.nextLine();
                System.out.println(line);
            }
        }
        catch(IOException ex){
            System.out.println ("Error: Couldn't find 'dict.txt'.");
        }
    }   
}
