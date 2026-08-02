import java.util.*;

public class Repeating_MissingNum {

    public int[] brute(int[] arr) {
        int n = arr.length;
        int repeating = -1, missing = -1;

        for (int i = 1; i <= n; i++) {
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (arr[j] == i)
                    cnt++;
            }

            if (cnt == 2)
                repeating = i;
            else if (cnt == 0)
                missing = i;

            if (repeating != -1 && missing != -1)
                break;
        }

        return new int[] { repeating, missing };
    }

    public int[] better(int[] arr) {
        int n = arr.length;
        int[] hash = new int[n + 1];
        for (int i = 0; i < n; i++) {
            hash[arr[i]]++;
        }
        int repeating = -1, missing = -1;
        for (int i = 1; i <= n; i++) {
            if (hash[i] == 2) {
                repeating = i;
            } else if (hash[i] == 0) {
                missing = i;
            }
            if (repeating != -1 && missing != -1) {
                break;
            }
        }
        return new int[] { repeating, missing };
    }

    public int[] opt(int[] arr) {
        long n = arr.length;
        long SN = (n * (n + 1)) / 2;
        long S2N = (n * (n + 1) * (2 * n + 1)) / 6;
        long s = 0, s2 = 0;
        for (int i = 0; i < n; i++) {
            s += arr[i];
            s2 += (long) arr[i] * (long) arr[i];
        }
        long val1 = s - SN;
        long val2 = s2 - S2N;
        val2 = val2 / val1;
        long x = (val1 + val2) / 2;
        long y = x - val1;
        return new int[] { (int) x, (int) y };
    }

    public static void main(String[] args) {
        Repeating_MissingNum obj = new Repeating_MissingNum();

        int[] arr = { 4, 3, 6, 2, 1, 1 };

        System.out.println("Input Array: " + Arrays.toString(arr));

        int[] ans1 = obj.brute(arr);
        System.out.println("Brute Force:");
        System.out.println("Repeating = " + ans1[0] + ", Missing = " + ans1[1]);

        // int[] ans2 = obj.better(arr);
        // System.out.println("Better (Hashing):");
        // System.out.println("Repeating = " + ans2[0] + ", Missing = " + ans2[1]);

        // int[] ans3 = obj.opt(arr);
        // System.out.println("Optimal (Math):");
        // System.out.println("Repeating = " + ans3[0] + ", Missing = " + ans3[1]);
    }
}
