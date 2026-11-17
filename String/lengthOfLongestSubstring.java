// 3. Longest Substring Without Repeating Characters

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxlen = 0;
        for(int i = 0; i < s.length(); i++) {
            int[] hash = new int[256];
            for(int j = i; j < s.length(); j++) {
                char ch = s.charAt(j);
                if(hash[ch] == 1) break;
                maxlen = Math.max(maxlen, j - i + 1);
                hash[ch] = 1;
            }
        }
        return maxlen;
    }
}
