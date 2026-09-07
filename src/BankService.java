package src;
import java.util.ArrayList;
import java.util.List;

public class BankService {
    private List<Account> accounts = new ArrayList<>();
    public boolean accountExists(int accountNumber) {
        for(Account account : accounts) {
            if(account.getAccountNumber() == accountNumber) {
                return true;
            }
        }
        return false; 
    }
    public void addAccount(Account account) {
        if(accountExists(account.getAccountNumber())) {
            System.out.println("Account number already exists.");
            return;
        }
        accounts.add(account);
        System.out.println("Account created successfully.");
    }
}
