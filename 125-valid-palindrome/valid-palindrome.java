class Solution {
    public boolean isPalindrome(String st) {
        int i = 0, j = st.length() - 1;
        while (i < j) {
            if (!((st.charAt(i) >= 'a' && st.charAt(i) <= 'z') || (st.charAt(i) >= '0' && st.charAt(i) <= '9')
                    || (st.charAt(i) >= 'A' && st.charAt(i) <= 'Z')))
                i++;
            else if (!((st.charAt(j) >= 'a' && st.charAt(j) <= 'z') || (st.charAt(j) >= '0' && st.charAt(j) <= '9')
                    || (st.charAt(j) >= 'A' && st.charAt(j) <= 'Z')))
                j--;
            else {
                char x = st.charAt(i);
                char y = st.charAt(j);
                if (x >= 'A' && x <= 'Z') {
                    x = (char) (x + 32);
                }
                if (y >= 'A' && y <= 'Z') {
                    y = (char) (y + 32);
                }
                if (x != y)
                    return false;
                i++;
                j--;
            }

        }

        return true;
    }
}