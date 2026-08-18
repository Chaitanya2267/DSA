class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        int maxCount = 0;
        int rowIndex = 0;

        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 1) {
                    count++;
                }
            }
            if (count > maxCount) {
                maxCount = count;
                rowIndex = i;
            }
        }
        return new int[]{rowIndex, maxCount};
    }
}
