package demos1;

import java.util.Scanner;

/**
 * This parses an input line consisting of pairs of integer and String tokens.
 * For each pair of values, the program generates and outputs a new string 
 * containing the input string repeated the indicated number of times
 * 
 * @author Brian Brookwell
 */
public class PrintStrings {
    /**
     * main -- This is called to run this application
     * 
     * @param args Parameters passed by system when application is run
     */
    public static void main(String[] args) {
        printStrings ("6   fun.  3 hello    10          <>  2   25 4 wow!");
    }
    
    /**
     * Parses a line consisting of integer + string pairs and produces a line
     * of output for each pair consisting of the indicated number of repetitions
     * of the string
     * 
     * @param input String being parsed
     */
    
    public static void printStrings (String input) {
        Scanner parser = new Scanner (input);
        
        while (parser.hasNextInt()) {
            int n = parser.nextInt();
            
            if (parser.hasNext()) {
                String word = parser.next();
               
                System.out.println (padLine (word, n));
            } else {
                return;
            }
        }
    }
    
    /**
     * Creates a string consisting of a word repeated a number of times
     * 
     * @param word String token being repeated
     * @param repeats Number of times to repeat the token
     * @return String containing 'word' repeated 'repeats' times
     */
    private static String padLine (String word, int repeats) {
        StringBuilder builder = new StringBuilder();
                
        for (int i=0;i < repeats;i++) {
            builder.append (word);
        }
        
        return builder.toString();
    }
}
 