// 1614. Maximum Nesting Depth of the Parentheses

class Solution {
    public int maxDepth(String s) {
        int cnt = 0;
        int maxDepth = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                cnt++;
                maxDepth = Math.max(maxDepth, cnt);
            } else if (ch == ')') {
                cnt--;
            }
        }
        return maxDepth;
    }
}
// -------------------------------------------------------------------

class Solution {
    public int maxDepth(String s) {
        int cnt = 0, maxDepth = 0;
        int n = s.length();
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                cnt++;
                maxDepth = Math.max(maxDepth, cnt);
                if (maxDepth == n / 2) {
                    return maxDepth;
                }
            } else if (ch == ')') {
                cnt--;
            }
        }
        return maxDepth;
    }
}
