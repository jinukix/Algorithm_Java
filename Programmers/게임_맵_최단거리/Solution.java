package 게임_맵_최단거리;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    int[][] dir = {{1,0}, {-1,0}, {0,1}, {0,-1}};

    public void bfs(int[][] maps) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0, 0});

        int y, x;
        int dy, dx;
        while (!queue.isEmpty()) {
            int[] start = queue.poll();
            y = start[0];
            x = start[1];

            for (int i = 0; i < 4; i++) {
                dy = y + dir[i][0];
                dx = x + dir[i][1];

                if (0<=dy && dy<maps.length && 0<=dx && dx<maps[0].length && maps[dy][dx]==1) {
                    maps[dy][dx] = maps[y][x]+1;
                    queue.add(new int[] {dy, dx});
                }
            }
        }

    }
    public int solution(int[][] maps) {
        bfs(maps);
        int result = maps[maps.length-1][maps[0].length-1];
        if (result==0) result = -1;
        return result;
    }
}