// 171. Excel Sheet Column Number

class Solution {
    public int titleToNumber(String columnTitle) {
        int result = 0;
        for(char c : columnTitle.toCharArray()) {
            result = result * 26 + (c - 'A' + 1);
        }
        return result;
    }
}
