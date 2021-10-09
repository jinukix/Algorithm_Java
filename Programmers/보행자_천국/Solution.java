package 보행자_천국;

class Solution {
    int MOD = 20170805;
    public int solution(int m, int n, int[][] cityMap) {
        int[][][] road = new int[m][n][2];

        for (int y = 1; y < m; y++) {
            if (cityMap[y][0] == 1) break;
            road[y][0][1] = 1;
        }

        for (int x = 1; x < n; x++) {
            if (cityMap[0][x] == 1) break;
            road[0][x][0] = 1;
        }

        for (int y = 1; y < m; y++) {
            for (int x = 1; x < n; x++) {
                if (cityMap[y][x] == 1) continue;

                if (cityMap[y][x-1] == 0) {
                    road[y][x][0] = (road[y][x-1][0] + road[y][x-1][1]) % MOD;
                } else if (cityMap[y][x-1] == 1) {
                    road[y][x][0] = 0;
                } else if (cityMap[y][x-1] == 2) {
                    road[y][x][0] = road[y][x-1][0];
                }

                if (cityMap[y-1][x] == 0) {
                    road[y][x][1] = (road[y-1][x][0] + road[y-1][x][1]) % MOD;
                } else if (cityMap[y-1][x] == 1) {
                    road[y][x][1] = 0;
                } else if (cityMap[y-1][x] == 2) {
                    road[y][x][1] = road[y-1][x][1];
                }
            }
        }

        return (road[m-1][n-1][0] + road[m-1][n-1][1]) % MOD;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(3, 6, new int[][] {
                {0,2,0,0,0,2},
                {0,0,2,0,1,0},
                {1,0,0,2,2,0}
        }));
    }
}