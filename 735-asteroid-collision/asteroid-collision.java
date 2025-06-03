class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> s = new Stack<>();
        int n = asteroids.length;
        for (int i = 0; i < n; i++) {
            boolean check = true;
            while (s.size() > 0 && s.peek() > 0 && asteroids[i] < 0) {
                int a = s.peek();
                s.pop();
                if (Math.abs(a) > Math.abs(asteroids[i])) {
                    s.push(a);
                    check = false;
                    break;
                } else if (Math.abs(a) == Math.abs(asteroids[i])) {
                    check = false;
                    break;
                }
            }
            if (check)
                s.push(asteroids[i]);
        }
        int[] ans = new int[s.size()];
        while (s.size() > 0) {
            ans[s.size() - 1] = s.peek();
            s.pop();
        }
        return ans;
    }
}