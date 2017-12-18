/*
 * Macewan University CMPT 305 Professor: Brian Brookwell
 */
package Q2;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author adriedger
 */
public class ReadString {
    List<Character> sequence;
    
    ReadString(String in){
        sequence = new ArrayList<>();
        for(int i = 0; i < in.length(); i++){
            sequence.add(in.charAt(i));
        }
    }
    
    public Boolean output(){
        for(Character c : sequence){
            continue;
        }
        return true;
    }   
}
