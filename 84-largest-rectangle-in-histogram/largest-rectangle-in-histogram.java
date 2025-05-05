class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> s = new Stack<>();
        int ans = 0;
        for (int i = 0; i <= n; i++) {
            while (s.size() > 0 && (i == n || heights[s.peek()] >= heights[i])) {
                int eleIndex = s.peek();
                s.pop();
                int prevsmaller = s.size() == 0 ? 0 : s.peek() + 1;
                int nextsmaller = i - 1;
                // System.out.println(nextsmaller[i] +" "+prevsmaller[i]);
                int count = nextsmaller - prevsmaller + 1;
                ans = Math.max(ans, count * heights[eleIndex]);
            }
            s.push(i);
        }
        return ans;
    }
}