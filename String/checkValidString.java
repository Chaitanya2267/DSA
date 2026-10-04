// 678. Valid Parenthesis String

class Solution {
    public boolean checkValidString(String s) {
        Boolean[][] memo = new Boolean[s.length()][s.length() + 1];
        return solve(s, 0, 0, memo);
    }
    private boolean solve(String s, int index, int cnt, Boolean[][] memo) {
        if (cnt < 0) { return false; }
        if (index == s.length()) { return cnt == 0; }
        if (memo[index][cnt] != null) { return memo[index][cnt]; }

        boolean result;

        if (s.charAt(index) == '(') {
            result = solve(s, index + 1, cnt + 1, memo);
        } else if (s.charAt(index) == ')') {
            result = solve(s, index + 1, cnt - 1, memo);
        } else { // '*'
            result =
                solve(s, index + 1, cnt + 1, memo) ||
                solve(s, index + 1, cnt - 1, memo) ||
                solve(s, index + 1, cnt, memo);
        }
        memo[index][cnt] = result;
        return result;
    }
}
// ------------------------------------------------------------------

class Solution {
    public boolean checkValidString(String s) {
        int max = 0;
        int min = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') { max++; min++; }
            else if(s.charAt(i) == ')') { max--; min--; }
            else{ min--; max++; }
            if(max < 0) { return false; }
            if(min < 0) { min = 0; }
        }
        return min == 0;
    }
}
