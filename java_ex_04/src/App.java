import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class App {
    public static void main(String[] args) throws Exception {
        
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Enter department's name: ");
        String departmentName = sc.nextLine();
        System.out.print("Enter worker data: ");

        System.out.print("\nName: ");
        String name = sc.nextLine();
        System.out.print("Level: ");
        String level = sc.nextLine();
        System.out.print("Base Salary: ");
        Double baseSalary = sc.nextDouble();
        sc.nextLine();

        // public Worker(String name, WorkerLevel level, Double baseSalary, Department department)
        Worker worker = new Worker(name, WorkerLevel.valueOf(level), baseSalary, new Department(departmentName));

        System.out.print("How many contracts to this worker? ");
        int number = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < number; i++){
            System.out.print("Enter contract #" + i + " data: ");
            System.out.print("\nDate (DD/MM/YYYY): ");
            Date date = sdf.parse(sc.next());
            System.out.print("Value per hour: ");
            Double valuePerHour = sc.nextDouble();
            sc.nextLine();
            System.out.print("Duration (hours): ");
            Integer hours = sc.nextInt();
            sc.nextLine();
            // public HourContract(Date date, Double valuePerHour, Integer hours)
            HourContract contract = new HourContract(date, valuePerHour, hours);
            worker.addContract(contract);
        }

        System.out.print("\nEnter month and year to calculate income (MM/YYYY): ");
        String monthAndYear = sc.nextLine();
        int month = Integer.parseInt(monthAndYear.substring(0, 2));
        int year = Integer.parseInt(monthAndYear.substring(3, 7));
        System.out.print("\nName: " + worker.getName());
        System.out.print("\nDepartment: " + worker.getDepartment().getName());
        System.out.print("\nIncome for " + month + "/" + year + ": $" + worker.income(year, month));

        sc.close();
    }
}
