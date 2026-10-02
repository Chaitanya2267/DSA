// 1464. Maximum Product of Two Elements in an Array

class Solution {
    public int maxProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        return (nums[n - 1] - 1) * (nums[n - 2] - 1);
    }
}
// -------------------------------------------------

class Solution {
    public int maxProduct(int[] nums) {
        int largest = -1;
        int Slargest = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > largest) {
                Slargest = largest;
                largest = nums[i];
            } else if (nums[i] > Slargest) {
                Slargest = nums[i];
            }
        }
        return (largest - 1) * (Slargest - 1);
    }
}
