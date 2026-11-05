// 137. Single Number II

class Solution {
    public int singleNumber2(int[] nums) {
        int result = 0;

        for (int i = 0; i < 32; i++) {
            int sum = 0;

            for (int num : nums) {
                if (((num >> i) & 1) == 1) {
                    sum++;
                }
            }

            if (sum % 3 != 0) {
                result = result | (1 << i);
            }
        }

        return result;
    }
}

class Solution {
    public int singleNumber(int[] nums) {
        int ones = 0; int twos = 0;
        for(int i = 0; i < nums.length; i++) {
            ones = (ones ^ nums[i]) & ~twos;
            twos = (twos ^ nums[i]) & ~ones;
        }
        return ones;
    }
}
