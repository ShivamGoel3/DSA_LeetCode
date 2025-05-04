class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> s = new Stack<>();
        int[] nextsmaller = new int[n];
        int[] prevsmaller = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            while (s.size() > 0 && heights[s.peek()] >= heights[i])
                s.pop();
            nextsmaller[i] = s.size() == 0 ? n - 1 : s.peek() - 1;
            s.push(i);
        }
        s.clear();
        for (int i = 0; i < n; i++) {
            while (s.size() > 0 && heights[s.peek()] >= heights[i])
                s.pop();
            prevsmaller[i] = s.size() == 0 ? 0 : s.peek() + 1;
            s.push(i);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            // System.out.println(nextsmaller[i] +" "+prevsmaller[i]);
            int count = nextsmaller[i] - prevsmaller[i] + 1;
            ans = Math.max(ans, count * heights[i]);
        }
        return ans;
    }
}