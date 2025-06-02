class Solution {
    public int numberOfSubstrings(String s) {
        int start = 0;
        int ans = 0;
        int[] a = new int[3];
        for (int i = 0; i < s.length(); i++) {
            a[s.charAt(i) - 'a']++;
            while (start <= i && a[0] > 0 && a[1] > 0 && a[2] > 0) {
                ans += s.length() - i;
                a[s.charAt(start) - 'a']--;
                start++;
            }
        }
        return ans;
    }
}