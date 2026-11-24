// 76. Minimum Window Substring

class Solution {
    public String minWindow(String s, String t) {
        int[] hash = new int[256];
        for(int i = 0; i < t.length(); i++) { hash[t.charAt(i)]++; }
        int l = 0, r = 0; int cnt = 0;
        int minlen = Integer.MAX_VALUE;
        int sIndex = -1;

        while(r < s.length()) {
            if(hash[s.charAt(r)] > 0)
                cnt++;
            hash[s.charAt(r)]--;
            while(cnt == t.length()) {
                if(r - l + 1 < minlen) {
                    minlen = r - l + 1;
                    sIndex = l;
                }
                hash[s.charAt(l)]++;
                if(hash[s.charAt(l)] > 0) cnt--;
                l++;
            }
            r++;
        }
        return sIndex == -1 ? "" : s.substring(sIndex, sIndex + minlen);
    }
}
