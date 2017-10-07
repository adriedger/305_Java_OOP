package  midterm1;

import java.math.BigDecimal;
import java.text.NumberFormat;

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
     * @param inNumber 
     */
    public BankAccount(int inNumber) {
        accountNumber = inNumber;
        balance = new BigDecimal("0");        
    }
    
    /**
     * Constructs a BankAccount object with the given account number and initial
     * deposit. 
     * This constructor sets the account number to the given account number and
     * the account balance to the initial deposit.
     * @param inNumber
     * @param initialDeposit 
     */
    public BankAccount(int inNumber, BigDecimal initialDeposit) {
        accountNumber = inNumber;
        balance = new BigDecimal("0");
        balance = initialDeposit;        
    }
    
    /**
     * Constructs a BankAccount object that has the same account number and
     * balance to those of the given account.
     * @param account 
     */
    public BankAccount(BankAccount account) {
        accountNumber = account.getAccountNumber();
        balance = new BigDecimal("0");
        balance = account.getBalance();        
    }
    
    /**
     * Withdraws the given amount from this account.
     * Prerequisites: amount must be greater than zero and there must be 
     * sufficient funds in this account.
     * @param amount 
     */
    public void withdraw(BigDecimal amount) {
        if(amount.compareTo(new BigDecimal("0")) == 1){
//            System.out.println("amount > 0");
            if(!(this.balance.subtract(amount).compareTo(new BigDecimal("0")) == -1)){
                this.balance = this.balance.subtract(amount);
            }
            else
                throw new IllegalArgumentException();
        }
        else
            throw new IllegalArgumentException();
    }
    
    /**
     * Returns the balance of this account.
     * @return balance 
     */
    public BigDecimal getBalance() {
        return new BigDecimal(balance.toString());
        
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
        this.withdraw(amount);
        recipient.deposit(amount);
    }
    
    /**
     * Deposits the given amount to this account.
     * Prerequisite: amount must be greater than zero.
     * @param amount 
     */
    public void deposit(BigDecimal amount) {
        if(amount.compareTo(new BigDecimal("0")) == 1){
            this.balance = this.balance.add(amount);
        }
        else
            throw new IllegalArgumentException();            
    }
    
    @Override
    public String toString(){
        return this.accountNumber + " (" + NumberFormat.getCurrencyInstance().format(this.balance) + ")";       
    }
    //for the .size for the hash set
    @Override
    public boolean equals(Object o){
        if(o instanceof BankAccount)
            return this.accountNumber == ((BankAccount) o).accountNumber;
        return false;        
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + this.accountNumber;
        return hash;
    }
}
