class Solution {
    public boolean parseBoolExpr(String expression) {
        Stack<Character> s = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (ch == ')') {
                int r1 = s.peek() == 't' ? 1 : 0;
                int r2 = r1;
                s.pop();
                while (s.peek() != '(') {
                    int a = s.peek() == 't' ? 1 : 0;
                    r1 |= a;
                    r2 &= a;
                    s.pop();
                }
                s.pop();
                char t = s.peek();
                s.pop();
                if (t == '!') {
                    s.push(r1 == 1 ? 'f' : 't');
                } else if (t == '&') {
                    s.push(r2 == 1 ? 't' : 'f');
                } else {
                    s.push(r1 == 1 ? 't' : 'f');
                }
                // s.pop();
            } else {
                if (ch != ',')
                    s.push(ch);
            }
        }
        return s.peek() == 't' ? true : false;
    }
}