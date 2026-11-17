// 3. Longest Substring Without Repeating Characters

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0; int maxLen = 0;
        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            if (map.containsKey(ch) && map.get(ch) >= left) {
                left = map.get(ch) + 1;
            }
            map.put(ch, right);
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] hash = new int[256];
        for (int i = 0; i < 256; i++) { hash[i] = -1; }

        int n = s.length(); int l = 0, r = 0; int maxLen = 0;
        while (r < n) {
            char ch = s.charAt(r);
            if (hash[ch] != -1) {
                if (hash[ch] >= l) {
                    l = hash[ch] + 1;
                }
            }
            maxLen = Math.max(maxLen, r - l + 1);
            hash[ch] = r;
            r++;
        }
        return maxLen;
    }
}
