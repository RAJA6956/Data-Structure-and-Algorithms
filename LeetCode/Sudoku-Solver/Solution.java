1class Solution {
2    public void solveSudoku(char[][] board) {
3        solve(board);
4    }
5
6    private boolean solve(char[][] b) {
7        for (int i = 0; i < 9; i++) {
8            for (int j = 0; j < 9; j++) {
9                if (b[i][j] == '.') {
10                    for (char c = '1'; c <= '9'; c++) {
11                        if (isValid(b, i, j, c)) {
12                            b[i][j] = c;
13                            if (solve(b)) return true;
14                            b[i][j] = '.';
15                        }
16                    }
17                    return false;
18                }
19            }
20        }
21        return true;
22    }
23
24    private boolean isValid(char[][] b, int r, int c, char ch) {
25        for (int i = 0; i < 9; i++) {
26            if (b[i][c] == ch || b[r][i] == ch ||
27                b[3*(r/3)+i/3][3*(c/3)+i%3] == ch)
28                return false;
29        }
30        return true;
31    }
32}
33