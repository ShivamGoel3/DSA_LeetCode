class Solution {
    boolean call(int[] arr, int time, int k) {
        int count = 1;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (sum + arr[i] <= time) {
                sum += arr[i];
            } else {
                sum = arr[i];
                count++;
            }
        }
        return count <= k;
    }

    public int splitArray(int[] arr, int k) {
        int start = arr[0];
        int end = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            end += arr[i];
            start = Math.max(start, arr[i]);
        }
        int ans = end;
        while (start <= end) {
            int mid = (start + end) / 2;
            boolean check = call(arr, mid, k);
            if (check) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }
}