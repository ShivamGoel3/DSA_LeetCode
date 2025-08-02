class Solution {
    public boolean isValidSudoku(char[][] board) {
        ArrayList<HashSet<Character>> row = new ArrayList<>();
        ArrayList<HashSet<Character>> col = new ArrayList<>();
        ArrayList<HashSet<Character>> box = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            row.add(new HashSet<>());
            col.add(new HashSet<>());
            box.add(new HashSet<>());
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == '.')
                    continue;
                // System.out.println(i + " " + j + " ");
                if (row.get(i).contains(board[i][j]) == true)
                    return false;
                if (col.get(j).contains(board[i][j]) == true)
                    return false;
                int a = 3 * (i / 3) + j / 3;

                if (box.get(a).contains(board[i][j]) == true)
                    return false;
                row.get(i).add(board[i][j]);
                col.get(j).add(board[i][j]);
                box.get(a).add(board[i][j]);
            }
        }
        return true;
    }
}