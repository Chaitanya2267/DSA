// 424. Longest Repeating Character Replacement

class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        if(n == 0 || k < 0) { return 0; }
        int maxlen = 0;
        for(int start = 0; start < n; start++) {
            for(int end = start; end < n; end++) {
                int needed = replacentsNeeded(s, start, end);
                if(needed > k) { break; }
                maxlen = Math.max(maxlen, end - start + 1);
            }
        }
        return maxlen;
    }
    private int replacentsNeeded(String s, int start, int end) {
        int[] freq = new int[26];
        int maxfreq = 0;
        for(int i = start; i <= end; i++) {
            int index = s.charAt(i) - 'A';
            freq[index]++;
            maxfreq = Math.max(maxfreq, freq[index]);
        }
        int length = end - start + 1;
        return length - maxfreq;
    }
}

class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        if(n == 0 || k < 0) { return 0; }
        int maxlen = 0;
        for(int start = 0; start < n; start++) {
            int[] freq = new int[26];
            int maxfreq = 0;
            for(int end = start; end < n; end++) {
                int index = s.charAt(end) - 'A';
                freq[index]++;
                maxfreq = Math.max(maxfreq, freq[index]);
                int currlen = end - start + 1;
                int replacementsNeeded = currlen - maxfreq;
                if(replacementsNeeded > k) { break; }
                maxlen = Math.max(maxlen, currlen);
            }
        }
        return maxlen;
    }
}

class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0; int r = 0; int maxlen = 0; int maxfreq = 0; 
        int[] hash = new int[26];
        while(r < s.length()) {
            hash[s.charAt(r) - 'A']++;
            maxfreq = Math.max(maxfreq, hash[s.charAt(r) - 'A']);
            while((r - l + 1) - maxfreq > k) {
                hash[s.charAt(l) - 'A']--; 
                maxfreq = 0;
                for(int i = 0; i < 26; i++) { maxfreq = Math.max(maxfreq, hash[i]); }
                l++;
            }
            if((r - l + 1) - maxfreq <= k) { maxlen = Math.max(maxlen, r - l + 1); }
            r++;
        }
        return maxlen;
    }
}

class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0; int r = 0; int maxlen = 0; int maxfreq = 0; 
        int[] hash = new int[26];
        while(r < s.length()) {
            hash[s.charAt(r) - 'A']++;
            maxfreq = Math.max(maxfreq, hash[s.charAt(r) - 'A']);
            if((r - l + 1) - maxfreq > k) {
                hash[s.charAt(l) - 'A']--; 
                // maxfreq = 0;
                l++;
            }
            if((r - l + 1) - maxfreq <= k) { maxlen = Math.max(maxlen, r - l + 1); }
            r++;
        }
        return maxlen;
    }
}

class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0, maxLen = 0, maxFreq = 0;
        int[] freq = new int[26];
        for(int r = 0; r < s.length(); r++) {
            freq[s.charAt(r) - 'A']++;
            maxFreq = Math.max(maxFreq,freq[s.charAt(r) - 'A']);
            if((r - l + 1) - maxFreq > k) {
                freq[s.charAt(l) - 'A']--;
                l++;
            }
            maxLen = Math.max(maxLen, r - l + 1);
        }
        return maxLen;
    }
}
