// 844. Backspace String Compare

class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();

        for(char ch : s.toCharArray()) {
            if (ch!= '#') {
                stack1.push(ch);
            } else if(!stack1.isEmpty()) {
                stack1.pop();
            }
        }

        for(char ch : t.toCharArray()) {
            if (ch!= '#') {
                stack2.push(ch);
            } else if(!stack2.isEmpty()) {
                stack2.pop();
            }
        }

        return stack1.equals(stack2);
    }
}
