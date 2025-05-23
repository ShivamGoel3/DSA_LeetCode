class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int start = 0;
        int ans = 0;
        int maxfreq = 0;
        HashMap<Character, Integer> m = new HashMap<>();
        for (int end = 0; end < n; end++) {
            char ch = s.charAt(end);
            m.put(ch, m.getOrDefault(ch, 0) + 1);
            maxfreq = Math.max(maxfreq, m.get(ch));
            while ((end - start + 1) - maxfreq > k) {
                char t = s.charAt(start);
                m.put(t, m.get(t) - 1);
                if (m.get(t) == 0)
                    m.remove(t);
                start++;
                maxfreq = 0;
                for (Integer i : m.values()) {
                    maxfreq = Math.max(maxfreq, i);
                }
            }
            ans = Math.max(ans, end - start + 1);
        }
        return ans;
    }
}