class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int prefix = 0;
        HashMap<Integer, Integer> m = new HashMap<>();
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 1)
                prefix++;
            if (prefix == k)
                ans++;
            if (m.containsKey(prefix-k))
                ans += m.get(prefix-k);
            m.put(prefix, m.getOrDefault(prefix, 0) + 1);
        }
        return ans;

    }
}