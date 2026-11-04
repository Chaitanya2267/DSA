// 136. Single Number

class Solution {
    public int singleNumber1(int[] nums) {
        Map<Integer, Integer> mpp = new HashMap<>();

        for (int num : nums) {
            mpp.put(num, mpp.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : mpp.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        return -1;
    }
}

class Solution {
    public int singleNumber(int[] nums) {
        for(int i = 0 ; i < nums.length ; i++){
            int cnt = 0;
            for(int j = 0 ; j < nums.length ; j++){
                if(nums[i] == nums[j]){cnt++;}
            }
            if(cnt == 1) return nums[i];
        }
        return -1;
    }
}

