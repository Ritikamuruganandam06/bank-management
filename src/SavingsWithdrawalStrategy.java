public class SavingsWithdrawalStrategy implements WithdrawalStrategy{
    private double minimumBalance = 1000;
    public boolean canWithdraw(double balance, double amount) {
        return balance - amount >= minimumBalance;
    }
    
}
