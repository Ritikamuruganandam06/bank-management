package src;

public class Transaction {
    private int transactionId;
    private String transactionType;
    private double amount;
    
    public Transaction(int transactionId, String transactionType, double amount) {
    this.transactionId = transactionId;
    this.transactionType = transactionType;
    this.amount = amount;
}
    public int getTransactionId() {
        return transactionId;
    }
    public String getTransactionType() {
        return transactionType;
    }
    public double getAmount() {
        return amount;
    }
}
