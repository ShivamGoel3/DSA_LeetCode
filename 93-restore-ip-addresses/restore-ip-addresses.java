class Solution {
    void call(List<String> ans, String s, int index, String g, int count) {
        if (index == s.length()) {
            if (count == 4) {
                ans.add(g);
            }
            return;
        }
        if (count > 4)
            return;
        int a = 0;
        for (int i = index; i < s.length(); i++) {
            a *= 10;
            a += (s.charAt(i) - '0');
            if (i > 0 && s.charAt(index) == '0' && index != i)
                break;
            if (a >= 0 && a <= 255) {
                if (count == 3)
                    call(ans, s, i + 1, g + s.substring(index, i + 1), count + 1);
                else
                    call(ans, s, i + 1, g + s.substring(index, i + 1) + ".", count + 1);
            } else
                break;
        }
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        call(ans, s, 0, "", 0);
        return ans;
    }
}