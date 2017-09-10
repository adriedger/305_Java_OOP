package demos1;

import java.util.Scanner;

/**
 * Reads numbers from input.  It discards non-integer inputs and continues until
 * the user enters a zero.  It then reports the number of entered values and
 * the values of the last two integers entered
 * 
 * @author brian brookwell
 */
public class LastTwo {
    
    /**
     * Executable main program for this demo
     * 
     * @param arg System command line arguments (ignored)
     */
    
    public static void main (String[] arg) {
        int count = 0;
        int last = -1;
        int previous = -1;
        
        Scanner console = new Scanner(System.in);
       
        int value = ReadInteger (console);
        
        while (value != 0) {
            previous = last;
            last = value;
            count++;
            
            value = ReadInteger (console);
        }
        
        System.out.println ("You entered " + count + " numbers and the last two are " +
                previous + " and " + last);
    }
    
    /**
     * Reads an integer from the input Scanner.  It discards non-integer inputs
     * 
     * @param console Scanner being read from
     * @return First integer in input read from the console Scanner
     */
    private static int ReadInteger (Scanner console) {
        do {
            System.out.print ("Enter a number (0 to quit:");
            if (console.hasNextInt()) {
                return console.nextInt();
            } else {
                String trash = console.nextLine();
            }
        } while (true); // Forever Loop
    }
}
