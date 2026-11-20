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

