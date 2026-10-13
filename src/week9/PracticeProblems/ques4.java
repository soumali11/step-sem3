import java.util.Scanner;

abstract class Connection {
    double units;

    Connection(double units) {
        this.units = units;
    }

    abstract double getBill();
}

class Home extends Connection {
    Home(double units) {
        super(units);
    }

    double getBill() {
        if (units <= 100) {
            return units * 5;
        }

        return 500 + (units - 100) * 7;
    }
}

class Shop extends Connection {
    Shop(double units) {
        super(units);
    }

    double getBill() {
        return units * 8 + 100;
    }
}

class Factory extends Connection {
    Factory(double units) {
        super(units);
    }

    double getBill() {
        return Math.max(units * 6, 1000);
    }
}

public class ques4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double units = sc.nextDouble();
            Connection connection;

            if (type.equals("HOME")) {
                connection = new Home(units);
            } else if (type.equals("SHOP")) {
                connection = new Shop(units);
            } else {
                connection = new Factory(units);
            }

            double bill = connection.getBill();
            System.out.printf("%s: %.2f%n", type, bill);
            total += bill;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}