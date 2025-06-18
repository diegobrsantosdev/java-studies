package Application27;

import Application27.model.services.BrazilTaxService;
import Application27.model.services.RentalService;
import Application27.motel.entities.CarRental;
import Application27.motel.entities.Vehicle;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        System.out.println("Enter with rent data: ");
        System.out.print("Car model: ");
        String carModel = sc.nextLine();
        System.out.print("Start date (dd/MM/yyyy hh:mm): ");
        LocalDateTime start = LocalDateTime.parse(sc.nextLine(), fmt);
        System.out.print("Return date (dd/MM/yyyy hh:mm): ");
        LocalDateTime finish = LocalDateTime.parse(sc.nextLine(), fmt);

        CarRental cr = new CarRental(start,finish,new Vehicle(carModel));

        System.out.print("Enter with price per hour: ");
        double pricePerHour = sc.nextDouble();
        System.out.print("Enter with price per day: ");
        double pricePerDay = sc.nextDouble();

        RentalService rentalService = new RentalService(pricePerHour,pricePerDay,new BrazilTaxService());

        rentalService.processInvoice(cr);

        System.out.println("INVOICE: ");
        System.out.println("Basic payment: " + String.format("%.2f",cr.getInvoice().getBasicPayment()));
        System.out.println("Tax: " + String.format("%.2f",cr.getInvoice().getTax()));
        System.out.println("Total payment: " + String.format("%.2f",cr.getInvoice().getTotalPayment()));


        sc.close();

    }
}
