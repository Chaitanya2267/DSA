// 219. Contains duplicate ||

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> mpp = new HashMap<>();

        for (int idx = 0; idx < nums.length; idx++) {
            if (mpp.containsKey(nums[idx]) &&
                idx - mpp.get(nums[idx]) <= k) {
                return true;
            }
            mpp.put(nums[idx], idx);
        }
        return false;
    }
}
