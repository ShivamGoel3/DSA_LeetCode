class Solution {
    void call(char[][] board, int i, int j, int m, int n) {
        if (i < 0 || j < 0 || i >= m || j >= n)
            return;
        if (board[i][j] != 'O')
            return;
        board[i][j] = 'Y';
        call(board, i + 1, j, m, n);
        call(board, i - 1, j, m, n);
        call(board, i, j + 1, m, n);
        call(board, i, j - 1, m, n);
    }

    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            call(board, i, 0, m, n);
            call(board, i, n - 1, m, n);
        }
        for (int i = 0; i < n; i++) {
            call(board, 0, i, m, n);
            call(board, m - 1, i, m, n);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'Y')
                    board[i][j] = 'O';
            }
        }
    }
}