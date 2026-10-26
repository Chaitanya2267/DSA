// 17. Letter Combinations of a Phone Number

class Solution {
    private static final String[] PHONE_MAP = {
        "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits == null || digits.isEmpty()) { return result; }
        backtrack(0, new StringBuilder(), digits, result);
        return result;
    }
    private void backtrack(int index, StringBuilder current, String digits, List<String> result) {
        if(index == digits.length()) {
            result.add(current.toString());
            return;
        }
        String letters = PHONE_MAP[digits.charAt(index) - '0'];
        for(int i = 0; i < letters.length(); i++) {
            current.append(letters.charAt(i));
            backtrack(index + 1, current, digits, result);
            current.deleteCharAt(current.length() - 1);
        }
    }
}
