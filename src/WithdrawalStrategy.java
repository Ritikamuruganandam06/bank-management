public interface WithdrawalStrategy {
    boolean canWithdraw(double balance, double amount);   
}
