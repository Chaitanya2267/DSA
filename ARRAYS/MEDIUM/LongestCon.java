import java.util.*;

public class LongestCon {

    private boolean linearSearch(int[] a, int num) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            if (a[i] == num)
                return true;
        }
        return false;
    }

    public int brute(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int longest = 1;
        for (int i = 0; i < n; i++) {
            int x = nums[i];
            int cnt = 1;
            while (linearSearch(nums, x + 1) == true) {
                x += 1;
                cnt += 1;
            }
            longest = Math.max(longest, cnt);
        }
        return longest;
    }

    public int better(int[] nums) {
        int n = nums.length;
        if (n == 0)
            return 0;
        Arrays.sort(nums);
        int lastSmaller = Integer.MIN_VALUE;
        int cnt = 0;
        int longest = 1;
        for (int i = 0; i < n; i++) {
            if (nums[i] - 1 == lastSmaller) {
                cnt += 1;
                lastSmaller = nums[i];
            } else if (nums[i] != lastSmaller) {
                cnt = 1;
                lastSmaller = nums[i];
            }
            longest = Math.max(longest, cnt);
        }
        return longest;
    }

    public int opt(int[] nums) {
        int n = nums.length;
        if (n == 0)
            return 0;
        int longest = 1;
        Set<Integer> st = new HashSet<>();
        for (int i = 0; i < n; i++) {
            st.add(nums[i]);
        }
        for (int it : st) {
            if (!st.contains(it - 1)) {
                int cnt = 1;
                int x = it;
                while (st.contains(x + 1)) {
                    x += 1;
                    cnt += 1;
                }
                longest = Math.max(longest, cnt);
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        int[] a = { 100, 4, 200, 1, 3, 2 };

        LongestCon sol = new LongestCon();

        int bruteAns = sol.brute(a);
        System.out.println("Brute Force: " + bruteAns);

        int betterAns = sol.better(a.clone()); // clone because Arrays.sort() modifies the array
        System.out.println("Better: " + betterAns);

        int optAns = sol.opt(a);
        System.out.println("Optimal: " + optAns);
    }
}
