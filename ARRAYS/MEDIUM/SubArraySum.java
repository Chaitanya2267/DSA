import java.util.*;

public class SubArraySum {

    public int brute(int[] arr, int k) {
        int n = arr.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sum = 0;
                for (int m = i; m <= j; m++) {
                    sum += arr[m];
                }
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    public int better(int[] arr, int k) {
        int n = arr.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    public int opt(int[] arr, int k) {
        int n = arr.length;
        // Stores <prefixSum, frequency>
        HashMap<Integer, Integer> prefixSumCount = new HashMap<>();
        int prefixSum = 0;
        int count = 0;
        // Empty prefix has sum 0
        prefixSumCount.put(0, 1);
        for (int i = 0; i < n; i++) {
            prefixSum += arr[i];
            // Check if there exists a prefix sum such that
            // currentPrefix - previousPrefix = k
            int remove = prefixSum - k;
            if (prefixSumCount.containsKey(remove)) {
                count += prefixSumCount.get(remove);
            }
            prefixSumCount.put(prefixSum, prefixSumCount.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        SubArraySum sol = new SubArraySum();

        int[] arr = { 3, 1, 2, 4 };
        int k = 6;

        System.out.println("Brute  : " + sol.brute(arr, k));
        System.out.println("Better : " + sol.better(arr, k));
        System.out.println("Optimal: " + sol.opt(arr, k));
    }
}
