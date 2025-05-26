class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int start = 0;
        int n = answerKey.length();
        int[] a = new int[2];
        int maxfreq = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            a[answerKey.charAt(i) == 'T' ? 0 : 1]++;
            maxfreq = Math.max(a[answerKey.charAt(i) == 'T' ? 0 : 1], maxfreq);
            if ((i - start + 1) - maxfreq > k) {
                a[answerKey.charAt(start) == 'T' ? 0 : 1]--;
                start++;
            }
            ans = Math.max(ans, i - start + 1);
        }
        return ans;
    }
}