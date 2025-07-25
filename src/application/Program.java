package application;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

import java.time.LocalDate;
import java.time.YearMonth;
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
        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Level: ");
        WorkerLevel level = WorkerLevel.valueOf(sc.nextLine());

        System.out.print("Base Salary:");
        double baseSalary = sc.nextDouble();

        Worker worker = new Worker(name, level, baseSalary, department);

        System.out.print("How many contracts to this worker? ");
        int n = sc.nextInt();
        for (int i=1; i<=n; i++) {
            System.out.println("Enter contract #" + i + " data:" );

            sc.nextLine();
            System.out.print("Date (DD/MM/YYYY): ");
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate date = LocalDate.parse(sc.nextLine(), fmt);

            System.out.print("Value per hour: ");
            double valuePerHour = sc.nextDouble();

            System.out.print("Duration (hour): ");
            int hour = sc.nextInt();

            HourContract contract = new HourContract(date, valuePerHour, hour);

            worker.addContract(contract);

        }

        sc.nextLine();
        System.out.print("Enter month and year to calculate income (MM/YYYY): ");
        DateTimeFormatter inc = DateTimeFormatter.ofPattern("MM/yyyy");
        YearMonth income = YearMonth.parse(sc.nextLine(), inc);

        int month = income.getMonthValue();
        int year = income.getYear();

        System.out.println("Name: " + worker.getName());
        System.out.println("Department: " + worker.getDepartment().getName());
        System.out.printf("Income for %s: %.2f%n", income.format(inc), worker.income(year, month));

        sc.close();
    }

}
