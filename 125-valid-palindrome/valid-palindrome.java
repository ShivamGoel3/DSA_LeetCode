class Solution {
    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (!((s.charAt(i) >= 97 && s.charAt(i) <= 122) ||
                    (s.charAt(i) >= 65 && s.charAt(i) <= 90) ||
                    (s.charAt(i) >= 48 && s.charAt(i) <= 57))) {
                i++;
            } else if (!((s.charAt(j) >= 97 && s.charAt(j) <= 122) ||
                    (s.charAt(j) >= 65 && s.charAt(j) <= 90) ||
                    (s.charAt(j) >= 48 && s.charAt(j) <= 57))) {
                j--;
            } else {
                char a = s.charAt(i);
                char b = s.charAt(j);
                if (a >= 65 && a <= 90) {
                    a = (char) (a + 32);
                }
                if (b >= 65 && b <= 90) {
                    b = (char) (b + 32);
                }
                if (a != b)
                    return false;
                i++;
                j--;
            }
        }
        return true;
    }
}