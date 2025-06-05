class Solution {
    void call(String digits, List<String> ans, String a, int index,
            HashMap<Character, String> m) {
        if (index == digits.length()) {
            ans.add(a);
            return;
        }
        String w = m.get(digits.charAt(index));
        for (int i = 0; i < w.length(); i++) {
            call(digits, ans, a + w.charAt(i), index + 1, m);
        }

    }

    public List<String> letterCombinations(String digits) {
        HashMap<Character, String> m = new HashMap<>();
        m.put('2', "abc");
        m.put('3', "def");
        m.put('4', "ghi");
        m.put('5', "jkl");
        m.put('6', "mno");
        m.put('7', "pqrs");
        m.put('8', "tuv");
        m.put('9', "wxyz");
        List<String> ans = new ArrayList<>();
        if (digits.length() == 0)
            return ans;
        call(digits, ans, "", 0, m);
        return ans;
    }
}