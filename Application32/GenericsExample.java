package Application32;

import java.util.ArrayList;

public class GenericsExample {

    public static void main(String[] args) {

      /*
        printer.print();
        Printer<Double> doubleprinter = new Printer<>(33.5);
        ArrayList<Cat> cats = new ArrayList<>();
        cats.add(new Cat());
        Cat myCat = cats.get(0);
       */

        shout("Jhon");
        shout(57);
        shout(new Cat());

    }
    private static <T> void shout (T thingtoShout){
        System.out.println(thingtoShout + "!!!!") ;

    }
}
