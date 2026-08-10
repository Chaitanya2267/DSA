class First_LastPos {
    public int[] ULB(int[] nums, int target) {
        int first = LowerBound(nums, target);
        if(first == nums.length || nums[first] != target) {
            return new int[]{-1, -1};
        }
        int last = UpperBound(nums, target) - 1;
        return new int[]{first, last};
    }
    public int LowerBound(int[] nums, int target){
        int low = 0; int high = nums.length;
        while(low < high){
            int mid = low + (high - low)/2;
            if(nums[mid] >= target) { high = mid; }
            else{ low = mid + 1; }
        }
        return low;
    }
    public int UpperBound(int[] nums, int target){
        int low = 0; int high = nums.length;
        while(low < high){
            int mid = low + (high - low)/2;
            if(nums[mid] > target) { high = mid; }
            else{ low = mid + 1; }
        }
        return low;
    }
    // ========================================================================
    public int[] BS(int[] nums, int target) {
        int first = FindFirst(nums, target);
        if(first == -1 ){
            return new int[]{-1, -1};
        }
        int last = FindLast(nums, target);
        return new int[]{first, last};
    }
    public int FindFirst(int[] nums, int target){
        int low = 0; int high = nums.length - 1; int first = -1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target){
                first = mid; high = mid - 1;
            } else if(nums[mid] < target){low = mid + 1; }
            else{ high = mid - 1; }
        }
        return first;
    }
    public int FindLast(int[] nums, int target){
        int low = 0; int high = nums.length - 1; int last = -1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target){
                last = mid; low = mid + 1;
            } else if(nums[mid] < target){low = mid + 1; }
            else{ high = mid - 1; }
        }
        return last;
    }
}
