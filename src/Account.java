import java.util.ArrayList;
import java.util.List;  

public class Account {
    private int accountNumber;
    private String customerName;
    private String accountType;
    private double balance;
    private List<Transaction> transactions;

    public Account(int accountNumber, String customerName, String accountType) {
        this.accountNumber = accountNumber;
        this.customerName = customerName;
        this.accountType = accountType;
        this.balance = 0;
        this.transactions = new ArrayList<>();
        
    }
    public int getAccountNumber() {
        return accountNumber;
    }
    public String getCustomerName() {
        return customerName;
    }
    public String getAccountType() {
        return accountType;
    }
    public double getBalance() {
        return balance;
    }
    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
    public void deposit(double amount, int transactionId) {
        balance += amount;
        Transaction transaction = new Transaction(transactionId, "DEPOSIT", amount);
        transactions.add(transaction);
    }
    public boolean withdraw(double amount, int transactionId) {
        if(amount > balance) {
            return false;
        }
        balance -= amount;
        Transaction transaction = new Transaction(transactionId, "WITHDRAW", amount);
        transactions.add(transaction);
        return true;
    }
    public List<Transaction> getTransactions() {
        return transactions;
    }
}