import java.util.Locale;
import java.util.Scanner;

import entities.Account;
import exceptions.BusinessException;

public class App {
    public static void main(String[] args) throws Exception {
        
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter account data");
        System.out.print("\nNumber: ");
        int number = sc.nextInt();
        sc.nextLine();
        System.out.print("Holder: ");
        String holder = sc.nextLine();
        System.out.print("Initial balance: ");
        double initialBalance = sc.nextDouble();
        sc.nextLine();
        System.out.print("Withdraw limit: ");
        double withdrawLimit = sc.nextDouble();
        sc.nextLine();

        // public Account(Integer number, String holder, Double balance, Double withdrawLimit)
        Account account = new Account(number, holder, initialBalance, withdrawLimit);
       
        System.out.print("\nEnter amount for withdraw: $");
        double amount = sc.nextDouble();

        try{
            account.withdraw(amount);
            System.out.print("New balance: $" + account.getBalance());
        }
        catch(BusinessException e){
            System.out.println("Erro: " + e.getMessage());
        }

        sc.close();
        
    }
}
