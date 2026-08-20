// Search a 2D Matrix II
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        for(int i = 0 ; i < n ; i++){
            if(bs(matrix[i], target)) {
                return true;
            }
        }
        return false;
    }
    private boolean bs(int[] nums, int target){
        int low = 0, high = nums.length - 1;
        while(low <= high) {
            int mid = (low + high) / 2;
            if(nums[mid] == target) return true;
            else if(target > nums[mid]) low = mid + 1;
            else high = mid - 1;
        }
        return false;
    }
}
---------------------------------------------------------------------------------

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        int row = 0 ;
        int col = m - 1;
        while(row < n && col >= 0){
            if(matrix[row][col] == target) return true;
            else if(matrix[row][col] < target) row++;
            else col--;
        }
        return false;
    }
}
