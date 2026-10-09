// 1541. Minimum Insertions to Balance a Parentheses String

class Solution {
    public int minInsertions(String s) {
        int open = 0;
        int insertions = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                open += 2;

                if (open % 2 != 0) {
                    insertions++;
                    open--;
                }
            } else {
                open--;

                if (open < 0) {
                    insertions++;
                    open = 1;
                }
            }
        }

        return insertions + open;
    }
}
