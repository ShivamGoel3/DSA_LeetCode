class Solution {
    void call(int[] arr, int x, int start, int end, int[] ans) {
        if (start > end)
            return;
        int mid = (start + end) / 2;
        if (arr[mid] > x) {
            call(arr, x, start, mid - 1, ans);
            // end = mid - 1;
        } else if (arr[mid] < x) {
            call(arr, x, mid + 1, end, ans);
        } else {
            if (ans[0] != -1)
                ans[0] = Math.min(mid, ans[0]);
            else
                ans[0] = mid;
            if (ans[1] != -1)
                ans[1] = Math.max(mid, ans[1]);
            else
                ans[1] = mid;
            call(arr, x, start, mid - 1, ans);
            call(arr, x, mid + 1, end, ans);
        }

    }

    public int[] searchRange(int[] arr, int x) {
        int[] ans = new int[2];
        ans[0] = -1;
        ans[1] = -1;
        int start = 0, end = arr.length - 1;
        call(arr, x, start, end, ans);
        return ans;
    }
}