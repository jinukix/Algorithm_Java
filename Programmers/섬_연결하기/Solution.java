package 섬_연결하기;

import java.util.Arrays;

class Solution {
    public int findParent(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = findParent(parent, parent[x]);
        }
        return parent[x];
    }

    public void unionParent(int[] parent, int a, int b) {
        a = findParent(parent, a);
        b = findParent(parent, b);

        if (a<b) {
            parent[b] = a;
        }
        else {
            parent[a] = b;
        }
    }

    public int solution(int n, int[][] costs) {
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        Arrays.sort(costs, (o1, o2) -> o1[2]-o2[2]);
        int result = 0;
        for (int[] cost: costs) {
            if (findParent(parent, cost[0]) != findParent(parent, cost[1])) {
                unionParent(parent, cost[0], cost[1]);
                result += cost[2];
            }
        }

        return result;
    }
}