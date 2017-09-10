package demos1;

import java.util.Scanner;

/**
 * This reads integers from the user until the user enters a zero.  The program
 * outputs the number of items entered and the last two values
 * 
 * @author Brian Brookwell
 */
public class LoopDemo {
    
    /**
     * main -- This is called to run this application
     * 
     * @param args Parameters passed by system when application is run
     */
    public static void main(String[] args) {
        int lastValue = -1;
        int previousValue = -1;
        int valueCount = 0;
        
        Scanner scanner = new Scanner (System.in);
        
        System.out.print ("Enter a value (0 to stop):");
        int value = scanner.nextInt ();
        while (value != 0) {
            valueCount++;
            previousValue = lastValue;
            lastValue = value;
            
            System.out.print ("Enter a value (0 to stop):");
            value = scanner.nextInt ();
        }
        
        System.out.println ("Number of values: " + valueCount);
        System.out.println ("Last two values were " + previousValue + " and " + lastValue);
    }
}
