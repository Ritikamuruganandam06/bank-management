
import java.util.ArrayList;
import java.util.List;

public class BankService {
    private List<Account> accounts = new ArrayList<>();
    private int transactionCounter = 1;

    public boolean accountExists(int accountNumber) {
        for(Account account : accounts) {
            if(account.getAccountNumber() == accountNumber) {
                return true;
            }
        }
        return false; 
    }
    public void addAccount(Account account) {
        if (account.getAccountNumber() <= 0) {
        System.out.println("Invalid account number.");
        return;
    }

    if (account.getCustomerName() == null ||
        account.getCustomerName().trim().isEmpty()) {
        System.out.println("Customer name cannot be empty.");
        return;
    }

    if (account.getAccountType() == null ||
        account.getAccountType().trim().isEmpty()) {
        System.out.println("Account type cannot be empty.");
        return;
    }
        if(accountExists(account.getAccountNumber())) {
            System.out.println("Account number already exists.");
            return;
        }
        accounts.add(account);
        System.out.println("Account created successfully.");
    }
    public Account findAccount(int accountNumber) {
        for(Account account : accounts) {
            if(account.getAccountNumber() == accountNumber) {
                return account;
            }
        }
        return null;
    }
    public void viewAccount(int accountNumber) {
        Account account = findAccount(accountNumber);
        if(account == null) {
            System.out.println("account not found");
            return;
        }
        System.out.println("Account Number: " + account.getAccountNumber());
        System.out.println("Customer Name: " + account.getCustomerName());
        System.out.println("Account Type: " + account.getAccountType());
        System.out.println("Balance: " + account.getBalance());
    }
    public void deposit(int accountNumber, double amount) {
        Account account = findAccount(accountNumber);
        if(account == null) {
            System.out.println("account not found");
            return;
        }
        if (amount <= 0) {
        System.out.println("Deposit amount must be greater than 0.");
        return;
    }
        account.deposit(amount, transactionCounter);
        transactionCounter++;
        System.out.println("deposited successfully");
        System.out.println("updated balance: "+account.getBalance());
    }
    public void withdraw(int accountNumber, double amount) {
        Account account = findAccount(accountNumber);
        if(account == null) {
            System.out.println("account not found");
            return;
        }

        if (amount <= 0) {
            System.out.println("Withdrawal amount must be greater than 0.");
            return;
        }

        if(!account.withdraw(amount, transactionCounter)) {
                System.out.println("insufficient balance");
                return;
        }
        
        transactionCounter++;
        System.out.println("withdraw successful");
        System.out.println("updated balance: "+account.getBalance());
    }
    public void checkBalance(int accountNumber) {
        Account account = findAccount(accountNumber);
        if(account == null) {
             System.out.println("account not found");
            return;
        }
        System.out.println("balance: "+account.getBalance());
    }
    public void showTransactions(int accountNumber) {
        Account account = findAccount(accountNumber);
        if(account == null) {
             System.out.println("account not found");
            return;
        }
        if(account.getTransactions().isEmpty()) {
            System.out.println("no transactions found");
            return;
        }
        for(Transaction transaction : account.getTransactions()) {
            System.out.println("transaction id: "+transaction.getTransactionId());
            System.out.println("transaction type: "+transaction.getTransactionType());
            System.out.println("Amount: " + transaction.getAmount());
            System.out.println("-------------------------");
        }
    }
    public void deleteAccount(int accountNumber) {
        Account account = findAccount(accountNumber);
        if(account == null) {
             System.out.println("account not found");
            return;
        }
        accounts.remove(account);
        System.out.println("Account deleted successfully.");
    }
}
