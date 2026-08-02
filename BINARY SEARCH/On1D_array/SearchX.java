public class SearchX {
    public static int iterative(int[] nums, int target) {
        int n = nums.length;
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target)
                return mid;
            else if (target > nums[mid]) {
                low = mid + 1;
            } else
                high = mid - 1;
        }
        return -1;
    }

    public static int recursive(int[] nums, int low, int high, int target) {
        if (low < high) return -1;
        int mid = (low + high) / 2;
        if(nums[mid] == target) return mid;
        else if(target > nums[mid]) return recursive(nums, mid +1, high, target);
        return recursive(nums, low, mid - 1, target);
    }
    public static int search(int[] nums, int target){
        return recursive(nums, 0, nums.length - 1, target);
    }

    public static void main(String[] args) {
        int[] a = { 3, 4, 6, 7, 9, 12, 16, 17 };
        int target1 = 6;
        int ind1 = iterative(a, target1);

        int[] b = { 3, 4, 6, 7, 9, 12, 16, 17 };
        int target2 = 6;
        int ind2 = search(b, target2);

        if (ind1 == -1)
            System.out.println("The target is not present.");
        else
            System.out.println("The target is at index: " + ind1);

        if (ind2 == -1)
            System.out.println("The target is not present.");
        else
            System.out.println("The target is at index: " + ind2);
    }
}