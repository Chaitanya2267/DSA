import java.util.Arrays;

public class LE {
    // Brute force approach: sort the array
    public static int largestElement_bru(int[] arr, int n) {
        // Sort the array in ascending order
        Arrays.sort(arr);
        // The largest element will be at the last index
        return arr[n - 1];
    }

    // Optimal approach: linear scan
    public static int largestElement_opt(int[] arr, int n) {
        int largest = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] > largest) {
                largest = arr[i];
            }
        }
        return largest;
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 7, 2, 8};
        int n = arr.length;

        // Brute force
        int resultBru = largestElement_bru(arr, n);
        System.out.println("Largest element (Brute Force): " + resultBru);

        // Optimal
        int resultOpt = largestElement_opt(arr, n);
        System.out.println("Largest element (Optimal): " + resultOpt);
    }
}
