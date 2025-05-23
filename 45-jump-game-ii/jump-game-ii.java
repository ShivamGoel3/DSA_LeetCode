class Solution {
    public int jump(int[] nums) {
        int jump = 0, left = 0, right = 0;
        while (right < nums.length - 1) {
            int fastest = left;
            for (int i = left; i <= right; i++) {
                fastest = Math.max(fastest,
                        i + nums[i]);
            }
            left = right + 1;
            jump++;
            right = fastest;
        }
        return jump;
    }
}