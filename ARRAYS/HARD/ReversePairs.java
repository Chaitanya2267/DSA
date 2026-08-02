import java.util.ArrayList;
import java.util.Arrays;

public class ReversePairs {

    // Brute Force Approach
    public static int brute(int[] arr, int n) {
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > 2L * arr[j]) { // Use long to avoid overflow
                    cnt++;
                }
            }
        }

        return cnt;
    }

    public static int team1(int[] skill, int n) {
        return brute(skill, n);
    }

    // Merge Function
    private static void merge(int[] arr, int low, int mid, int high) {

        ArrayList<Integer> temp = new ArrayList<>();

        int left = low;
        int right = mid + 1;

        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                right++;
            }
        }

        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }

        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }

        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }
    }

    // Count Reverse Pairs
    private static int countPairs(int[] arr, int low, int mid, int high) {

        int right = mid + 1;
        int cnt = 0;

        for (int i = low; i <= mid; i++) {
            while (right <= high && arr[i] > 2L * arr[right]) {
                right++;
            }
            cnt += (right - (mid + 1));
        }

        return cnt;
    }

    // Merge Sort
    private static int mergeSort(int[] arr, int low, int high) {

        if (low >= high)
            return 0;

        int mid = low + (high - low) / 2;

        int cnt = 0;

        cnt += mergeSort(arr, low, mid);
        cnt += mergeSort(arr, mid + 1, high);
        cnt += countPairs(arr, low, mid, high);

        merge(arr, low, mid, high);

        return cnt;
    }

    public static int team2(int[] skill, int n) {
        return mergeSort(skill, 0, n - 1);
    }

    public static void main(String[] args) {

        int[] arr = {1, 3, 2, 3, 1};

        int[] bruteArr = Arrays.copyOf(arr, arr.length);
        int[] optArr = Arrays.copyOf(arr, arr.length);

        int bruteAns = team1(bruteArr, bruteArr.length);
        int optAns = team2(optArr, optArr.length);

        System.out.println("Original Array: " + Arrays.toString(arr));
        System.out.println("Brute Force Reverse Pairs: " + bruteAns);
        System.out.println("Optimized Reverse Pairs: " + optAns);
        System.out.println("Sorted Array: " + Arrays.toString(optArr));
    }
}
