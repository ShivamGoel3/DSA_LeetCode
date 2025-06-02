class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < num.length(); i++) {
            while (k > 0 && st.size() > 0 && st.peek() > num.charAt(i)) {
                st.pop();
                k--;
            }
            // if (!(num.charAt(i) == '0' && st.size() == 0))
            st.push(num.charAt(i));
        }
        while (st.size() > 0 && k > 0) {
            st.pop();
            k--;
        }
        StringBuilder a = new StringBuilder();
        while (st.size() > 0) {
            char ch = st.peek();
            a.append(ch);
            st.pop();
        }
        a.reverse();
        // int i = 0;
        while (a.length() > 0 && a.charAt(0) == '0')
            a.deleteCharAt(0);
        return a.length() == 0 ? "0" : a.toString();
    }
}