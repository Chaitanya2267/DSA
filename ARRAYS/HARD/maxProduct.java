public class maxProduct {
    public int brute(int[] nums) {
        int maxProd = nums[0];
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int prod = 1;
            for (int j = i; j < n; j++) {
                prod *= nums[j];
                maxProd = Math.max(maxProd, prod);
            }
        }
        return maxProd;
    }

    public int opt(int[] arr) {
        int n = arr.length;
        int pre = 1;
        int suf = 1;
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (pre == 0)
                pre = 1;
            if (suf == 0)
                suf = 1;
            pre *= arr[i];
            suf *= arr[n - i - 1];
            ans = Math.max(ans, Math.max(pre, suf));
        }

        return ans;
    }

    public static void main(String[] args) {

        int[] arr = { 2, 3, -2, 4 };

        maxProduct obj = new maxProduct();

        int bruteAns = obj.brute(arr);
        int optAns = obj.opt(arr);

        System.out.println("Array: " + java.util.Arrays.toString(arr));
        System.out.println("Brute Force Maximum Product: " + bruteAns);
        System.out.println("Optimized Maximum Product: " + optAns);
    }
}
