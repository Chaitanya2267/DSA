class FindPeakElement {
    // Brute force approach: O(n)
    public int brute(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if ((i == 0 || nums[i - 1] < nums[i]) &&
                (i == n - 1 || nums[i] > nums[i + 1])) {
                return i; 
            }
        }
        return -1;
    }

    // Optimized binary search approach: O(log n)
    public int opt(int[] nums) {
        int n = nums.length;
        if (n == 1) return 0;
        if (nums[0] > nums[1]) return 0;
        if (nums[n - 1] > nums[n - 2]) return n - 1;

        int low = 1, high = n - 2;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid; // Peak found
            } else if (nums[mid] > nums[mid - 1]) {
                low = mid + 1; // Move right
            } else {
                high = mid - 1; // Move left
            }
        }
        return -1; // Should never reach here
    }

    // Main method to test both approaches
    public static void main(String[] args) {
        FindPeakElement obj = new FindPeakElement();
        int[] nums = {1, 2, 3, 1};

        System.out.println("Brute Force Peak Index: " + obj.brute(nums));
        System.out.println("Optimized Peak Index: " + obj.opt(nums));
    }
}
