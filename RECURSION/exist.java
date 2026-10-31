// 79. Word Search

class Solution {
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (check(board, word, i, j, n, m, 0)) return true;
                }
            }
        }
        return false;
    }

    private boolean check(char[][] board, String word, int i, int j, int n, int m, int k) {
        if (k == word.length()) { return true; }
        if (i < 0 || i >= n ||
            j < 0 || j >= m ||
            board[i][j] == '.' ||
            board[i][j] != word.charAt(k))
            return false;

        char temp = board[i][j];
        board[i][j] = '.';

        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};

        for (int dir = 0; dir < 4; dir++) {

            if (check(board, word,
                      i + dx[dir],
                      j + dy[dir],
                      n, m,
                      k + 1)) {

                board[i][j] = temp;
                return true;
            }
        }

        board[i][j] = temp;

        return false;
    }
}
