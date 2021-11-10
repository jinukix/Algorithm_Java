package 행렬_테두리_회전하기;

class Solution {

    public int[] solution(int rows, int columns, int[][] queries) {
        int[][] board = new int[rows][columns];
        int n = 1;
        for (int y = 0; y < rows; y++) {
            for (int x = 0; x < columns; x++) {
                board[y][x] = n++;
            }
        }

        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            result[i] = rotate(board, queries[i]);
        }

        return result;
    }

    public int rotate(int[][] board, int[] query) {
        int y = query[0];
        int x = query[1];

        int min = Integer.MAX_VALUE;
        int dir = 0;
        int before = board[y - 1 + 1][x - 1];
        int temp;

        while (true) {
            min = Integer.min(min, before);
            temp = board[y - 1][x - 1];
            board[y - 1][x - 1] = before;
            before = temp;

            if (dir == 0) { // 오른
                x++;
                if (x == query[3]) {
                    dir++;
                }
            } else if (dir == 1) { // 아래
                y++;
                if (y == query[2]) {
                    dir++;
                }
            } else if (dir == 2) { // 왼
                x--;
                if (x == query[1]) {
                    dir++;
                }
            } else { // 위
                y--;
                if (y == query[0]) {
                    break;
                }
            }
        }

        return min;
    }
}
