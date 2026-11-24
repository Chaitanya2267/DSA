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


class Solution {
    public String minWindow(String s, String t) {
        int n = s.length(); int m = t.length();
        if(n == 0 || m == 0 || n < m) { return ""; }
        int[] need = new int[128];
        for(int i = 0; i < m; i++) { need[t.charAt(i)]++; }
        int minlen = Integer.MAX_VALUE;
        String ans = "";
        for(int start = 0; start < n; start++) {
            int[] window = new int[128];
            int matched = 0;
            for(int end = start; end < n; end++) {
                char curr = s.charAt(end);
                window[curr]++;
                if(need[curr] > 0 && window[curr] <= need[curr]) { matched++; }
                if(matched == m) {
                    int currlen = end - start + 1;
                    if(currlen < minlen) {
                        minlen = currlen;
                        ans = s.substring(start, end + 1);
                    }
                    break;
                }
            }
        }
        return ans;  
    }
}
