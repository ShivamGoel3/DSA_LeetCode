class Solution {
    boolean check(HashMap<Character, Integer> m1, HashMap<Character, Integer> m2) {
        for (Character i : m1.keySet()) {
            int freq = m1.get(i);
            if (m2.getOrDefault(i, 0) < freq)
                return false;
        }
        return true;
    }
    public String minWindow(String s, String t) {
        int start = 0;
        int ans = Integer.MAX_VALUE;
        HashMap<Character, Integer> m1 = new HashMap<>();
        HashMap<Character, Integer> m2 = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            m1.put(ch, m1.getOrDefault(ch, 0) + 1);
        }
        String a = "";
        int count = 0;
        for (int end = 0; end < s.length(); end++) {
            char ch = s.charAt(end);
            m2.put(ch, m2.getOrDefault(ch, 0) + 1);
            if (m2.get(ch) <= m1.getOrDefault(ch, 0)) {
                count++;
            }
            while (count == t.length()) {
                if (ans > (end - start + 1)) {
                    ans = end - start + 1;
                    a = s.substring(start, end + 1);
                }
                char w = s.charAt(start);
                m2.put(w, m2.get(w) - 1);
                if (m2.get(w) < m1.getOrDefault(w, 0))
                    count--;
                if (m2.get(w) == 0)
                    m2.remove(w);
                start++;
            }
        }
        return a;

    }
}