// 992. Subarrays with K Different Integers

class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        if(k <= 0) { return 0; }
        return countAtmost(nums, k) - countAtmost(nums, k - 1);
    }
    private int countAtmost(int[] nums, int limit) {
        if(limit <= 0) { return 0; }
        Map<Integer, Integer> freq = new HashMap<>();
        int left = 0; int cnt = 0;
        for(int right = 0; right < nums.length; right++) {
            int val = nums[right];
            freq.put(val, freq.getOrDefault(val, 0) + 1);
            while(freq.size() > limit) {
                int leftval = nums[left];
                freq.put(leftval, freq.get(leftval) - 1);
                if(freq.get(leftval) == 0) { freq.remove(leftval); }
                left++;
            }
            cnt += right - left + 1;
        }
        return cnt;
    }
}
