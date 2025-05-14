class Solution {
    public int searchInsert(int[] arr, int target) {
        int ans = arr.length;
        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] >= target) {
                ans = mid;
                end = mid - 1;
            } else {

                start = mid + 1;
            }
            // else
            // return mid;
        }
        return ans;
    }
}