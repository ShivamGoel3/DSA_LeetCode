class Solution {
    int call(int[] arr, int n) {
        Stack<Integer> s = new Stack<>();
        int ans = 0;
        for (int i = 0; i <= n; i++) {
            while (s.size() > 0 && (i == n || arr[s.peek()] > arr[i])) {
                int a = s.peek();
                s.pop();
                int block = s.size() == 0 ? i : i - s.peek() - 1;
                // System.out.print(a +" " + block + " - ");
                ans = Math.max(ans, arr[a] * block);
            }
            s.push(i);
        }
        // System.out.println("");
        return ans;
    }

    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int[] arr = new int[m];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == '0')
                    arr[j] = 0;
                else
                    arr[j]++;
                // System.out.print(arr[j] + " ");
            }
            ans = Math.max(ans, call(arr, m));
            // System.out.println("");
        }
        return ans;
    }
}