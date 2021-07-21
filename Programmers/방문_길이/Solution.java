package 방문_길이;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(String dirs) {
        Set<String> set = new HashSet<>();
        int y, ny = 0;
        int x, nx = 0;

        for (char move: dirs.toCharArray()) {
            y = ny;
            x = nx;

            if (move == 'U' && y+1 <= 5) {
                ny++;
            } else if (move == 'D' && y-1 >= -5) {
                ny--;
            } else if (move == 'R' && x+1 <= 5) {
                nx++;
            } else if (move == 'L' && x-1 >= -5) {
                nx--;
            } else {
                continue;
            }

            set.add(y + "" + x + "" + ny + "" + nx);
            set.add(ny + "" + nx + "" + y + "" + x);
        }

        return set.size()/2;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution("LULLLLLLU"));
    }
}