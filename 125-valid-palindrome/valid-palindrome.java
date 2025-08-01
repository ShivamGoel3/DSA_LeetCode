class Solution {
    public boolean isPalindrome(String st) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < st.length(); i++) {
            if ((st.charAt(i) >= 'a' && st.charAt(i) <= 'z') || (st.charAt(i) >= '0' && st.charAt(i) <= '9'))
                sb.append(st.charAt(i));
            else if ((st.charAt(i) >= 'A' && st.charAt(i) <= 'Z'))

                sb.append((char) (st.charAt(i) + 32));
        }
        String s = sb.toString();
        System.out.print(s);

        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1))
                return false;
        }
        return true;
    }
}