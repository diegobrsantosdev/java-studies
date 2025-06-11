package Application20;

import Application20.Entities.Emplooye;
import Application20.Entities.OutsourcedEmplooye;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Emplooye> list = new ArrayList<>();

        System.out.print("Enter the number of emplooyes: ");
        int n = sc.nextInt();

        for(int i=0;i<n;i++){
            System.out.println("Emplooye #" + (i+1) + " data: ");
            System.out.print("Outsourced? (y/n)? ");
            char ch = sc.next().charAt(0);
            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Hours: ");
            int hours = sc.nextInt();
            System.out.print("Value per hour: ");
            double valuePerHour = sc.nextDouble();

            if (ch == 'y') {
                System.out.print("Additional charge: ");
                double additionalCharge = sc.nextDouble();
                list.add(new OutsourcedEmplooye(name, hours, valuePerHour, additionalCharge));
            }
            else{
                list.add(new Emplooye(name,hours,valuePerHour));
            }

        }
        System.out.println();
        System.out.println("PAYMENTS:");
        for (Emplooye emp : list){
            System.out.println(emp.getName() + " - $ " + String.format("%.2f",emp.payment()));
        }

        sc.close();

    }
}
