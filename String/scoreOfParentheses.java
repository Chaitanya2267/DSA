class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(') { stack.push(0); }
            else {
                int inside = stack.pop();
                int score;
                if(inside == 0) {score = 1; }
                else { score = 2 * inside; }
                int previous = stack.pop();
                stack.push(previous + score);
            }
        }
        return stack.peek();
    }
}
