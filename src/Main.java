import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankService service = new BankService();
        while (true) {

        System.out.println("\n===== BANK MANAGEMENT SYSTEM =====");
        System.out.println("1. Create Account");
        System.out.println("2. View Account");
        System.out.println("3. Deposit");
        System.out.println("4. Withdraw");
        System.out.println("5. Check Balance");
        System.out.println("6. Transaction History");
        System.out.println("7. Delete Account");
        System.out.println("8. Exit");

        try {
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();
        switch(choice) {
            case 1 : {
                System.out.println("enter account number: ");
                int accountNumber = sc.nextInt();
                sc.nextLine();
                System.out.println("enter customer name: ");
                String customerName = sc.nextLine();
                System.out.print("Enter Account Type: ");
                String accountType = sc.nextLine();
                Account account = new Account(accountNumber, customerName, accountType);
                service.addAccount(account);
                break;
            }
            case 2 : {
                System.out.print("Enter Account Number: ");
                int accountNumber = sc.nextInt();
                service.viewAccount(accountNumber);
                break;
            }
            case 3 : {
                 System.out.print("Enter Account Number: ");
                int accountNumber = sc.nextInt();
                System.out.print("Enter Deposit Amount: ");
                double amount = sc.nextDouble();
                service.deposit(accountNumber, amount);
                break;
            }
            case 4 : {
                System.out.print("Enter Account Number: ");
                int accountNumber = sc.nextInt();
                System.out.print("Enter Withdrawal Amount: ");
                double amount = sc.nextDouble();
                service.withdraw(accountNumber, amount);
                break;
            }
            case 5 : {
                System.out.print("Enter Account Number: ");
                int accountNumber = sc.nextInt();
                service.checkBalance(accountNumber);
                break;
            }
            case 6 : {
                System.out.print("Enter Account Number: ");
                int accountNumber = sc.nextInt();
                service.showTransactions(accountNumber);
                break;
            }
            case 7 : {
                System.out.print("Enter Account Number: ");
                int accountNumber = sc.nextInt();
                service.deleteAccount(accountNumber);
                break;
            }
            case 8: {
                System.out.println("Thank you for using the Bank Management System.");
                return;
            }
            default: {
            System.out.println("Invalid choice.");
            break;
            }
        
        }
    } catch(InputMismatchException e) {
            System.out.println("Please enter a valid number.");
            sc.nextLine();
    }

}
    }
}
