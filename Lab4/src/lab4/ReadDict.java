/*
 * Macewan University CMPT 305 Professor: Brian Brookwell
 */
package lab4;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author adriedger
 */
public class ReadDict {
    
    private File text = new File("dict.txt");
    private List<String> words = new ArrayList<>();
    private Map<String, Node> map = new HashMap<>();
    
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
        for(String key : words){
            Node current = new Node(key);
            for(String entry : words){
                if(isEditDistanceOne(key, entry)){
                    current.add(entry);
                }
            }
            map.put(key, current);
//            System.out.println(key + current);
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
        return count == 1;
    }
    
    public int calculateDistance(String start, String end){
        List<Node> queue = new ArrayList<>();
//        Node source;
        int cost = 0;
        for(Map.Entry<String, Node> entry : map.entrySet()){
            if(start.equals(entry.getKey())){
                Node source = entry.getValue();
                source.setDistance(cost);
                queue.add(source);
            }
        }
        while(!queue.isEmpty()){
            Node current = queue.get(0);
            System.out.println(current.getWord() + " " + current.getDistance());
//            queue.remove(0);
            if(current.getWord().equals(end))
                return current.getDistance();
            cost = current.getDistance() + 1;
            for(String s : current.getList()){
                Node link = null;
                for(Map.Entry<String, Node> entry : map.entrySet()){
                    if(s.equals(entry.getKey())){
                        link = entry.getValue();
                    }
                }
                if(link.getDistance() > cost){
                    link.setDistance(cost);
                    queue.add(link);
                }
            }
            queue.remove(0);
        }
        return 1000000;
    }
}
