// 1695. Maximum Erasure Value

class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int res = 0;
        int left = 0;
        int sum = 0;
        Set<Integer> set = new HashSet<>();
        for (int right = 0; right < nums.length; right++) {
            while (set.contains(nums[right])) {
                set.remove(nums[left]);
                sum -= nums[left];
                left++;
            }
            sum += nums[right];
            set.add(nums[right]);
            res = Math.max(res, sum);
        }
        return res;
    }
}
