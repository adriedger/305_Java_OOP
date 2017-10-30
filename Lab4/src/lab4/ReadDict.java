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
    
    public ReadDict(){
        try{
            Scanner input = new Scanner(text);
            while(input.hasNextLine()){
                String line = input.nextLine();
                words.add(line);
            }
        }
        catch(IOException ex){
            System.out.println(ex);
        }
    }
    
    private boolean isEditDistanceOne(String str1, String str2){
        int count = 0;
        if(str1.length() != str2.length())
            return false;
        for(int i = 0; i < str1.length(); i++){
            if(str1.charAt(i) != str2.charAt(i)){
                count++;
            }
            if(count > 1)
                return false;
        }
        return count > 0;
    }
    
    public Map<String, List<String>> buildMap(){
        for(String s : words){
            List<String> nearWords = new ArrayList<>();
            for(String w : words){
                if(isEditDistanceOne(s, w)){
                    nearWords.add(w);
                }
            }
            map.put(s, nearWords);
            System.out.println(s + nearWords);
        }       
        return map;
    }
}
