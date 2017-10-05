package midterm1;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * A simplistic Customer class. 
 * 
 * The main objective of this class is to manage the customer's information and 
 * their bank accounts.
 * 
 * Requirements: any changes to the customer's information and their accounts
 * must be done through the Customer's public methods. That is, no other classes
 * should be able to change the attributes of a customer and the contents of 
 * accounts directly.
 * 
 * Instructions: this provided class does not satisfy all requirements above or 
 * follow best practices in programming (as discussed in class). 
 * Add or fix the code so that it meets all of the requirements and follows 
 * best practices in object-oriented Java programming.
 * 
 * CustomerTest class contains code that uses the BankAccount and Customer 
 * classes. After you modify the BankAccount and Customer classes, CustomerTest 
 * should work properly without any modification.
 */
public class Customer {

    
    public Customer(String name, String address) {

    }
    
    /**
     * Constructs a snapshot of Customer.
     * @param customer 
     */
    public Customer(Customer customer) {

    }
    
    public void add(BankAccount account) {
        
    }
    
    public void remove(BankAccount account) {
        
    }
    
    public String getAddress() {
        return "";
    }
    
    public String getName() {
        return "";
    }
    
    public BigDecimal getTotalBalance() {
        return BigDecimal.ZERO;
    }
    
    public Set getAccounts() {
        return new HashSet();
    }
    
}
