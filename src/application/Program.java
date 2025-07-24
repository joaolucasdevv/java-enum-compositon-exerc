package application;

import entities.Department;
import entities.Worker;
import entities.enums.WorkerLevel;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter department's name: ");
        Department department = new Department(sc.nextLine());

        System.out.println("Enter worker data:");
        String name = sc.nextLine();

        System.out.println("Level:");
        WorkerLevel level = WorkerLevel.valueOf(sc.nextLine());

        System.out.println("Base Salary:");
        double baseSalary = sc.nextDouble();

        Worker worker = new Worker(name, level, baseSalary, department);

        System.out.println("How many contracts to this worker?");
        int n = sc.nextInt();
        for (int i=1; i<=n; i++) {
            System.out.println("Enter contract #" + i + " data: " );

            System.out.println("Date (DD/MM/YYYY): ");
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate date = LocalDate.parse(sc.nextLine(), fmt);

            System.out.println("Value per hour: ");
            double valuePerHour = sc.nextDouble();


        }


        sc.close();
    }

}
