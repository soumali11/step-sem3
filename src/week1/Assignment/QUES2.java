import java.util.Scanner;

public class QUES2 {

    static void checkTypingAccuracy(String original, String typed) {
        if (original.length() != typed.length()) {
            System.out.println("Strings must be of equal length");
            return;
        }

        int matched = 0;
        int firstMismatch = -1;

        for (int i = 0; i < original.length(); i++) {
            if (original.charAt(i) == typed.charAt(i)) {
                matched++;
            } else if (firstMismatch == -1) {
                firstMismatch = i;
            }
        }

        double accuracy = ((double) matched / original.length()) * 100;

        if (firstMismatch == -1) {
            System.out.printf(
                "Matched: %d/%d | Accuracy: %.2f%% | No Mismatches%n",
                matched,
                original.length(),
                accuracy
            );
        } else {
            System.out.printf(
                "Matched: %d/%d | Accuracy: %.2f%% | First Mismatch at position %d ('%c' vs '%c')%n",
                matched,
                original.length(),
                accuracy,
                firstMismatch + 1,
                original.charAt(firstMismatch),
                typed.charAt(firstMismatch)
            );
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String original = sc.nextLine();
        String typed = sc.nextLine();

        checkTypingAccuracy(original, typed);

        sc.close();
    }
}