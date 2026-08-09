class findMin {
    public int brute(int[] nums) {
        int n = nums.length;
        int minVal = Integer.MAX_VALUE;
        for(int i = 0 ; i < n ; i++) {
            minVal = Math.min(nums[i], minVal);
        }
        return minVal;
    }
    public int opt1(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int ans = nums[0];
        
        while(low <= high) {
            int mid = low + (high - low) / 2;
            
            if(nums[low] <= nums[high]) {
                ans = Math.min(ans, nums[low]);
                break;
            }
            
            if(nums[low] <= nums[mid]) {
                ans = Math.min(ans, nums[low]);
                low = mid + 1;
            } else {
                ans = Math.min(ans, nums[mid]);
                high = mid - 1; 
            }
        }
        return ans;
    }
    public int opt2(int[] nums) {
        int low = 0 ; int high = nums.length - 1;
        while(low < high) {
            int mid = low + (high - low)/2;
            if(nums[mid] > nums[high]) {
                low = mid + 1;
            } else { high = mid; }
        }
        return nums[low];
    }
}
