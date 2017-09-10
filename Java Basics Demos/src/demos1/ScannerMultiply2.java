/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demos1;

/**
 * Scanner Multiply demonstrates using Scanner to get two integers from consol
 * This version uses the nextInt to ensure there is data
 * 
 * @author brian brookwell
 */
import java.util.Scanner;

public class ScannerMultiply2 {
    /**
     * Runs the Scanner Input multiply program
     * 
     * @param args System arguments of command used to run the program (ignored)
     */
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        System.out.print("Please type two integers: "); 
        if (console.hasNextInt()) {
            int num1 = console.nextInt();
            
            if (console.hasNextInt()) {
                int num2 = console.nextInt();

                int product = num1 * num2;

                System.out.println("The product is " + product); 
            } else {
                System.out.println ("The second value is not an integer");
            }   
        } else {
            System.out.println ("The first value is not an integer");
        }
        
    }
}