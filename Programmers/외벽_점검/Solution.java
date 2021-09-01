package 외벽_점검;

import java.util.Arrays;

class Solution {
    int n;
    int[] dist;
    int[] weak;
    int min = Integer.MAX_VALUE;

    public int solution(int n, int[] weak, int[] dist) {
        Arrays.sort(dist);

        this.n = n;
        this.weak = weak;
        this.dist = dist;

        for (int i = 0; i < weak.length; i++) {
            permutation(1, i, new boolean[weak.length]);
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }

    void permutation(int depth, int pos, boolean[] visited) {
        if (depth > dist.length) return;
        if (min <= depth) return;

        boolean[] copyVisited = Arrays.copyOf(visited, visited.length);
        copyVisited[pos] = true;

        for (int i = 1; i < weak.length; i++) {
            int nextPos = (pos+i) % weak.length;
            int diff = nextPos >= pos ? weak[nextPos] - weak[pos] : weak[nextPos] + n - weak[pos];

            if (diff <= dist[dist.length-depth]) {
                copyVisited[nextPos] = true;
            } else {
                break;
            }
        }

        boolean isClear = true;
        for (int i = 0; i < weak.length; i++) {
            if (!copyVisited[i]) {
                isClear = false;
                permutation(depth+1, i, copyVisited);
            }
        }

        if (isClear) {
            min = depth;
        }
    }
}