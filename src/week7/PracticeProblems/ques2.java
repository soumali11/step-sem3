public class ques2 {

    static class Scorecard {
        private boolean[] results;
        private int answersRecorded;

        public Scorecard(int totalQuestions) {
            results = new boolean[totalQuestions];
            answersRecorded = 0;
        }

        public void recordAnswer(boolean correct) {
            if (answersRecorded < results.length) {
                results[answersRecorded] = correct;
                answersRecorded++;
            } else {
                System.out.println("All answers have already been recorded");
            }
        }

        public int getScore() {
            int score = 0;

            for (int i = 0; i < answersRecorded; i++) {
                if (results[i]) {
                    score++;
                }
            }

            return score;
        }
    }

    public static void main(String[] args) {
        Scorecard sc = new Scorecard(4);

        sc.recordAnswer(true);
        sc.recordAnswer(true);
        sc.recordAnswer(false);
        sc.recordAnswer(true);

        System.out.println("Final score: " + sc.getScore());
    }
}
