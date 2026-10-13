import java.time.LocalDate;
import java.util.Scanner;

public class ques2 {

    static abstract class LibraryItem {
        String title;

        LibraryItem(String title) {
            this.title = title;
        }

        abstract int getLoanPeriod();

        LocalDate getDueDate() {
            LocalDate currentDate = LocalDate.of(2023, 10, 26);
            return currentDate.plusDays(getLoanPeriod());
        }
    }

    static class Book extends LibraryItem {

        Book(String title) {
            super(title);
        }

        int getLoanPeriod() {
            return 14;
        }
    }

    static class DVD extends LibraryItem {

        DVD(String title) {
            super(title);
        }

        int getLoanPeriod() {
            return 7;
        }
    }

    static class Magazine extends LibraryItem {

        Magazine(String title) {
            super(title);
        }

        int getLoanPeriod() {
            return 3;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        LibraryItem[] items = new LibraryItem[n];

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();

            int space = line.indexOf(' ');
            String type = line.substring(0, space);
            String title = line.substring(space + 1).trim();

            if (title.startsWith("\"") && title.endsWith("\"")) {
                title = title.substring(1, title.length() - 1);
            }

            if (type.equalsIgnoreCase("BOOK")) {
                items[i] = new Book(title);
            } else if (type.equalsIgnoreCase("DVD")) {
                items[i] = new DVD(title);
            } else {
                items[i] = new Magazine(title);
            }
        }

        for (LibraryItem item : items) {
            System.out.println(item.title + ": " + item.getDueDate());
        }

        sc.close();
    }
}
