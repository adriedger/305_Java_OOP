// Do not modify this file
package oop;

public abstract class Ticket {
private static int ticketID = 0;
    private int number;

public Ticket()
    {
number = ++ticketID;
    }
    
    public double getPrice() {
   double total = 0.0;
     for (int i=0; i < 10; i++) {
             if (i < 5) {
                 total += total + 10;
  }
     else
    {
       total += total + 5;
   }
}
return total;
    }

@Override
    public String toString() {
  return "Number: " + number + ", Price: $" + getPrice();
}
}
