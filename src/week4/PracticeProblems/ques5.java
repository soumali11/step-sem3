import java.util.Arrays;
import java.util.Scanner;

public class ques5 {

    static int[] rotateArray(int[] nums, int k) {
        if (nums.length == 0) {
            return nums;
        }

        k = k % nums.length;

        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int newPosition = (i + k) % nums.length;
            result[newPosition] = nums[i];
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.print("Enter rotation count: ");
        int k = sc.nextInt();

        if (k < 0) {
            System.out.println("Rotation count cannot be negative.");
            sc.close();
            return;
        }

        int[] result = rotateArray(nums, k);

        System.out.println(Arrays.toString(result));

        sc.close();
    }
}
