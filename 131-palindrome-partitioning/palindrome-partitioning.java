class Solution {
    boolean palindrome(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1))
                return false;
        }
        return true;
    }

    void call(String s, List<List<String>> ans, List<String> t, int index) {
        if (index == s.length()) {
            ans.add(new ArrayList<>(t));
            return;
        }
        for (int i = index; i < s.length(); i++) {
            String g = s.substring(index, i + 1);
            if (palindrome(g) == false)
                continue;
            t.add(g);
            call(s, ans, t, i + 1);
            t.remove(t.size() - 1);
        }
    }

    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> t = new ArrayList<>();
        call(s, ans, t, 0);
        return ans;
    }
}