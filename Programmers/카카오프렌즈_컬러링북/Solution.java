package 카카오프렌즈_컬러링북;

import java.util.*;

class Position {
    int y;
    int x;

    Position(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

class Solution {
    int[] dy = {1,-1,0,0};
    int[] dx = {0,0,1,-1};

    public int bfs(int[][] picture, int y, int x) {
        int count = 0;
        int n = picture[y][x];
        picture[y][x] = 0;

        Queue<Position> queue = new LinkedList<>();
        queue.add(new Position(y, x));

        while (queue.size() > 0) {
            Position start = queue.poll();
            count++;

            for (int i = 0; i < 4; i++) {
                int ny = start.y + dy[i];
                int nx = start.x + dx[i];

                if (0 <= ny && ny < picture.length && 0<= nx && nx < picture[0].length && picture[ny][nx] == n) {
                    picture[ny][nx] = 0;
                    queue.add(new Position(ny, nx));
                }
            }
        }

        return count;
    }

    public int[] solution(int m, int n, int[][] picture) {
        ArrayList<Integer> list = new ArrayList<>();

        int[][] copyPicture = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                copyPicture[i][j] = picture[i][j];
            }
        }

        for (int y = 0; y < picture.length; y++) {
            for (int x = 0; x < picture[y].length; x++) {
                if (copyPicture[y][x] == 0) continue;

                list.add(bfs(copyPicture, y, x));
            }
        }

        return new int[] {list.size(), Collections.max(list)};
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] picture = {
                {1, 1, 1, 0},
                {1, 1, 1, 0},
                {0, 0, 0, 1},
                {0, 0, 0, 1},
                {0, 0, 0, 1},
                {0, 0, 0, 1}
        };
        sol.solution(6,4, picture);
    }
}
