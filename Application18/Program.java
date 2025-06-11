package Application18;

import Application18.entities.Client;
import Application18.entities.OrderItem;
import Application18.entities.Order;
import Application18.entities.OrderStatus;
import Application18.entities.Product;

import javax.swing.text.DateFormatter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter cliente data: ");
        System.out.print("Name: ");
        String clientName = sc.nextLine();
        System.out.print("E-mail: ");
        String clientEmail = sc.nextLine();
        System.out.print("Birth date (DD/MM/YYYY): ");
        Date birthDate = sdf.parse(sc.nextLine());
        Client client = new Client(clientName,clientEmail,birthDate);

        System.out.println("Enter order data: ");
        System.out.print("Status: ");
        String clientStatus = sc.nextLine();
        OrderStatus status = OrderStatus.valueOf(clientStatus.toUpperCase());

        Order order = new Order(new Date(),status,client);


        System.out.print("How many itens to this order?");
        int n = sc.nextInt();
        sc.nextLine();

        for(int i = 0; i<n; i++){
            System.out.println("Enter #" + (i + 1) + " item data: ");
            System.out.print("Product name: ");
            String productName = sc.nextLine();
            System.out.print("Product price: ");
            double productPrice = sc.nextDouble();
            sc.nextLine();

            Product product = new Product(productName,productPrice);

            System.out.print("Quantity: ");
            int productQuantity = sc.nextInt();
            sc.nextLine();

            OrderItem orderItem = new OrderItem(productQuantity,productPrice, product);
            order.addItem(orderItem);
        }

        System.out.println();
        System.out.println("ORDER SUMMARY: ");
        System.out.println(order);


        sc.close();
    }

}

