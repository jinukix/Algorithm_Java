package 세균증식;

class Solution {

    int[][] dir = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public int[][] solution(int rows, int columns, int maxVirus, int[][] queries) {
        int[][] board = new int[rows][columns];

        for (int[] query : queries) {
            multiplication(board, maxVirus, new boolean[rows][columns], query[0] - 1, query[1] - 1);
        }

        return board;
    }

    public void multiplication(int[][] board, int maxVirus, boolean[][] visited, int y, int x) {
        visited[y][x] = true;
        if (board[y][x] < maxVirus) {
            board[y][x]++;
        } else {
            for (int i = 0; i < 4; i++) {
                int ny = y + dir[i][0];
                int nx = x + dir[i][1];

                if (0 <= ny && ny < board.length && 0 <= nx && nx < board[0].length
                    && !visited[ny][nx]) {
                    multiplication(board, maxVirus, visited, ny, nx);
                }
            }
        }
    }
}
