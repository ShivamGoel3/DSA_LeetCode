class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder str = new StringBuilder();
        for (int k = 0; k < s.length(); k++) {
            if (s.charAt(k) >= 97 && s.charAt(k) <= 122) {
                str.append(s.charAt(k));
            } else if (s.charAt(k) >= 65 && s.charAt(k) <= 90) {
                str.append((char) (s.charAt(k) + 32));
            } else if (s.charAt(k) >= 48 && s.charAt(k) <= 57) {
                str.append(s.charAt(k));
            }
        }
        int i = 0, j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}