package Application33;

import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        PrintService<Integer> ps = new PrintService<>();

        System.out.println("Hpw many values? ");
        int n = sc.nextInt();

        for(int i=0;i<n;i++){
            int value = sc.nextInt();
            ps.addValue(Integer.valueOf(value));
        }

        ps.print();
        Integer x = ps.first();
        System.out.println("First: " + ps.first());

        sc.close();
    }
}
