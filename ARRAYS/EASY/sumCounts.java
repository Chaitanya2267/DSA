// 2913. Subarrays Distinct Element Sum of Squares I

class Solution {
    public int sumCounts(List<Integer> nums) {
        int total = 0;
        for(int i = 0; i < nums.size(); i++) {
            Set<Integer> set = new HashSet<>();
            for(int j = i; j < nums.size(); j++) {
                set.add(nums.get(j));
                int distinct = set.size();
                total += distinct * distinct;
            }
        }
        return total;
    }
}
