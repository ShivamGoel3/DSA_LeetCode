class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        HashSet<Character> st = new HashSet<>();
        int start = 0;
        int end = 0;
        for (end = 0; end < s.length(); end++) {
            while (st.contains(s.charAt(end)) == true) {
                st.remove(s.charAt(start));
                start++;
            }
            st.add(s.charAt(end));
            ans = Math.max(ans, st.size());
        }
        return ans;
    }
}