/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Andre
 */
public class EditDist {
    
    private List<String> words;
    private Map<String, List<String>> map;
    private List<String> queue;
    
    public EditDist(List<String> words, Map<String, List<String>> map){
        this.words = words;
        this.map = map;
        this.queue = new ArrayList<>();
    }
    
    private boolean checkInDict(String str){
        for(String s : words){
            if(str.equals(s))
                return true;
        }
        return false;
    }
    
    public int calculate(String str1, String str2){
        int count = 0;
        if (checkInDict(str1) && checkInDict(str2)){
            for(Map.Entry<String, List<String>> entry : map.entrySet()){
                if(str1.equals(entry.getKey())){
                    
                }
            }
        }
        return 0;
    }   
}
