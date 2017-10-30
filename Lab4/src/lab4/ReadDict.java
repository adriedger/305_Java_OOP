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
    }
    
    private boolean isEditDistanceOne(String str1, String str2){
        if(str1.length() != str2.length()){
            if(str1.length() - str2.length() == 1){
                if(str1.substring(0, str2.length()).equals(str2)){
                    return true;
                }
            }
            if(str2.length() - str1.length() == 1){
                if(str2.substring(0, str1.length()).equals(str1)){
                    return true;
                }
            }
            return false;
        }
        int count = 0;
        for(int i = 0; i < str1.length(); i++){
            if(str1.charAt(i) != str2.charAt(i)){
                count++;
            }
            if(count > 1)
                return false;
        }
        return count > 0;
    }

    private boolean checkInList(String str, List<String> list){
        for(String s : list){
            if(str.equals(s))
                return true;
        }
        return false;
    }
    
    private String NextWord(String start, String end, List<String> queue){
        //need to include replacement of char with nothin, addin a char ie words that do not match in length
        int count = 0;
            for(int i = 0; i < start.length(); i++){
                if(start.charAt(i) == end.charAt(i)){
                    count++;
                }
            }
        int highest = count;
        String nextWord = "";
        
        for(String entry : queue){
            count = 0;
            for(int i = 0; i < end.length(); i++){
                if(end.charAt(i) == entry.charAt(i)){
                    count++;
                }
            }
            if(count > highest){
                highest = count;
                nextWord = entry;
            }
        }
        return nextWord;
    }
    
    public int calculateEditDistance(String str1, String str2){
        //if words dont equal
        if(checkInList(str1, words) && checkInList(str2, words)){
            int count = 1;
            String currentWord = str1;
            
            while(!currentWord.equals("")){
                List<String> queue = new ArrayList<>();
                
                for(Map.Entry<String, List<String>> entry : map.entrySet()){
                    if(currentWord.equals(entry.getKey())){
                        if(entry.getValue().isEmpty()){
                            System.out.println("Edit distance: no path exists");
                            return -1;
                        }
                        for(String e : entry.getValue())                           
                            queue.add(e);
                        if(checkInList(str2, queue)){
                            System.out.println("Edit distance: " + count);
                            return count; //done
                        }
                        currentWord = NextWord(currentWord, str2, queue);
                        System.out.println(currentWord);
                        count++;
                    }
                }
            }
        }
        else{
            System.out.println("Input word(s) not found in the dictionary");
            return -1;
        }
        System.out.println("Edit distance: no path exists");
        return -1;
    }
}
