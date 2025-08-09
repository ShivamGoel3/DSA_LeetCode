class Solution {
    void call(List<String> ans, int n, int open, int close, String s) {
        if (close > open || open > n)
            return;
        if (open == close && open + close == 2 * n) {
            ans.add(s);
            return;
        }
        call(ans, n, open + 1, close, s + "(");
        call(ans, n, open, close + 1, s + ")");
    }

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        int opening = 0, closing = 0;
        call(ans, n, opening, closing, "");
        return ans;
    }
}