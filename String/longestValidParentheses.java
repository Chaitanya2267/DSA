// 32. Longest Valid Parentheses

class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    int length = i - stack.peek();
                    max = Math.max(max, length);
                }
            }
        }
        return max;
    }
}

// -----------------------------------------------------------------------------

class Solution {
    public int longestValidParentheses(String s) {
        int open = 0; int close = 0; int longest = 0;
        for(int i = 0; i< s.length(); i++) {
            if(s.charAt(i) == '('){ open++; }
            else close++;
            if(open == close) { longest = Math.max(longest, 2*close); }
            else if(close > open) { open = 0; close = 0; }
        }
        open = 0; close = 0;
        for(int i = s.length() - 1; i >= 0; i--) {
            if(s.charAt(i) == '(') { open++; }
            else close++;
            if(open == close) { longest = Math.max(longest, 2*close); }
            else if(open > close) {open = 0; close  = 0; }
        }
        return longest;
    }
}
