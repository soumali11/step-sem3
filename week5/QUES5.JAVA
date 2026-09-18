import java.util.Arrays;
import java.util.Scanner;

class Player implements Comparable<Player> {

    private String name;
    private int matchesPlayed;
    private double battingAverage;
    private boolean injured;

    public Player(String name, int matchesPlayed, double battingAverage, boolean injured) {
        this.name = name;
        this.matchesPlayed = matchesPlayed;
        this.battingAverage = battingAverage;
        this.injured = injured;
    }

    static boolean isDraftable(int matchesPlayed) {
        return matchesPlayed >= 10;
    }

    static boolean isDraftable(int matchesPlayed, boolean injured) {
        return matchesPlayed >= 5 && !injured;
    }

    public int compareTo(Player other) {
        return Double.compare(other.battingAverage, this.battingAverage);
    }

    public String getName() {
        return name;
    }

    public static String draftAndRank(Player[] players) {
        int count = 0;

        for (int i = 0; i < players.length; i++) {
            if (isDraftable(players[i].matchesPlayed) ||
                isDraftable(players[i].matchesPlayed, players[i].injured)) {
                count++;
            }
        }

        Player[] draftable = new Player[count];

        int index = 0;

        for (int i = 0; i < players.length; i++) {
            if (isDraftable(players[i].matchesPlayed) ||
                isDraftable(players[i].matchesPlayed, players[i].injured)) {
                draftable[index] = players[i];
                index++;
            }
        }

        Arrays.sort(draftable);

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < draftable.length; i++) {
            if (i > 0) {
                result.append(" | ");
            }

            result.append(i + 1)
                  .append(". ")
                  .append(draftable[i].getName());
        }

        return result.toString();
    }
}

public class QUES5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        Player[] players = new Player[n];

        for (int i = 0; i < n; i++) {
            String name = sc.nextLine();
            int matchesPlayed = sc.nextInt();
            double battingAverage = sc.nextDouble();
            boolean injured = sc.nextBoolean();
            sc.nextLine();

            players[i] = new Player(
                name,
                matchesPlayed,
                battingAverage,
                injured
            );
        }

        System.out.println(Player.draftAndRank(players));

        sc.close();
    }
}