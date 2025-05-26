class Solution {
    boolean call(int[] nums, int size, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= size)
                continue;
            count += nums[i] / size;
            count--;
            if (nums[i] % size > 0)
                count++;
        }
        return count <= k;
    }

    public int minimumSize(int[] nums, int maxOperations) {

        int start = 1, end = nums[0];
        for (int i = 0; i < nums.length; i++) {
            end = Math.max(end, nums[i]);
        }
        int ans = end;
        while (start <= end) {
            int mid = end - (end - start) / 2;
            boolean check = call(nums, mid, maxOperations);
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