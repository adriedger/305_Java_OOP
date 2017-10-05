package  midterm1;

import java.math.BigDecimal;

/**
 * A simplistic BankAccount class.
 * 
 * Instructions: add the necessary code to make this class work properly.
 * Please see and analyze the BankAccountTest class to see the expected 
 * behaviour of this class.
 */
public class BankAccount {   
    private int accountNumber;
    private BigDecimal balance;
    
    /**
     * Constructs a BankAccount object.
     * This constructor sets the account number to the given account number and
     * the account balance to zero.
     * @param accountNumber 
     */
    public BankAccount(int accountNumber) {
        
    }
    
    /**
     * Constructs a BankAccount object with the given account number and initial
     * deposit. 
     * This constructor sets the account number to the given account number and
     * the account balance to the initial deposit.
     * @param accountNumber
     * @param initialDeposit 
     */
    public BankAccount(int accountNumber, BigDecimal initialDeposit) {
        
    }
    
    /**
     * Constructs a BankAccount object that has the same account number and
     * balance to those of the given account.
     * @param account 
     */
    public BankAccount(BankAccount account) {

    }
    
    /**
     * Withdraws the given amount from this account.
     * Prerequisites: amount must be greater than zero and there must be 
     * sufficient funds in this account.
     * @param amount 
     */
    public void withdraw(BigDecimal amount) {

    }
    
    /**
     * Returns the balance of this account.
     * @return balance 
     */
    public BigDecimal getBalance() {
        return balance;
    }
    
    /**
     * Returns the account number.
     * @return account number
     */
    public int getAccountNumber() {
        return accountNumber;
    }
    
    /**
     * Transfers the given amount to the recipient account.
     * Prerequisites: amount must be greater than zero and there must be 
     * sufficient funds in this account.
     * @param amount
     * @param recipient 
     */
    public void transfer(BigDecimal amount, BankAccount recipient) {

    }
    
    /**
     * Deposits the given amount to this account.
     * Prerequisite: amount must be greater than zero.
     * @param amount 
     */
    public void deposit(BigDecimal amount) {

    }
    
}
