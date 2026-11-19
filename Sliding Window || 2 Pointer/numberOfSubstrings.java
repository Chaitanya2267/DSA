// 1358. Number of Substrings Containing All Three Characters

class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        if(n < 3) { return 0; }
        long cnt = 0;
        for(int start = 0;  start < n; start++) {
            for(int end = start; end < n; end++) {
                if(containsAllThree(s, start, end)) { cnt++; }
            }
        }
        return (int)cnt;
    }
    private boolean containsAllThree(String s, int start, int end) {
        boolean hasA = false;
        boolean hasB = false;
        boolean hasC = false;
        for(int i = start; i <= end; i++) {
            if(s.charAt(i) == 'a') { hasA = true; }
            if(s.charAt(i) == 'b') { hasB = true; }
            if(s.charAt(i) == 'c') { hasC = true; }
        }
        return hasA && hasB && hasC;
    }
}

class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        if(n < 3) { return 0; }
        long cnt = 0;
        for(int start = 0; start < n; start++) {
            int[] freq = new int[3];
            for(int end = start; end < n; end++) {
                freq[s.charAt(end) - 'a']++;
                if(freq[0] > 0 && freq[1] > 0 && freq[2] > 0) {
                    cnt += n - end;
                    break;
                }
            }
        }
        return (int)cnt;
    }
}

// this is actuall ans and opt one
class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        if(n < 3) { return 0; }
        long cnt = 0;
        int left = 0;
        int[] freq = new int[3];
        for(int right = 0; right < n; right++) {
            freq[s.charAt(right) - 'a']++;
            while(freq[0] > 0 && freq[1] > 0 && freq[2] > 0) {
                cnt += n - right;
                freq[s.charAt(left) - 'a']--;
                left++;
            }
        }
        return (int)cnt;
    }
}
