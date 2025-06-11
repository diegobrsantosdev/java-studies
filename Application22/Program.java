package Application22;

import Application22.entities.Circle;
import Application22.entities.Color;
import Application22.entities.Rectangle;
import Application22.entities.Shape;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Shape> list = new ArrayList<>();

        System.out.print("Enther the number of shapes: ");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println("Shape # " + (i + 1) + " data: ");
            System.out.print("Rectangle or Circle (r/c)?");
            char ch = sc.next().charAt(0);
            System.out.print("Color (BLACK/BLUE/RED): ");
            Color color = Color.valueOf(sc.next());
            if (ch == 'r') {
                System.out.print("Width: ");
                double width = sc.nextDouble();
                System.out.print("Height: ");
                double height = sc.nextDouble();
                list.add(new Rectangle(color, width, height));

            } else {
                System.out.print("Radius: ");
                double radius = sc.nextDouble();
                list.add(new Circle(color,radius));
            }
        }

        System.out.println();
        System.out.println("SHAPE AREAS");

        for(Shape shape : list){
            System.out.printf("%.2f%n", shape.area());
        }

        sc.close();

    }
}
