import java.util.Scanner;

abstract class Employee {
    protected String name;
    protected double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public abstract double getBonus();

    public String getName() {
        return name;
    }
}

class FullTime extends Employee {
    public FullTime(String name, double salary) {
        super(name, salary);
    }

    public double getBonus() {
        return salary * 0.10;
    }
}

class PartTime extends Employee {
    public PartTime(String name, double salary) {
        super(name, salary);
    }

    public double getBonus() {
        return salary * 0.05;
    }
}

class Intern extends Employee {
    public Intern(String name, double salary) {
        super(name, salary);
    }

    public double getBonus() {
        return 2000.0;
    }
}

public class QUES4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            double salary = sc.nextDouble();

            Employee employee;

            if (type.equals("FULLTIME")) {
                employee = new FullTime(name, salary);
            } else if (type.equals("PARTTIME")) {
                employee = new PartTime(name, salary);
            } else {
                employee = new Intern(name, salary);
            }

            double bonus = employee.getBonus();

            System.out.printf("%s: %.2f%n", employee.getName(), bonus);
            total += bonus;
        }

        System.out.printf("Total Bonus: %.2f%n", total);

        sc.close();
    }
}
