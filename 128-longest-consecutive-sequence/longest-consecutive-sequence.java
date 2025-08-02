class Solution {
    public int longestConsecutive(int[] nums) {
        int ans = 0;
        TreeSet<Integer> s = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            s.add(nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            if (!s.contains(nums[i]) || s.contains(nums[i] + 1))
                continue;
            int a = nums[i];
            int count = 0;
            while (s.contains(a)) {
                count++;
                s.remove(a);
                a--;
            }
            ans = Math.max(ans, count);
        }

        return ans;
    }
}