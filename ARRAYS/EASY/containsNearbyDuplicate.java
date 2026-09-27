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
// -------------------------------------------------------------

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) { return true; }
            set.add(nums[i]);
            if (i >= k) { set.remove(nums[i - k]); }
        }
        return false;
    }
}
