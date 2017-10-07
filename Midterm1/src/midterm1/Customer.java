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
    private String name;
    private String address;
    private Set<BankAccount> bankAccounts;

    
    public Customer(String inName, String inAddress) {
        name = inName;
        address = inAddress;
        bankAccounts = new HashSet<>();
    }
    
    /**
     * Constructs a snapshot of Customer.
     * @param customer 
     */
    public Customer(Customer customer) {
        name = customer.getName();
        address = customer.getAddress();
        bankAccounts = new HashSet<>();
        bankAccounts.addAll(customer.getAccounts());

    }
    
    public void add(BankAccount account) {
        bankAccounts.add(account);
        
    }
    
    public void remove(BankAccount account) {
        bankAccounts.remove(account);
    }
    
    public String getAddress() {
        return address;
    }
    
    public String getName() {
        return name;
    }
    
    public BigDecimal getTotalBalance() {
        BigDecimal total = new BigDecimal("0");
        for(BankAccount b : bankAccounts){
            total = total.add(b.getBalance());
        }
        return total;
    }
    
    public Set getAccounts() {
        Set<BankAccount> copy = new HashSet<>();
        for (BankAccount b : bankAccounts)
            copy.add(new BankAccount (b));
        return copy;
    }
    
}
