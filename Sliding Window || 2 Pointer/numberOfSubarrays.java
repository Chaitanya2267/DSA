// 1248. Count Number of Nice Subarrays

class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return countAtMost(nums, k) - countAtMost(nums, k - 1);
    }
    private int countAtMost(int[] nums, int limit) {
        if(limit < 0) { return  0; }
        int left = 0; int oddCnt = 0; int cnt = 0;
        for(int right = 0; right < nums.length; right++) {
            if(nums[right] % 2 != 0) { oddCnt++; }
            while(oddCnt > limit) {
                if(nums[left] % 2 != 0) { oddCnt--; }
                left++;
            }
            cnt += right - left + 1;
        }
        return cnt;
    }
}
