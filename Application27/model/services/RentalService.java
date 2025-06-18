package Application27.model.services;

import Application27.motel.entities.CarRental;
import Application27.motel.entities.Invoice;

import java.time.Duration;

public class RentalService {

    private Double pricePerDay;
    private Double pricePerHour;

    private TaxService taxService;

    public RentalService(Double pricePerDay, Double pricePerHour, TaxService taxService) {
        this.pricePerDay = pricePerDay;
        this.pricePerHour = pricePerHour;
        this.taxService = taxService;
    }


    public void processInvoice(CarRental carRental){


       double minutes = Duration.between(carRental.getStart(),carRental.getFinish()).toMinutes();
       double hours = minutes / 60;

       double basicPayment;
       if(hours <= 12.0){
            basicPayment = pricePerHour * Math.ceil(hours);
       }
       else{
            basicPayment = pricePerHour * Math.ceil(hours/24);
       }

       double tax = taxService.tax(basicPayment);

        carRental.setInvoice(new Invoice(basicPayment,tax));


    }
}
