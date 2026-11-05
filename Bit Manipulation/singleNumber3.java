// 260. Single Number III

class Solution {
    public int[] singleNumber3(int[] nums) {
        int xorResult = 0;
        for(int i = 0; i < nums.length; i++) {
            xorResult = xorResult ^ nums[i];
        }
        int rightmost = (xorResult & xorResult - 1) ^ xorResult;
        int b1 = 0; int b2 = 0;
        for(int i = 0; i < nums.length; i++) {
            if((nums[i] & rightmost) != 0) { b1 = b1 ^ nums[i]; }
            else { b2 = b2 ^ nums[i]; }
        }
        return new int[]{b1, b2};
    }
}
