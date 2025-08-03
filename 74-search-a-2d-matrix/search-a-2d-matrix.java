class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int start = 0;
        int end = matrix.length * matrix[0].length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (matrix[mid / matrix[0].length][mid % matrix[0].length] > target)
                end = mid - 1;
            else if (matrix[mid / matrix[0].length][mid % matrix[0].length] < target)
                start = mid + 1;
            else
                return true;
        }
        return false;
    }
}