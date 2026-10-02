import java.util.Scanner;

public class QUES5 {

    static void classifyWordLengths(String review) {
        if (review.trim().isEmpty()) {
            System.out.println("Short: 0 | Medium: 0 | Long: 0");
            return;
        }

        String[] words = review.trim().split("\\s+");

        int shortWords = 0;
        int mediumWords = 0;
        int longWords = 0;

        for (int i = 0; i < words.length; i++) {
            int length = words[i].length();

            if (length <= 4) {
                shortWords++;
            } else if (length <= 8) {
                mediumWords++;
            } else {
                longWords++;
            }
        }

        System.out.println(
            "Short: " + shortWords +
            " | Medium: " + mediumWords +
            " | Long: " + longWords
        );
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String review = sc.nextLine();

        classifyWordLengths(review);

        sc.close();
    }
}