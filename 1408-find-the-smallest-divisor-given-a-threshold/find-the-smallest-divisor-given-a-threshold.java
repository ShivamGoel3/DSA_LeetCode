class Solution {
    int call(int[] nums, int mid) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i] / mid;
            if (nums[i] % mid != 0)
                sum++;
        }
        return sum;
    }

    public int smallestDivisor(int[] nums, int threshold) {
        int start = 1;
        int end = nums[0];
        for (int i = 0; i < nums.length; i++) {
            end = Math.max(end, nums[i]);
        }
        int ans = 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            int sum = call(nums, mid);
            if (sum > threshold) {
                start = mid + 1;
            } else {
                ans = mid;
                end = mid - 1;
            }
        }
        return ans;
    }
}