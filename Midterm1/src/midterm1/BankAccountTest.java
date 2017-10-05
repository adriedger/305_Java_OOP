package midterm1;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * BankAccountTest contains code that tests and shows the expected behaviours of 
 * BankAccount.
 * 
 * Run this class to see the expected behaviours and requirements of BankAccount. 
 * Passing all of these tests, however, does not guarantee the correctness 
 * of your code. Study these test cases to understand the requirements of 
 * BankAccount and think carefully how you can implement the required features 
 * properly.
 * 
 * Maximum points for BankAccount implementation: 35 points.
 * 5 out of 35 points are allocated for the overall quality of your BankAccount 
 * implementation. Recall best practices in programming that we've discussed in 
 * class.
 * 
 * Do not modify this class!
 */
public class BankAccountTest {
    public static void main(String[] args) {       
        // Constructor tests: total 5 points for correct implementation of the 
        // constructors 
        testConstructorWithAccountNumber();                 
        testConstructorWithInitialDeposit();    
        testCopyConstructor();                  
        
        // Withdraw tests: total 5 points for correct implementation of withdraw
        testValidWithdraw();
        testInvalidWithdraw();
        
        // Deposit tests: total 5 points for correct implementation of deposit
        testValidDeposit();
        testInvalidDeposit();
        
        // Transfer tests: total 5 points for correct implementation of transfer
        testValidTransfer();
        testInvalidTransfer();
        
        // Misc tests: total 10 points
        testMisc();
    }
    
    private static void testConstructorWithAccountNumber() {
        System.out.println("Test Constructor with Account Number:");
        int accNumber = 12345;
        BankAccount acc = new BankAccount(accNumber);
        System.out.println("pass test account number: " 
                + (acc.getAccountNumber() == accNumber));
        
        System.out.println("pass test account balance: " 
                + (acc.getBalance() == null ? false :
                        acc.getBalance().compareTo(BigDecimal.ZERO) == 0));   
        System.out.println();
    }
    
    private static void testConstructorWithInitialDeposit() {
        System.out.println("Test Constructor with Initial Deposit:");
        int accNumber = 12345;
        BigDecimal initialDeposit = new BigDecimal("1000");
        BankAccount acc = new BankAccount(accNumber, initialDeposit);
        System.out.println("pass test account number: " 
                + (acc.getAccountNumber() == accNumber));
        
        System.out.println("pass test account balance: " 
                + (acc.getBalance() == null ? false :
                        acc.getBalance().compareTo(initialDeposit) == 0));   
        System.out.println();
    }  
    
    private static void testCopyConstructor() {
        System.out.println("Test Copy Constructor:");
        int accNumber = 54321;
        BigDecimal initialDeposit = new BigDecimal("2000");
        BankAccount acc = new BankAccount(accNumber, initialDeposit);
        BankAccount copy = new BankAccount(acc);
        System.out.println("pass test account number: " 
                + (acc.getAccountNumber() == accNumber &&
                        copy.getAccountNumber() == accNumber));
        
        System.out.println("pass test account balance: " 
                + ((acc.getBalance() == null || copy.getBalance() == null) ? false :
                        acc.getBalance().compareTo(copy.getBalance()) == 0)); 
        System.out.println();
    }      
    
    private static void testValidWithdraw() {
        System.out.println("Test Valid Withdraw:");
        int accNumber = 54321;
        BigDecimal initialDeposit = new BigDecimal("2000.75");
        BankAccount acc = new BankAccount(accNumber, initialDeposit);
        System.out.println("pass test initial balance: " 
                + (acc.getBalance() == null ? false :
                        acc.getBalance().compareTo(initialDeposit) == 0));
        
        acc.withdraw(new BigDecimal(".75"));
        acc.withdraw(new BigDecimal("500"));        
        BigDecimal expectedBalance = new BigDecimal("1500");
        System.out.println("pass test after withdraw: " 
                + (acc.getBalance() == null ? false :
                        acc.getBalance().compareTo(expectedBalance) == 0));        
        System.out.println();
    }
    
    private static void testInvalidWithdraw() {
        System.out.println("Test Invalid Withdraw:");
        int accNumber = 54321;
        BigDecimal initialDeposit = new BigDecimal("2000.75");
        BankAccount acc = new BankAccount(accNumber, initialDeposit);
        
        // Invalid withdraw request: negative amount
        // Invalid requests should not change the account's balance
        // If given invalid amount, withdraw should throw IllegalArgumentException
        try {
            acc.withdraw(new BigDecimal("-250"));
            // If exception is thrown properly, this message should not appear
            System.out.println("pass test invalid withdraw (negative amount): false");
        } catch (IllegalArgumentException e) {
            System.out.println("pass test invalid withdraw (negative amount): " 
                + (acc.getBalance() == null ? false :
                        acc.getBalance().compareTo(initialDeposit) == 0));                    
        }
        
        // Invalid withdraw request: amount exceeding balance
        try {
            acc.withdraw(new BigDecimal("500000"));
            System.out.println("pass test invalid withdraw (insufficient funds): false");
        } catch (IllegalArgumentException e) {
            System.out.println("pass test invalid withdraw (insufficient funds): " 
                + (acc.getBalance() == null ? false :
                        acc.getBalance().compareTo(initialDeposit) == 0));                    
        }
        System.out.println();
    }
    
