import java.util.Scanner;

public class ques4 {

    static abstract class Question {
        String questionText;
        String correctAnswer;
        String studentAnswer;
        double points;

        Question(String questionText, String correctAnswer,
                 String studentAnswer, double points) {
            this.questionText = questionText;
            this.correctAnswer = correctAnswer;
            this.studentAnswer = studentAnswer;
            this.points = points;
        }

        abstract double calculateScore();

        abstract String getType();
    }

    static class MCQ extends Question {

        MCQ(String questionText, String correctAnswer,
            String studentAnswer, double points) {
            super(questionText, correctAnswer, studentAnswer, points);
        }

        double calculateScore() {
            return correctAnswer.equals(studentAnswer) ? points : 0;
        }

        String getType() {
            return "MCQ";
        }
    }

    static class TrueFalse extends Question {

        TrueFalse(String questionText, String correctAnswer,
                  String studentAnswer, double points) {
            super(questionText, correctAnswer, studentAnswer, points);
        }

        double calculateScore() {
            return correctAnswer.equals(studentAnswer) ? points : 0;
        }

        String getType() {
            return "TF";
        }
    }

    static class Essay extends Question {

        Essay(String questionText, String correctAnswer,
              String studentAnswer, double points) {
            super(questionText, correctAnswer, studentAnswer, points);
        }

        double calculateScore() {
            String[] keywords = correctAnswer.split(",");
            String answer = studentAnswer.toLowerCase();
            int matched = 0;

            for (String keyword : keywords) {
                String word = keyword.trim().toLowerCase();

                if (!word.isEmpty() && answer.contains(word)) {
                    matched++;
                }
            }

            if (matched >= 2) {
                return points * 0.75;
            } else if (matched == 1) {
                return points * 0.50;
            }

            return 0;
        }

        String getType() {
            return "ESSAY";
        }
    }

    static String[] parseQuotedFields(String line) {
        java.util.ArrayList<String> fields = new java.util.ArrayList<>();
        java.util.regex.Matcher matcher =
                java.util.regex.Pattern.compile("\"([^\"]*)\"|(\\S+)")
                        .matcher(line);

        while (matcher.find()) {
            if (matcher.group(1) != null) {
                fields.add(matcher.group(1));
            } else {
                fields.add(matcher.group(2));
            }
        }

        return fields.toArray(new String[0]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        Question[] questions = new Question[n];

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String[] fields = parseQuotedFields(line);

            String type = fields[0];
            String questionText = fields[1];
            String correctAnswer = fields[2];
            String studentAnswer = fields[3];
            double points = Double.parseDouble(fields[4]);

            if (type.equalsIgnoreCase("MCQ")) {
                questions[i] = new MCQ(questionText, correctAnswer,
                        studentAnswer, points);
            } else if (type.equalsIgnoreCase("TF")) {
                questions[i] = new TrueFalse(questionText, correctAnswer,
                        studentAnswer, points);
            } else {
                questions[i] = new Essay(questionText, correctAnswer,
                        studentAnswer, points);
            }
        }

        double total = 0;

        for (Question question : questions) {
            double score = question.calculateScore();

            System.out.printf("%s: %.2f%n", question.getType(), score);

            total += score;
        }

        System.out.printf("Total Score: %.2f%n", total);

        sc.close();
    }
}
