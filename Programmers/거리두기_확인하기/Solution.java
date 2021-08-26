package 거리두기_확인하기;

import java.util.Arrays;

class Solution {
    int ny, nx;
    int[][] dir = {
            {1,0}, {0,1}, {-1, 0}, {0, -1},
            {2,0}, {0,2}, {-2, 0}, {0, -2},
            {1,1}, {-1,1}, {1,-1}, {-1,-1}
    };

    public int find (String[] place) {
        for (int y = 0; y < 5; y++) {
            for (int x = 0; x < 5; x++) {
                if (place[y].charAt(x) == 'P') {
                    for (int i = 0; i < 12; i++) {
                        ny = y + dir[i][0];
                        nx = x + dir[i][1];

                        if (0<=ny && ny<5 && 0<=nx && nx<5 && place[ny].charAt(nx) == 'P') {
                            // 상하좌우
                            if(i < 4) return 0;

                            // 상하좌우 2칸
                            else if(i < 8) {
                                ny = y + dir[i-4][0];
                                nx = x + dir[i-4][1];
                                if (place[ny].charAt(nx) != 'X') {
                                    return 0;
                                }
                            }

                            // 대각선
                            else {
                                int[][] crosses = {
                                    {y, x+dir[i][1]},
                                    {y+dir[i][0], x}
                                };

                                for (int[] cross: crosses) {
                                    if (place[cross[0]].charAt(cross[1]) != 'X') {
                                        return 0;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        return 1;
    }
    public int[] solution(String[][] places) {
        int[] result = new int[5];

        for (int i = 0; i < places.length; i++) {
            result[i] = find(places[i]);
        }
        System.out.println(Arrays.toString(result));
        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String[][] places = {
            {"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
            {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
            {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
            {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
            {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}
        };
        sol.solution(places);
    }
}