    private static void testValidDeposit() {
        System.out.println("Test Valid Deposit:");
        int accNumber = 63829;
        BankAccount acc = new BankAccount(accNumber);
        acc.deposit(new BigDecimal("525.75"));
        acc.deposit(new BigDecimal("121.43"));
        BigDecimal expectedBalance = new BigDecimal("647.18");
        System.out.println("pass test valid deposit: " 
                + (acc.getBalance() == null ? false :
                        acc.getBalance().compareTo(expectedBalance) == 0));        
        System.out.println();         
    }
    
    private static void testInvalidDeposit() {
        System.out.println("Test Invalid Deposit:");
        int accNumber = 54321;
        BigDecimal initialDeposit = new BigDecimal("2000.75");
        BankAccount acc = new BankAccount(accNumber, initialDeposit);
        
        // Invalid deposit request: negative amount
        // Invalid requests should not change the account's balance
        // If given invalid amount, deposit should throw IllegalArgumentException
        try {
            acc.deposit(new BigDecimal("-250"));
            // If exception is thrown properly, this message should not appear
            System.out.println("pass test invalid deposit (negative amount): false");
        } catch (IllegalArgumentException e) {
            System.out.println("pass test invalid deposit (negative amount): " 
                + (acc.getBalance() == null ? false :
                        acc.getBalance().compareTo(initialDeposit) == 0));                    
        }
        
        System.out.println();        
    }
    
    private static void testValidTransfer() {
        System.out.println("Test Valid Transfer:");
        BankAccount sender = new BankAccount(63829, new BigDecimal("5000"));
        BankAccount recipient = new BankAccount(26728);
        
        sender.transfer(new BigDecimal("100.01"), recipient);
        sender.transfer(new BigDecimal(".24"), recipient);
        
        BigDecimal senderExpectedBalance = new BigDecimal("4899.75");
        System.out.println("pass test valid transfer: " 
            + (sender.getBalance() == null ? false :
                sender.getBalance().compareTo(senderExpectedBalance) == 0));                    
        
        BigDecimal recipientExpectedBalance = new BigDecimal("100.25");
        System.out.println("pass test valid transfer: " 
            + (recipient.getBalance() == null ? false :
                recipient.getBalance().compareTo(recipientExpectedBalance) == 0));        
        System.out.println();         
    }
    
    private static void testInvalidTransfer() {
        System.out.println("Test Invalid Transfer:");
        BigDecimal initialDeposit = new BigDecimal("5000");
        BankAccount sender = new BankAccount(63829, initialDeposit);
        BankAccount recipient = new BankAccount(26728, initialDeposit);
        
        // Invalid transfer request: negative amount
        // Invalid requests should not change the account's balance
        // If given invalid amount, transfer should throw IllegalArgumentException
        try {
            sender.transfer(new BigDecimal("-250"), recipient);
            // If exception is thrown properly, this message should not appear
            System.out.println("pass test invalid transfer (negative amount): false");
        } catch (IllegalArgumentException e) {
            System.out.println("pass test invalid transfer (negative amount): " 
                + (sender.getBalance() == null ? false :
                        sender.getBalance().compareTo(initialDeposit) == 0));                    
            System.out.println("pass test invalid transfer (negative amount): " 
                + (recipient.getBalance() == null ? false :
                        recipient.getBalance().compareTo(initialDeposit) == 0));                    
        }
        
        // Invalid transfer request: amount exceeding balance
        try {
            sender.transfer(new BigDecimal("500000"), recipient);
            System.out.println("pass test invalid transfer (insufficient funds): false");
        } catch (IllegalArgumentException e) {
            System.out.println("pass test invalid transfer (insufficient funds): " 
                + (sender.getBalance() == null ? false :
                        sender.getBalance().compareTo(initialDeposit) == 0));                    
            System.out.println("pass test invalid transfer (insufficient funds): " 
                + (recipient.getBalance() == null ? false :
                        recipient.getBalance().compareTo(initialDeposit) == 0));                    
        }
        System.out.println();        
    }
    
    private static void testMisc() {
        System.out.println("Test Misc:");
        Set<BankAccount> accounts = new HashSet<>();
        BankAccount acc = new BankAccount(12345, new BigDecimal("1000000.1"));
        accounts.add(acc);
        accounts.add(new BankAccount(12345, new BigDecimal("1000000.1")));
        System.out.println("pass test accounts size: " 
                + (accounts.size() == 1));
        
        String expected = "12345 ($1,000,000.10)";
        System.out.println("pass test account toString: " 
                + (acc.toString().equals(expected)));
    }
}
