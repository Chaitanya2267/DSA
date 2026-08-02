import java.util.*;

public class TwoSum {

    public static void bruteSum(int[] arr, int target, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] + arr[j] == target) {
                    System.out.println("Indices: " + i + ", " + j);
                    return; // return true
                }
            }
        } // return false
    }

    public static void betterSum(int[] arr, int target, int n) {
        Map<Integer, Integer> mpp = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int more = target - arr[i];

            if (mpp.containsKey(more)) {
                System.out.println("Indices: " + mpp.get(more) + ", " + i);
                return;
            }
            mpp.put(arr[i], i);
        }
        System.out.println("No pair found");
    }

    public static String optSum(int[] arr, int target, int n) {
        int left = 0, right = n - 1;

        Arrays.sort(arr);

        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == target)
                return "Yes"; 
            else if (sum < target)
                left++;
            else
                right--;
        }
        return "No";
    }

    public static void main(String[] args) {
        int[] arr = { 2, 7, 11, 15 };
        int target = 9;
        int n = arr.length;

        System.out.println("Brute Force:");
        bruteSum(arr, target, n);

        System.out.println("\nBetter (HashMap):");
        betterSum(arr, target, n);

        System.out.println("\nOptimal (Two Pointers):");
        // Pass a copy because optSum() sorts the array
        System.out.println(optSum(Arrays.copyOf(arr, n), target, n));
    }
}
