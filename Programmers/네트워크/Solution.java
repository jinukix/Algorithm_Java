package 네트워크;

import java.util.HashSet;

class Solution {
    public static int findParent(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = findParent(parent, parent[x]);
        }
        return parent[x];
    }

    public static void unionParent(int[] parent, int a, int b) {
        a = findParent(parent, a);
        b = findParent(parent, b);

        if (a < b) {
            parent[b] = a;
        }
        else {
            parent[a] = b;
        }
    }

    public int solution(int n, int[][] computers) {
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (computers[i][j] == 0) continue;
                unionParent(parent, i, j);
            }
        }

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(findParent(parent, i));
        }

        return set.size();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.solution(3, new int[][] {{1,1,0},{1,1,0},{0,0,1}});
    }
}