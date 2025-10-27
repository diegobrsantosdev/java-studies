package Application38;

import Application30.entities.Employee;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Program {
    public static void main(String[] args){
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter full file path: ");
        String path = sc.nextLine();
        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            List<Emplooye> list = new ArrayList<>();

            String line = br.readLine();
            while (line != null){
                String[] fields = line.split(",");
                list.add(new Emplooye(fields[0],fields[1],Double.parseDouble(fields[2])));
                line = br.readLine();
            }



            System.out.print("Enter salary: ");
            double salary = sc.nextDouble();
            System.out.println("Email of people whose salary is more than: " + salary);
            List<String> emails = list.stream() // cria stream
                    .filter(e -> e.getSalary() > salary)  // filtra salários maiores
                    .map(Emplooye::getEmail)  // pega emails
                    .collect(Collectors.toList()); // cria lista
            emails.forEach(System.out::println);  // imprime emails

            System.out.println("Sum of salary of people whose name starts with 'M': ");
            double sum = list.stream()
                    .filter(e -> e.getName().charAt(0) == 'M') // filtra nomes com 'M'
                    .mapToDouble(Emplooye::getSalary)          // pega apenas salários
                    .sum();                                     // soma tudo

            System.out.println(sum);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        sc.close();
    }
}
