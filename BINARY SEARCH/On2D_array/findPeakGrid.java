class Solution {
    public int[] findPeakGrid(int[][] mat){
        int rows = mat.length;
        int cols = mat[0].length;
        int low = 0;
        int high = cols - 1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            int row = maxElement(mat, mid);

            int left = mid > 0 ? mat[row][mid - 1] : Integer.MIN_VALUE;
            int right = mid < cols - 1 ? mat[row][mid + 1] : Integer.MIN_VALUE;

            if(mat[row][mid] > left && mat[row][mid] > right){return new int[]{row, mid}; }
            else if(left > mat[row][mid]){high = mid - 1; }
            else {low = mid + 1; }
        }
        return new int[]{-1, -1};
    }
    public int maxElement(int[][] mat, int col) {
        int maxValue = Integer.MIN_VALUE;
        int index = -1;
        for(int i = 0; i < mat.length; i++){
            if(mat[i][col] > maxValue) {
                maxValue = mat[i][col];
                index = i;
            }
        }
        return index;
    }
}
