import java.util.Scanner;

public class QUES3 {

    static void findLongestStreak(String signalLog) {
        if (signalLog.isEmpty()) {
            return;
        }

        char longestColor = signalLog.charAt(0);
        int longestStreak = 1;

        char currentColor = signalLog.charAt(0);
        int currentStreak = 1;

        for (int i = 1; i < signalLog.length(); i++) {
            char current = signalLog.charAt(i);

            if (current == currentColor) {
                currentStreak++;
            } else {
                currentColor = current;
                currentStreak = 1;
            }

            if (currentStreak > longestStreak) {
                longestStreak = currentStreak;
                longestColor = currentColor;
            }
        }

        System.out.println(
            "Longest Streak: '" + longestColor +
            "' repeated " + longestStreak + " times"
        );
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String signalLog = sc.nextLine();

        findLongestStreak(signalLog);

        sc.close();
    }
}