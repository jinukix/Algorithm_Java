package 전력망을_둘로_나누기;

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

        if (a<b) parent[b] = a;
        else parent[a] = b;
    }

    public int solution(int n, int[][] wires) {
        int[] parent = new int[n+1];
        int result = Integer.MAX_VALUE;
        int idx = 0;

        while (idx < n-1) {
            for (int i = 1; i < n+1; i++) {
                parent[i] = i;
            }

            for (int i = 0; i < wires.length; i++) {
                if (idx == i) continue;

                int a = wires[i][0];
                int b = wires[i][1];
                unionParent(parent, a, b);
            }

            int temp = 0;
            for (int i = 1; i < n+1; i++) {
                if (findParent(parent, i) == 1) temp++;
            }

            result = Math.min(Math.abs(n-temp-temp), result);
            idx++;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(9, new int[][] {{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}}));
    }
}