import java.util.*;

public class Merge2SortedArrays {
    public static void brute(long[] arr1, long[] arr2, int n, int m) {
        long[] arr3 = new long[n + m];
        int left = 0, right = 0, index = 0;
        while (left < n && right < m) {
            if (arr1[left] <= arr2[right]) {
                arr3[index] = arr1[left];
                left++;
                index++;
            } else {
                arr3[index] = arr2[right];
                right++;
                index++;
            }
        }
        while (left < n) {
            arr3[index++] = arr1[left++];
        }
        while (right < m) {
            arr3[index++] = arr1[right++];
        }
        for (int i = 0; i < n + m; i++) {
            if (i < n) {
                arr1[i] = arr3[i];
            } else
                arr2[i - n] = arr3[i];
        }
    }

    public static void better(long[] arr1, long[] arr2, int n, int m) {
        int left = n - 1, right = 0;
        while (left >= 0 && right < m) {
            if (arr1[left] > arr2[right]) {
                long temp = arr1[left];
                arr1[left] = arr2[right];
                arr2[right] = temp;
                left--;
                right++;
            } else {
                break;
            }
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
    }

    private static void swap(long[] arr1, long[] arr2, int ind1, int ind2) {
        if (arr1[ind1] > arr2[ind2]) {
            long temp = arr1[ind1];
            arr1[ind1] = arr2[ind2];
            arr2[ind2] = temp;
        }
    }

    public static void opt(long[] arr1, long[] arr2, int n, int m) {
        int len = n + m;
        int gap = (len / 2) + (len % 2);
        while (gap > 0) {
            int left = 0;
            int right = left + gap;
            while (right < len) {
                if (left < n && right >= n) {
                    swap(arr1, arr2, left, right - n);
                } else if (left >= n) {
                    swap(arr2, arr2, left - n, right - n);
                } else {
                    swap(arr1, arr1, left, right);
                }
                left++;
                right++;
            }
            if (gap == 1)
                break;
            gap = (gap / 2) + (gap % 2);
        }
    }

    public static void main(String[] args) {

        // Brute Force
        long[] arr1Brute = { 1, 4, 8, 10 };
        long[] arr2Brute = { 2, 3, 9 };

        brute(arr1Brute, arr2Brute, arr1Brute.length, arr2Brute.length);

        System.out.println("Brute Force:");
        System.out.println(Arrays.toString(arr1Brute));
        System.out.println(Arrays.toString(arr2Brute));
        System.out.println();

        // Better Approach
        long[] arr1Better = { 1, 4, 8, 10 };
        long[] arr2Better = { 2, 3, 9 };

        better(arr1Better, arr2Better, arr1Better.length, arr2Better.length);

        System.out.println("Better Approach:");
        System.out.println(Arrays.toString(arr1Better));
        System.out.println(Arrays.toString(arr2Better));
        System.out.println();

        // Optimal Approach (Gap Method)
        long[] arr1Opt = { 1, 4, 8, 10 };
        long[] arr2Opt = { 2, 3, 9 };

        opt(arr1Opt, arr2Opt, arr1Opt.length, arr2Opt.length);

        System.out.println("Optimal Approach:");
        System.out.println(Arrays.toString(arr1Opt));
        System.out.println(Arrays.toString(arr2Opt));
    }
}
