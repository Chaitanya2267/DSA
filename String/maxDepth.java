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
