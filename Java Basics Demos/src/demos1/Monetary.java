package demos1;

/**
 * This demonstrates how integer or BigDecimal can be used to handle exact values
 * such as money instead of double or float
 * 
 * @author Brian Brookwell
 */
import java.math.BigDecimal;

public class Monetary {
    /**
     * main -- This is called to run this application
     * 
     * @param args Parameters passed by system when application is run
     */
    public static void main(String[] args) {
        final BigDecimal TEN_CENTS = new BigDecimal(".10");

        BigDecimal funds = new BigDecimal("1.00");
        int itemsBought = 0;
        for (BigDecimal price = TEN_CENTS;
                funds.compareTo(price) >= 0;
                price = price.add(TEN_CENTS)) {
            funds = funds.subtract(price);
            itemsBought++;
        }

        System.out.println(itemsBought + " items bought");
        System.out.println("Change: $" + funds);
    }
}
