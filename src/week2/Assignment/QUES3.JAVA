import java.util.Scanner;

public class QUES3 {

    static void parseInventoryRecord(String csvLine) {
        String[] fields = csvLine.split(",", -1);

        if (fields.length != 3) {
            System.out.println("Invalid Record");
            return;
        }

        System.out.println(
            "Product: " + fields[0] +
            " | SKU: " + fields[1] +
            " | Qty: " + fields[2]
        );
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String csvLine = sc.nextLine();

        parseInventoryRecord(csvLine);

        sc.close();
    }
}