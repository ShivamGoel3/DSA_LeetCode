class Solution {
    public int countPermutations(int[] complexity) {
        int min = complexity[0];
        long ans = 1;
        for (int i = 1; i < complexity.length; i++) {
            if (complexity[i] <= min)
                return 0;
            ans *= i;
            ans %= 1000000007;
        }
        return (int) ans;
    }
}