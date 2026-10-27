// 22. Generate Parentheses

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        doitagain(result, "", n, n);
        return result;
    }
    private void doitagain(List<String> result, String current, int openLeft, int closeLeft) {
        if(openLeft == 0 && closeLeft == 0) {
            result.add(current);
            return;
        }
        if(openLeft > 0) {
            doitagain(result, current + '(', openLeft - 1, closeLeft);
        }
        if(closeLeft > openLeft) {
            doitagain(result, current + ')', openLeft, closeLeft - 1);
        }
    }
}
