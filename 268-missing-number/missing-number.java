class Solution {
    public int missingNumber(int[] nums) {
        int xor1 = 0;
        int n = nums.length;
        int xor2 = 0;
        for (int i = 0; i < n; i++) {
            xor2 ^= nums[i];
            xor1 ^= (i + 1);
        }
        return xor2 ^ xor1;
    }
}