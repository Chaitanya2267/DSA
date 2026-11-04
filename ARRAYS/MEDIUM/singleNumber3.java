// 260. Single Number III

class Solution {
    public int[] singleNumber3(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int[] res = new int[2];
        int idx = 0;
        for(int key : map.keySet()) {
            if(map.get(key) == 1) {
                res[idx++] = key;
            }
        }
        return res;
    }
}

class Solution {
    public int[] singleNumber3(int[] nums) {
        int[] res = new int[2];
        int index = 0;
        for(int i = 0 ; i < nums.length; i++) {
            int cnt = 0;
            for(int j = 0; j < nums.length; j++) {
                if(nums[i] == nums[j]) { cnt++; }
            }
            if(cnt == 1) { res[index++] = nums[i]; }
        }
        return res;
    }
}
