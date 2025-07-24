package application;

import entities.enums.WorkerLevel;

import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter department's name: ");
        String departmentName = sc.nextLine();

        System.out.println("Enter worker data:");
        String name = sc.nextLine();

        System.out.println("Level:");
        WorkerLevel level = WorkerLevel.valueOf(sc.nextLine());

        System.out.println("Base Salary:");
        double baseSalary = sc.nextDouble();









        sc.close();
    }

}
