/*
 * Macewan University CMPT 305 Professor: Brian Brookwell
 */
package lab4Q1;

import java.util.Scanner;

/**
 * This text-based program finds the edit distance (the number of jumps between words 
 * with characters that need to be switched, added or removed once to modify it to the next word)
 * between  a start word and a destination word in a dictionary text file.
 * 
 * @author adriedger
 */
public class Lab4Q1 {

    /**
     * Main function of Lab4Q1
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Welcome to the edit distance calculator\n" +
                                "Initializing dictionary...");
        ReadDict reader = new ReadDict("dict.txt");
        Scanner console = new Scanner(System.in);
        String str1 = "";
        int dist = 0;
        while(!str1.equals("0")){ 
            System.out.printf("Please enter two words (or 0 to quit): ");
            String line = console.nextLine();
            Scanner tokenizer = new Scanner(line);
            str1 = tokenizer.next();
            if(tokenizer.hasNext()){
                String str2 = tokenizer.next();
                if(reader.checkInDict(str1) && reader.checkInDict(str2)){
                    dist = reader.calculateDistance(str1, str2);
                    if(dist < 1000000)
                        System.out.println("Edit distance: " + dist);
                    else
                        System.out.println("Edit distance: no path exists");
                }
                else
                    System.out.println("Input word(s) not found in the dictionary");
            }
        }
    }    
}
