class Solution {

    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;
        int[] dp = new int[n];
        int[] hash = new int[n];
        int count = 0, ind = 0;
        for (int i = 0; i < n; i++) {
            int c = 0;
            int index = -1;
            for (int j = 0; j < i; j++) {
                if ((nums[i] % nums[j] == 0) && c < dp[j]) {
                    c = dp[j];
                    index = j;
                }
            }
            dp[i] = c + 1;
            hash[i] = index;
            // System.out.println()
            if (dp[i] > count) {
                count = dp[i];
                ind = i;
            }
        }
        while (ind >= 0) {
            ans.add(nums[ind]);
            ind = hash[ind];
        }
        Collections.reverse(ans);
        return ans;
    }
}