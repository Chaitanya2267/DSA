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
