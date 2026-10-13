import java.util.Scanner;

public class QUES1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int present = 0;
        int currentStreak = 0;
        int longestStreak = 0;

        for (int i = 0; i < n; i++) {
            int day = sc.nextInt();

            if (day == 1) {
                present++;
                currentStreak++;

                if (currentStreak > longestStreak) {
                    longestStreak = currentStreak;
                }
            } else {
                currentStreak = 0;
            }
        }

        System.out.println("Present: " + present +
                ", Longest streak: " + longestStreak);

        sc.close();
    }
}