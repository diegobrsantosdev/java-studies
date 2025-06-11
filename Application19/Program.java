package Application19;

import Application19.entities.Account;
import Application19.entities.BusinessAccount;
import Application19.entities.SavingsAccount;

import java.util.ArrayList;
import java.util.List;

public class Program {

    public static void main(String[] args) {


        Account acc = new Account(1001, "Alex", 0.0);
        BusinessAccount bacc = new BusinessAccount(1002, "Maria", 0.0, 500.0);

        //UPCASTING

        Account acc1 = bacc;
        Account acc2 = new BusinessAccount(1003, "Bob", 0.0, 200.0);
        Account acc3 = new SavingsAccount(1004, "Anna", 0.0, 0.01);


        //DOWNCASTING

        BusinessAccount acc4 = (BusinessAccount) acc2;
        acc4.loan(100.0);

        //BusinessAccount acc5 = (BusinessAccount)acc3;
        if (acc3 instanceof BusinessAccount) {
            BusinessAccount acc5 = (BusinessAccount) acc3;
            acc5.loan(200.0);
            System.out.println("Loal!");
        }
        if (acc3 instanceof SavingsAccount) {
            SavingsAccount acc5 = (SavingsAccount) acc3;
            acc5.updateBalance();
            System.out.println("Update!");
        }

        //SOBREPOSIÇÃO

        Account acc5 = new Account(1005, "Diego", 1000.0);
        acc5.withdraw(200.0);
        System.out.println(acc5.getBalance());


        Account acc6 = new SavingsAccount(1006, "Thiago", 1000.0, 0.01);
        acc6.withdraw(200.0);
        System.out.println(acc6.getBalance());


        Account acc7 = new BusinessAccount(1007, "Di", 1000.0, 500.0);
        acc7.withdraw(200.0);
        System.out.println(acc7.getBalance());
    }
}


  /*
    List<Account> list = new ArrayList<>();

    list.add(new SavingsAccount(1001, "Alex", 500.00, 0.01));
    list.add(new BusinessAccount(1002, "Maria", 1000.0, 400.0));
    list.add(new SavingsAccount(1004, "Bob", 300.0, 0.01));
    list.add(new BusinessAccount(1005, "Anna", 500.0, 500.0));

    double sum = 0.0;
    for (Account acc : list) {
        sum += acc.getBalance();
    }

    System.out.printf("Total balance: %.2f%n", sum);

    for (Account acc : list) {
        acc.deposit(10.0);
    }
    for (Account acc : list) {
        System.out.printf("Updated balance for account %d: %.2f%n", acc.getNumber(), acc.getBalance());
    }
*/
