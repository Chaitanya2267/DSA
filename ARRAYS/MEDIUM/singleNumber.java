// 260. Single Number III

class Solution {
    public int[] singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int[] res = new int[2];
        int idx = 0;
        for (int key : map.keySet()) {
            if (map.get(key) == 1) {
                res[idx++] = key;
            }
        }
        return res;
    }
}
