class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int sum1 = 0;
        // int sum2 = 0;
        int ans = 0;
        int n = cardPoints.length;
        for (int i = 0; i < k; i++) {
            sum1 += cardPoints[i];
        }
        ans = sum1;
        int sum2 = 0;
        int i = k - 1, j = n - 1;
        while (i >= 0) {
            sum1 -= cardPoints[i];
            sum2 += cardPoints[j];
            i--;
            j--;
            ans = Math.max(ans, sum1 + sum2);
        }
        return ans;
    }

}