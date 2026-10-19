// 2089. Find Target Indices After Sorting Array

class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        List<Integer> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == target) {
                res.add(i);
            }
        }
        return res;
    }
}

class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        List<Integer> res = new ArrayList<>();
        Arrays.sort(nums);
        int first = findfirst(nums, target);
        if(first == -1) { return res; }
        int last = findlast(nums, target);
        for(int i = first ; i <= last; i++) { res.add(i); }
        return res;
    }
    private int findfirst(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int first = -1;
        while(left <= right) {
            int mid =  (left + right) / 2;
            if(nums[mid] == target) {
                first = mid;
                right = mid - 1;
            } else if(nums[mid] < target) {
                left = mid + 1;
            } else { right = mid - 1; }
        }
        return first;
    }
    private int findlast(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int last = -1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(nums[mid] == target) {
                last = mid;
                left = mid + 1;
            } else if(nums[mid] < target) {
                left = mid + 1;
            } else { right = mid - 1; }
        }
        return last;
    }
}
