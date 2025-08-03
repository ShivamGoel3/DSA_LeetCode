class Solution {
    void call(List<String> ans, String digits, HashMap<Character, String> m, int index,
            String s) {
        if (index == digits.length()) {
            ans.add(s);
            return;
        }

        String g = m.get(digits.charAt(index));
        for (int j = 0; j < g.length(); j++) {
            call(ans, digits, m, index + 1, s + g.charAt(j));
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
        int index = 0;
        call(ans, digits, m, index, "");
        return ans;
    }
}