class Solution {
    public long countSubarrays(int[] nums, long k) {
        int start = 0;
        long sum = 0;
        long ans = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum * (i - start + 1) >= k) {
                sum -= nums[start];
                start++;
            }
            ans += i - start + 1;
        }
        return ans;
    }
}