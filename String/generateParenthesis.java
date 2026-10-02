// 22. Generate Parentheses

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generate("", 2*n, result);
        return result;
    }
    private void generate(String current, int length, List<String> result) {
        if(current.length() == length) {
            if(isValid(current)) { result.add(current); }
            return;
        }
        generate(current + "(", length, result);
        generate(current + ")", length, result);
    }
    private boolean isValid(String s) {
        int balance = 0;
        for(char ch : s.toCharArray()) {
            if(ch == '(') { balance++; }
            else { balance--; }
            if(balance < 0) { return false; } // checking for ")" balanace
        }
        return balance == 0;
    }
}
