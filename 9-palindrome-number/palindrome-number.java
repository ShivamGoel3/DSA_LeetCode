class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        ArrayList<Integer> s = new ArrayList<>();
        while (x > 0) {
            s.add(x % 10);
            x /= 10;
        }
        for (int i = 0; i < s.size(); i++) {
            if (s.get(i) != s.get(s.size() - i - 1))
                return false;
        }
        return true;
    }
}