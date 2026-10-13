import java.time.LocalDate;
import java.util.Scanner;

abstract class Plan {
    protected String name;
    protected LocalDate startDate;

    public Plan(String name, LocalDate startDate) {
        this.name = name;
        this.startDate = startDate;
    }

    public abstract LocalDate getRenewalDate();

    public String getName() {
        return name;
    }
}

class BasicPlan extends Plan {
    public BasicPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    public LocalDate getRenewalDate() {
        return startDate.plusDays(30);
    }
}

class StandardPlan extends Plan {
    public StandardPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    public LocalDate getRenewalDate() {
        return startDate.plusDays(90);
    }
}

class PremiumPlan extends Plan {
    public PremiumPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    public LocalDate getRenewalDate() {
        return startDate.plusDays(365);
    }
}

public class QUES5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            LocalDate startDate = LocalDate.parse(sc.next());

            Plan plan;

            if (type.equals("BASIC")) {
                plan = new BasicPlan(name, startDate);
            } else if (type.equals("STANDARD")) {
                plan = new StandardPlan(name, startDate);
            } else {
                plan = new PremiumPlan(name, startDate);
            }

            System.out.println(plan.getName() + ": " + plan.getRenewalDate());
        }

        sc.close();
    }
}