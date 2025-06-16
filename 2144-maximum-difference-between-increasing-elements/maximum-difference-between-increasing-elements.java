class Solution {
    public int maximumDifference(int[] nums) {
        int ans = -1, min = nums[0];
        for (int i = 0; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
            if (nums[i] > min)
                ans = Math.max(ans, nums[i] - min);
        }
        return ans;
    }
}