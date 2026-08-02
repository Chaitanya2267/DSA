import java.util.*;

public class CountInversion {
    public static int brute(int[] arr) {
        int cnt = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > arr[j])
                    cnt++;
            }
        }
        return cnt;
    }

    public int merge(int[] arr, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int left = low;
        int right = mid + 1;
        int k = 0;
        int cnt = 0;
        // int n = arr.length;
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp[k++] = arr[left++];
            } else {
                temp[k++] = arr[right++];
                cnt += (mid - left + 1);
            }
        }
        while (left <= mid) {
            temp[k++] = arr[left++];
        }
        while (right <= high) {
            temp[k++] = arr[right++];
        }
        for (int i = low; i <= high; i++) {
            arr[i] = temp[i - low];
        }
        return cnt;
    }

    public int mergeSort(int[] arr, int low, int high) {
        int cnt = 0;
        if (low >= high)
            return cnt;
        int mid = (low + high) / 2;
        cnt += mergeSort(arr, low, mid);
        cnt += mergeSort(arr, mid + 1, high);
        cnt += merge(arr, low, mid, high);
        return cnt;
    }

    public int opt(int[] arr) {
        int n = arr.length;
        return mergeSort(arr, 0, n-1);
    }

    public static void main(String[] args) {
        int[] arr = { 5, 3, 2, 4, 1 };

        // Create copies because merge sort modifies the array
        int[] bruteArr = Arrays.copyOf(arr, arr.length);
        int[] optArr = Arrays.copyOf(arr, arr.length);

        // Brute Force
        int bruteAns = CountInversion.brute(bruteArr);
        System.out.println("Brute Force Inversions: " + bruteAns);

        // Optimized
        CountInversion obj = new CountInversion();
        int optAns = obj.opt(optArr);
        System.out.println("Optimized Inversions: " + optAns);

        // Sorted array after merge sort
        System.out.println("Sorted Array: " + Arrays.toString(optArr));
    }
}
