package 가장_큰_정사각형_찾기;

class Solution {

    public int solution(int[][] board) {
        if (board.length == 1 && board[0].length == 1) {
            return board[0][0];
        }

        int maxNum = 0;
        for (int i = 1; i < board.length; i++) {
            for (int j = 1; j < board[i].length; j++) {
                if (board[i][j] == 1) {
                    board[i][j] =
                        Math.min(Math.min(board[i - 1][j], board[i][j - 1]), board[i - 1][j - 1])
                            + 1;
                    if (maxNum < board[i][j]) {
                        maxNum = board[i][j];
                    }
                }
            }
        }

        return maxNum * maxNum;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] board = {{0, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}, {0, 0, 1, 0}};
        System.out.println(sol.solution(board));
    }
}