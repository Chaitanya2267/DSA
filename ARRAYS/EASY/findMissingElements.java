import java.util.*;

class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        boolean[] present = new boolean[max - min + 1];

        for (int num : nums) {
            present[num - min] = true;
        }

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < present.length; i++) {
            if (!present[i]) {
                result.add(i + min);
            }
        }

        return result;
    }
}
