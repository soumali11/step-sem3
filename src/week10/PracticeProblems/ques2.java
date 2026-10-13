import java.util.Scanner;

public class ques2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String word = sc.next();
        StringBuilder reversed = new StringBuilder(word);
        reversed.reverse();

        System.out.print(reversed + " - ");

        if (word.equals(reversed.toString())) {
            System.out.println("palindrome");
        } else {
            System.out.println("not a palindrome");
        }

        sc.close();
    }
}
