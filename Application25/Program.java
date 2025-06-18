package Application25;
import Application25.entities.Account;
import Application25.entities.Exceptions.WithdrawLimitExceededException;
import Application25.entities.Exceptions.InsufficientBalanceException;
import Application25.entities.Exceptions.InvalidValueException;


import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("Enter account data ");
            System.out.print("Account number: ");
            int number = sc.nextInt();
            sc.nextLine();
            System.out.print("Holder: ");
            String holder = sc.nextLine();
            System.out.print("Initial balance: ");
            double balance = sc.nextDouble();
            System.out.print("Withdraw limit: ");
            double withdrawLimit = sc.nextDouble();
            Account account = new Account(number, holder, balance, withdrawLimit);

            System.out.print("Enter amount for withdraw: ");
            double amount = sc.nextDouble();
            account.withdraw(amount);
            System.out.println("New balance: " + account.getBalance());

            } catch (InvalidValueException e) {
                System.out.println("Invalid value error: " + e.getMessage());
            } catch (WithdrawLimitExceededException e) {
                System.out.println("Withdraw error: " + e.getMessage());
            } catch (InsufficientBalanceException e) {
                System.out.println("Amount error: " + e.getMessage());
            } catch (RuntimeException e) {
                System.out.println("Unexpected error: " + e.getMessage());
            }

        System.out.println("Program finished.");

        sc.close();

    }
}
