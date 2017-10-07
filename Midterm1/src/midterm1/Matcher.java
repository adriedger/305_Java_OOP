package midterm1;

import java.util.HashMap;
import java.util.Map;

/**
 * Computer languages require brackets/pairs of characters (e.g., [], (), {}) to 
 * be balanced and non-overlapping. 
 * 
 * Implement a Matcher class that can check if a string contains balanced and 
 * non-overlapping brackets. Review MatcherTest carefully to learn about the
 * expected behaviours of this object.
 * 
 * Hint: there is a data structure that can help you check for balanced and 
 * non-overlapping brackets (see the Java Collections Framework slides).
 */
public class Matcher {
    private Map<Character, Character> pair; 

    
    /**
     * Constructs a Matcher object that uses the given pairs of characters to 
     * check whether brackets in a given string (see the match method) are 
     * balanced and non-overlapping.
     * @param pairs 
     */
    public Matcher(Map<Character, Character> pairs) {
        pair = pairs;

    }
    
    /**
     * Returns true if brackets in the given string are balanced.
     * @param s
     * @return 
     */
    public boolean match(String s) {
        
        Stack<Character> process = new Stack<>();
        
        for(int i = 0; i < s.length(); i++){
            char next = s.charAt(i);
           
        }
    }    
}
