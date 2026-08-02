public class MaxSubArraySum {
    public static int Brute(int[] arr) {
        int n = arr.length;
        int maxi = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += arr[k];
                }
                maxi = Math.max(sum, maxi);
            }
        }
        return maxi;
    }

    public static int Better(int[] arr) {
        int n = arr.length;
        int maxi = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                maxi = Math.max(sum, maxi);
            }
        }
        return maxi;
    }

    // Kadane's algorithm
    public static int Opt(int[] arr) {
        int n = arr.length;
        long maxi = Long.MIN_VALUE, sum = 0;

        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (sum > maxi)
                maxi = sum;
            if (sum < 0)
                sum = 0;
        }
        return (int) maxi;
    }

    public static void main(String[] args) {
        int[] arr = { -2, -3, 4, -1, -2, 1, 5, -3 };
        
        System.out.println(Brute(arr));
        System.out.println(Better(arr));
        System.out.println(Opt(arr));
    }
}
