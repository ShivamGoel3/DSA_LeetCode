class Solution {
    int call(int[] nums, int k) {
        int start = 0, ans = 0;
        HashMap<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            m.put(nums[i], m.getOrDefault(nums[i], 0) + 1);
            while (m.size() > k) {
                m.put(nums[start], m.get(nums[start]) - 1);
                if (m.get(nums[start]) == 0)
                    m.remove(nums[start]);
                start++;
            }
            ans += i - start + 1;
        }
        return ans;
    }

    public int subarraysWithKDistinct(int[] nums, int k) {
        return call(nums, k) - call(nums, k - 1);
    }
}