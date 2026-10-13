import java.util.Scanner;

public class ques1 {

    static abstract class Payment {
        double amount;

        Payment(double amount) {
            this.amount = amount;
        }

        abstract double calculateAmount();

        abstract String getType();
    }

    static class CardPayment extends Payment {

        CardPayment(double amount) {
            super(amount);
        }

        double calculateAmount() {
            return amount + amount * 0.02;
        }

        String getType() {
            return "CARD";
        }
    }

    static class WalletPayment extends Payment {

        WalletPayment(double amount) {
            super(amount);
        }

        double calculateAmount() {
            return amount + amount * 0.01;
        }

        String getType() {
            return "WALLET";
        }
    }

    static class BankTransfer extends Payment {

        BankTransfer(double amount) {
            super(amount);
        }

        double calculateAmount() {
            return amount;
        }

        String getType() {
            return "BANKTRANSFER";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Payment[] payments = new Payment[n];

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            double amount = sc.nextDouble();

            if (type.equals("CARD")) {
                payments[i] = new CardPayment(amount);
            } else if (type.equals("WALLET")) {
                payments[i] = new WalletPayment(amount);
            } else {
                payments[i] = new BankTransfer(amount);
            }
        }

        double total = 0;

        for (Payment payment : payments) {
            double adjustedAmount = payment.calculateAmount();

            System.out.printf("%s: %.2f%n",
                    payment.getType(), adjustedAmount);

            total += adjustedAmount;
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}
