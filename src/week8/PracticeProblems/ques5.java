import java.util.Scanner;

public class ques5 {

    static abstract class Transport {
        double distance;

        Transport(double distance) {
            this.distance = distance;
        }

        abstract double calculateFare();

        abstract String getType();
    }

    static class Bus extends Transport {

        Bus(double distance) {
            super(distance);
        }

        double calculateFare() {
            double fare = 2 + 0.10 * distance;
            return Math.min(fare, 10);
        }

        String getType() {
            return "BUS";
        }
    }

    static class Train extends Transport {

        Train(double distance) {
            super(distance);
        }

        double calculateFare() {
            return 3 + 0.15 * distance;
        }

        String getType() {
            return "TRAIN";
        }
    }

    static class Metro extends Transport {
        double peakHourFactor;

        Metro(double distance, double peakHourFactor) {
            super(distance);
            this.peakHourFactor = peakHourFactor;
        }

        double calculateFare() {
            return (1.50 + 0.20 * distance) * peakHourFactor;
        }

        String getType() {
            return "METRO";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Transport[] journeys = new Transport[n];

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            double distance = sc.nextDouble();

            if (type.equals("BUS")) {
                journeys[i] = new Bus(distance);
            } else if (type.equals("TRAIN")) {
                journeys[i] = new Train(distance);
            } else {
                double factor = sc.nextDouble();
                journeys[i] = new Metro(distance, factor);
            }
        }

        double total = 0;

        for (Transport journey : journeys) {
            double fare = journey.calculateFare();

            System.out.printf("%s: %.2f%n", journey.getType(), fare);

            total += fare;
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}
