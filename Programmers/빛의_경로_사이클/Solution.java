package 빛의_경로_사이클;

import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    boolean[][][] isVisited;
    int[][] dir = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    public int[] solution(String[] grid) {
        ArrayList<Integer> list = new ArrayList<>();

        isVisited = new boolean[grid.length][grid[0].length()][4];
        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[0].length(); x++) {
                for (int d = 0; d < 4; d++) {
                    if (!isVisited[y][x][d]){
                        list.add(light(grid, y, x, d));
                    }
                }
            }
        }

        return list.stream().sorted().mapToInt(i -> i).toArray();
    }

    private int light(String[] grid, int y, int x, int d) {
        int cnt = 0;

        while (!isVisited[y][x][d]) {
            isVisited[y][x][d] = true;
            cnt++;

            if (grid[y].charAt(x) == 'L') {
                d = (d + 3) % 4;
            } else if (grid[y].charAt(x) == 'R') {
                d = (d + 1) % 4;
            }

            y = (y + dir[d][0] + grid.length) % grid.length;
            x = (x + dir[d][1] + grid[0].length()) % grid[0].length();
        }

        return cnt;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.solution(new String[]{"L", "R"})));
    }
}