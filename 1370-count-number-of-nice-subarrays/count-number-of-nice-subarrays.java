class Solution {
    int call(int[] nums, int k) {
        int prefix = 0;
        int start = 0;
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 1)
                prefix++;
            while (prefix > k) {
                prefix -= nums[start] % 2;
                start++;
            }
            //System.out.print(i + " " + start + " - ");
            ans += i - start + 1;
        }
        //System.out.println(ans);
        return ans;
    }

    public int numberOfSubarrays(int[] nums, int k) {
        return call(nums, k) - call(nums, k - 1);

    }
}