// 1544. Make The String Great

class Solution {
    public String makeGood(String s) {
        StringBuilder result = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if(result.length() > 0) {
                int last = result.charAt(result.length() - 1);
                if (last + 32 == ch || last - 32 == ch) {
                    result.deleteCharAt(result.length() - 1);
                    continue;
                }
            }
            result.append(ch);
        }
        return result.toString();
    }
}
