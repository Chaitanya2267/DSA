public class SingleNonDuplicate {

    public int brute(int[] nums) {
        int n = nums.length;

        if (n == 1) return nums[0];

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                if (nums[i] != nums[i + 1])
                    return nums[i];
            } else if (i == n - 1) {
                if (nums[i] != nums[i - 1])
                    return nums[i];
            } else {
                if (nums[i] != nums[i - 1] && nums[i] != nums[i + 1])
                    return nums[i];
            }
        }

        return -1;
    }

    public int opt(int[] nums) {
        int n = nums.length;

        if (n == 1) return nums[0];
        if (nums[0] != nums[1]) return nums[0];
        if (nums[n - 1] != nums[n - 2]) return nums[n - 1];

        int low = 1;
        int high = n - 2;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (nums[mid] != nums[mid + 1] &&
                nums[mid] != nums[mid - 1]) {
                return nums[mid];
            }

            if ((mid % 2 == 1 && nums[mid - 1] == nums[mid]) ||
                (mid % 2 == 0 && nums[mid] == nums[mid + 1])) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        int[] nums = {1, 1, 2, 2, 3, 3, 4, 5, 5};

        SingleNonDuplicate obj = new SingleNonDuplicate();

        int bruteResult = obj.brute(nums);
        int optResult = obj.opt(nums);

        System.out.println("Brute Force Result: " + bruteResult);
        System.out.println("Optimized Result: " + optResult);
    }
}
