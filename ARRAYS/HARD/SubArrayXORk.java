import java.util.*;

public class SubArrayXORk {
    public int brute(int[] arr, int B) {
        int n = arr.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            int xorVal = 0;
            for (int j = i; j < n; j++) {
                xorVal ^= arr[j];
                if (xorVal == B) {
                    count++;
                }
            }
        }
        return count;
    }

    public int opt(int[] arr, int B) {
        Map<Integer, Integer> freq = new HashMap<>();
        freq.put(0, 1);
        int prefixXor = 0, count = 0;
        for (int num : arr) {
            prefixXor ^= num;
            int target = prefixXor ^ B;
            if (freq.containsKey(target)) {
                count += freq.get(target);
            }
            freq.put(prefixXor, freq.getOrDefault(prefixXor, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        SubArrayXORk obj = new SubArrayXORk();

        int[] arr = { 4, 2, 2, 6, 4 };
        int B = 6;

        System.out.println("Brute Force Count: " + obj.brute(arr, B));
        System.out.println("Optimal Count    : " + obj.opt(arr, B));
    }
}
