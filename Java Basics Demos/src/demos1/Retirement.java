package demos1;

/**
 * Demonstrates the use of Scanner class to read input
 * 
 * @author Brian Brookwell
 */
import java.util.Scanner;

public class Retirement {
    /**
     * main -- This is called to run this application
     * 
     * @param args Parameters passed by system when application is run
     */
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        System.out.println("How old are you?");
        if (console.hasNextInt()) {
            int age = console.nextInt();

            int years = 65 - age;
            System.out.println(years + " years to retirement!");
        } else {
            System.out.println("Error: Invalid input value.");
        }
    }
}
