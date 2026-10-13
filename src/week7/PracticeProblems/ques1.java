public class ques1 {

    static class PiggyBank {
        private double savings;
        private final String bankId;

        public PiggyBank(String bankId) {
            this.bankId = bankId;
            savings = 0;
        }

        public void deposit(double amount) {
            if (amount <= 0) {
                System.out.println("Invalid deposit amount");
            } else {
                savings += amount;
            }
        }

        public void withdraw(double amount) {
            if (amount <= 0) {
                System.out.println("Invalid withdrawal amount");
            } else if (amount > savings) {
                System.out.println("Withdrawal rejected: insufficient savings");
            } else {
                savings -= amount;
            }
        }

        public double getSavings() {
            return savings;
        }

        public String getBankId() {
            return bankId;
        }
    }

    public static void main(String[] args) {
        PiggyBank pb = new PiggyBank("PB-1");

        pb.deposit(100);
        System.out.println("Savings after deposit: " + pb.getSavings());

        pb.withdraw(30);
        System.out.println("Savings after withdrawal: " + pb.getSavings());

        pb.withdraw(500);
        System.out.println("Final savings: " + pb.getSavings());
    }
}
