/*
 * Macewan University CMPT 305 Professor: Brian Brookwell
 */
package Q4;

/**
 *
 * @author adriedger
 */
public class Q4Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Model car1 = new Sedan();
        System.out.println(car1.getDescription() + " $" + car1.cost());
        //Sedan with winter tires and extended warranty
        Model car2 = new Sedan();
        car2 = new WinterTires(car2);
        car2 = new Warranty(car2);
        System.out.println(car2.getDescription() + " $" + car2.cost());
        //Sports Car with security
        Model car3 = new SportsCar();
        car3 = new Security(car3);
        System.out.println(car3.getDescription() + " $" + car3.cost());
    }
    
}
