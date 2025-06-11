package Application23;

import Application23.entities.Company;
import Application23.entities.Individual;
import Application23.entities.TaxPayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<TaxPayer> list = new ArrayList<>();

        System.out.print("Enter the number of tax payers: ");
        int n = sc.nextInt();

        for(int i=0;i<n;i++){
            System.out.print("Tax payer #" + (i+ 1) + " data: ");
            System.out.print("Individual or company (i/c)? ");
            char ch = sc.next().charAt(0);
            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Anual income: ");
            double anualIncome = sc.nextDouble();
            if(ch == 'i'){
                System.out.print("Health expenditures: ");
                double healthExpenditures = sc.nextDouble();
                list.add(new Individual(name,anualIncome,healthExpenditures));
            }
            else{
                System.out.print("Number of employees: ");
                int numberOfEmplooyes = sc.nextInt();
                list.add(new Company(name,anualIncome,numberOfEmplooyes));
            }

        }

        System.out.println("TAXES PAID");
        for(TaxPayer tax : list){
            System.out.println(tax.getName() + ": $ " + String.format("%.2f",tax.tax()));
        }


        System.out.println();

        double sum = 0.0;
        for(TaxPayer tax : list){
            sum += tax.tax();
        }

        System.out.println("TOTAL TAXES: $ " + String.format("%.2f",(sum)));


        sc.close();
    }
}
