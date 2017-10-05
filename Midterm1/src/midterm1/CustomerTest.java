package midterm1;

import java.math.BigDecimal;
import java.util.Set;

/**
 * CustomerTest contains code that tests and shows the expected behaviours of 
 * Customer. 
 * 
 * Run and analyze this class to see the expected behaviours and requirements
 * of Customer. Passing all of these tests, however, does not guarantee the 
 * correctness of your code. Study these test cases to understand the 
 * requirements of Customer and think carefully how you can implement these 
 * features properly.
 * 
 * Maximum points for Customer implementation: 35 points.
 * 5 out of 35 points are allocated for the overall quality of your Customer 
 * implementation. Recall best practices in programming that we've discussed in 
 * class.
 * 
 * Do not modify this class!
 */
public class CustomerTest {
    public static void main(String[] args) {
        // Each feature is worth 5 points, total 30 points
        testConstructor();
        testAddAccount();
        testRemoveAccount();
        testTotalBalance();
        testGetAccounts();
        testAccountSnapshot();
    }
    
    private static void testConstructor() {
        System.out.println("Test Customer Constructor: ");
        Customer andy = new Customer("Andy Williams", "Some address");
        System.out.println("pass test getName: " 
                + (andy.getName() == null ? false : 
                        andy.getName().equals("Andy Williams")));
        System.out.println("pass test getAddress: " 
                + (andy.getAddress() == null ? false : 
                        andy.getAddress().equals("Some address")));
        System.out.println("pass test getAccounts: " 
                + (andy.getAccounts() == null ? false : 
                        andy.getAccounts().isEmpty()));
        System.out.println();
    }
    
    private static void testAddAccount() {
        System.out.println("Test Add Account: ");
        Customer andy = new Customer("Andy Williams", "Some address");

        BankAccount checking = new BankAccount(123, new BigDecimal("500"));
        andy.add(checking);
        System.out.println("pass test add account: " 
                + (andy.getAccounts() == null ? false : 
                        andy.getAccounts().size() == 1));

        BankAccount savings = new BankAccount(456, new BigDecimal("1000"));
        andy.add(savings);        
        System.out.println("pass test add account: " 
                + (andy.getAccounts() == null ? false : 
                        andy.getAccounts().size() == 2));

        // trying to add the same account twice... should not change accounts
        andy.add(savings);        
        System.out.println("pass test add account: " 
                + (andy.getAccounts() == null ? false : 
                        andy.getAccounts().size() == 2));
        System.out.println();
    }
    
    private static void testRemoveAccount() {
        System.out.println("Test Remove Account: ");
        Customer andy = new Customer("Andy Williams", "Some address");

        BankAccount checking = new BankAccount(123, new BigDecimal("500"));
        andy.add(checking);
        BankAccount savings = new BankAccount(456, new BigDecimal("1000"));
        andy.add(savings);        
        System.out.println("pass test remove account: " 
                + (andy.getAccounts() == null ? false : 
                        andy.getAccounts().size() == 2));

        andy.remove(savings);        
        System.out.println("pass test remove account: " 
                + (andy.getAccounts() == null ? false : 
                        andy.getAccounts().size() == 1));        

        // trying to remove the same account twice... should not change accounts
        andy.remove(savings);        
        System.out.println("pass test remove account: " 
                + (andy.getAccounts() == null ? false : 
                        andy.getAccounts().size() == 1));  
        System.out.println();
    }
    
    private static void testTotalBalance() {
        System.out.println("Test Total Balance: ");
        Customer andy = new Customer("Andy Williams", "Some address");
        System.out.println("pass test total balance: " 
                + (andy.getTotalBalance() == null ? false : 
                        andy.getTotalBalance().compareTo(BigDecimal.ZERO) == 0));

        BankAccount checking = new BankAccount(123, new BigDecimal("500.01"));
        andy.add(checking);
        BigDecimal expected = new BigDecimal("500.01");
        System.out.println("pass test total balance: " 
                + (andy.getTotalBalance() == null ? false : 
                        andy.getTotalBalance().compareTo(expected) == 0));
                
        BankAccount savings = new BankAccount(456, new BigDecimal("1000.10"));
        andy.add(savings);    
        expected = new BigDecimal("1500.11");
        System.out.println("pass test total balance: " 
                + (andy.getTotalBalance() == null ? false : 
                        andy.getTotalBalance().compareTo(expected) == 0));
        System.out.println();        
    }
    
    private static void testGetAccounts() {
        System.out.println("Test Get Accounts: ");
        Customer andy = new Customer("Andy Williams", "Some address");

        BankAccount checking = new BankAccount(123, new BigDecimal("500"));
        andy.add(checking);
        BankAccount savings = new BankAccount(456, new BigDecimal("1000"));
        andy.add(savings);        
        System.out.println("pass test get accounts: " 
                + (andy.getAccounts() == null ? false : 
                        andy.getAccounts().size() == 2));
        System.out.println("pass test get accounts: " 
                + (andy.getAccounts().contains(checking)));
        System.out.println("pass test get accounts: " 
                + (andy.getAccounts().contains(savings)));

        Set<BankAccount> accounts = andy.getAccounts();
        BankAccount credit = new BankAccount(748);
        accounts.add(credit); // should not change Andy's accounts
        System.out.println("pass test get accounts: " 
                + (andy.getAccounts() == null ? false : 
                        andy.getAccounts().size() == 2));
        System.out.println("pass test get accounts: " 
                + (!andy.getAccounts().contains(credit)));
        System.out.println();        
    }
    
    private static void testAccountSnapshot() {
        System.out.println("Test Account Snapshot: ");
        Customer andy = new Customer("Andy Williams", "Some address");

        BankAccount checking = new BankAccount(123, new BigDecimal("500"));
        andy.add(checking);
        
        // Simulate getting a snapshot of Customer on Oct 18
        Customer andyOct18 = new Customer(andy);
        BigDecimal expected = new BigDecimal("500");
        System.out.println("pass test account snapshot: " 
                + (andyOct18.getTotalBalance() == null ? false : 
                        andyOct18.getTotalBalance().compareTo(expected) == 0));
        
        // Simulate a deposit on Oct 19
        checking.deposit(new BigDecimal("100"));
        // The deposit should not change the snapshot of Customer on Oct 18 
        System.out.println("pass test account snapshot: " 
                + (andyOct18.getTotalBalance() == null ? false : 
                        andyOct18.getTotalBalance().compareTo(expected) == 0));        

        // Simulate getting a snapshot of Customer on Oct 19
        Customer andyOct19 = new Customer(andy);
        expected = new BigDecimal("600");
        System.out.println("pass test account snapshot: " 
                + (andyOct19.getTotalBalance() == null ? false : 
                        andyOct19.getTotalBalance().compareTo(expected) == 0));    
    }
}
