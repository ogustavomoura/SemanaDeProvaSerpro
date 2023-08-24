import java.util.Locale;
import java.util.Scanner;

import entities.Account;

public class App {
    public static void main(String[] args){

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        Account account = new Account();

        System.out.print("Enter account number: ");
        int number = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter account holder: ");
        String holder = sc.nextLine();
        System.out.print("Is there an initial deposit (y/n) ? ");
        char option = sc.nextLine().charAt(0);
            if(option == 'y'){
                System.out.print("\nEnter initial deposit value: ");
                double initialAmount = sc.nextDouble();
                sc.nextLine();
                account = new Account(number, holder, initialAmount);
            }
            else{
                account = new Account(number, holder);
            }

        System.out.print("\nAccount data: \n" + account.toString());

        System.out.print("\nEnter a deposit value: ");
        double amount = sc.nextDouble();
        sc.nextLine();
        account.depositar(amount);
        System.out.print("\nUpdated account data: \n" + account.toString());

        System.out.print("\nEnter a withdraw value");
        amount = sc.nextDouble();
        account.saque(amount);
        System.out.print("\nUpdated account data: \n" + account.toString());
 
        sc.close();
    }
}
