class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int n = nums.length;
        int prefix = 0;
        int ans = 0;
        HashMap<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < n; i++) {
            prefix += nums[i];
            if (prefix == goal)
                ans++;
            ans += m.getOrDefault(prefix - goal, 0);
            m.put(prefix, m.getOrDefault(prefix, 0) + 1);
        }
        return ans;
    }
}