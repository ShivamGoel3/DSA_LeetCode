class Solution {
    public int numberOfSubstrings(String s) {
        int ans = 0;
        int[] a = new int[] { -1, -1, -1 };
        for (int i = 0; i < s.length(); i++) {
            a[s.charAt(i) - 'a'] = i;
            ans += 1 + Math.min(a[0],
                    Math.min(a[1], a[2]));
        }
        return ans;
    }
}