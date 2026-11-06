// 90. Subsets II

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        Set<List<Integer>> seen = new HashSet<>();
        int subsets = 1 << nums.length;
        for (int mask = 0; mask < subsets; mask++) {
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                if ((mask & (1 << i)) != 0) { temp.add(nums[i]); }
            }
            if (seen.add(temp)) { ans.add(temp); }
        }
        return ans;
    }
}
