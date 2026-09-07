public class CurrentWithdrawalStrategy implements WithdrawalStrategy{
    private double overdraftLimit = 5000;
    public boolean canWithdraw(double balance, double amount) {
        return balance - amount >= -overdraftLimit;
    }
}
