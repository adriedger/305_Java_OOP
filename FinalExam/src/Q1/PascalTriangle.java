/*
 * Macewan University CMPT 305 Professor: Brian Brookwell
 */
package Q1;

import java.util.Scanner;

/**
 *
 * @author adriedger
 */
public class PascalTriangle {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String in = "";        
        while(!in.equals("0")){         
            System.out.printf("Enter a Pascal Trinagle row (0 to quit): ");
            in = console.nextLine();
            Rows out = new Rows(Integer.parseInt(in));
            if(!in.equals("0"))
                System.out.println("Row "+ in +": " + out.getNumbers());
         }
    }
}
