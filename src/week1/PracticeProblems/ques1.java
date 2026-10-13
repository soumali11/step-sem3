import java.util.Random;
import java.util.Scanner;

public class ques1 {

    static String playRound(String playerMove, String computerMove) {
        if (playerMove.equals(computerMove)) {
            return "Draw";
        }

        if ((playerMove.equals("Rock") && computerMove.equals("Scissors")) ||
            (playerMove.equals("Paper") && computerMove.equals("Rock")) ||
            (playerMove.equals("Scissors") && computerMove.equals("Paper"))) {
            return "Player Wins";
        }

        return "Computer Wins";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        String[] moves = {"Rock", "Paper", "Scissors"};

        System.out.print("Enter number of rounds: ");
        int n = sc.nextInt();
        sc.nextLine();

        if (n <= 0) {
            System.out.println("Number of rounds must be positive.");
            sc.close();
            return;
        }

        String[] playerMoves = new String[n];
        String[] computerMoves = new String[n];
        String[] results = new String[n];

        int wins = 0;
        int losses = 0;
        int draws = 0;

        for (int i = 0; i < n; i++) {
            System.out.print("Enter your move for round " + (i + 1) + ": ");
            String playerMove = sc.nextLine().trim();

            if (playerMove.equalsIgnoreCase("rock")) {
                playerMove = "Rock";
            } else if (playerMove.equalsIgnoreCase("paper")) {
                playerMove = "Paper";
            } else if (playerMove.equalsIgnoreCase("scissors")) {
                playerMove = "Scissors";
            } else {
                System.out.println("Invalid move. Try again.");
                i--;
                continue;
            }

            String computerMove = moves[random.nextInt(3)];
            String result = playRound(playerMove, computerMove);

            playerMoves[i] = playerMove;
            computerMoves[i] = computerMove;
            results[i] = result;

            if (result.equals("Player Wins")) {
                wins++;
            } else if (result.equals("Computer Wins")) {
                losses++;
            } else {
                draws++;
            }
        }

        System.out.println("\nRound\tPlayer Move\tComputer Move\tResult");

        for (int i = 0; i < n; i++) {
            System.out.println((i + 1) + "\t" + playerMoves[i] + "\t\t" +
                               computerMoves[i] + "\t\t" + results[i]);
        }

        double winPercentage = (double) wins / n * 100;

        System.out.println("\nWins: " + wins);
        System.out.println("Losses: " + losses);
        System.out.println("Draws: " + draws);
        System.out.printf("Win %% = %.1f%%%n", winPercentage);

        sc.close();
    }
}
