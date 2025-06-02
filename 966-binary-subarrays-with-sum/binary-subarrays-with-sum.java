class Solution {
    int call(int[] nums, int goal) {
        int n = nums.length;
        int prefix = 0;
        int ans = 0;
        int start = 0;
        for (int i = 0; i < n; i++) {
            prefix += nums[i];
            while (start <= i && prefix > goal) {
                prefix -= nums[start];
                start++;
            }
            ans += i - start;
        }
        return ans;

    }

    public int numSubarraysWithSum(int[] nums, int goal) {

        return call(nums, goal) - call(nums, goal - 1);
    }
}