class Solution {
    public String resultingString(String s) {
        String ans = "";
        StringBuilder sw = new StringBuilder();
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (st.size() == 0 || (Math.abs(s.charAt(i) - st.peek()) != 1 && Math.abs(s.charAt(i) - st.peek()) != 25))
                st.push(s.charAt(i));
            else
                st.pop();
        }
        while (st.size() > 0) {
            sw.append(st.peek());
            st.pop();
        }
        sw.reverse();
        return sw.toString();
    }
}