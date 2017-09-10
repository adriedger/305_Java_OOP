package demos1;

/**
 * This program demonstrates the difficulty when using double or float when doing
 * an exact calculation
 * 
 * @author Brian Brookwell
 */
public class MonetaryUsingDouble {
    /**
     * main -- This is called to run this application
     * 
     * @param args Parameters passed by system when application is run
     */
    public static void main(String[] args) {
        double funds = 1.00;
        int itemsBought = 0;
        for (double price = .10; funds >= price; price += .10) {
            funds -= price;
            itemsBought++;
        }
        System.out.println(itemsBought + " items bought");
        System.out.println("Change: $" + funds);
    }
}
