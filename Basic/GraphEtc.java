import java.util.*;

public class GraphEtc {

    public static void main(String[] args) {
        disjointSet(6);
        cruscal(7);
        topologySort(7);
    }

    // 집합 탐색: 특정 원소가 어떤 집합인지 알려주는 연산 (즉 루트를 찾는 연산)
    public static int findParent(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = findParent(parent, parent[x]);
        }
        return parent[x];
    }

    // 합집합: 두 집합을 하나로 합침
    public static void unionParent(int[] parent, int a, int b) {
        a = findParent(parent, a);
        b = findParent(parent, b);

        if (a < b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }

    /*
    분리 집합

    분리집합이란 중복 포함된 원소가 없는 집합.
     */
    public static void disjointSet(int v) {
        int[] parent = new int[v + 1];
        for (int i = 0; i < v + 1; i++) {
            parent[i] = i;
        }

        unionParent(parent, 1, 4);
        unionParent(parent, 2, 3);
        unionParent(parent, 2, 4);
        unionParent(parent, 5, 6);

        System.out.print("각 원소가 속한 집합: ");
        for (int i = 1; i < v + 1; i++) {
            System.out.print(findParent(parent, i) + " ");
        }

        System.out.println();

        System.out.print("부모 테이블: ");
        for (int i = 1; i < v + 1; i++) {
            System.out.print(parent[i] + " ");
        }
        System.out.println();
    }

    /*
    크루스칼 알고리즘

    가장 적은 비용으로 모든 노드를 연결하는 알고리즘
    최소 신장 트리를 찾는 알고리즘
     */
    public static void cruscal(int v) {
        int[] parent = new int[v + 1];
        for (int i = 0; i < v + 1; i++) {
            parent[i] = i;
        }

        ArrayList<Integer[]> edges = new ArrayList<>();

        // 출발->도착 비용
        edges.add(new Integer[]{1, 2, 29});
        edges.add(new Integer[]{1, 5, 75});
        edges.add(new Integer[]{2, 3, 35});
        edges.add(new Integer[]{2, 6, 34});
        edges.add(new Integer[]{3, 4, 7});
        edges.add(new Integer[]{4, 6, 23});
        edges.add(new Integer[]{4, 7, 13});
        edges.add(new Integer[]{5, 6, 53});
        edges.add(new Integer[]{6, 7, 25});

        edges.sort(new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                return o1[2] - o2[2];
            }
        });

        int ans = 0;
        for (Integer[] edge : edges) {
            // 사이클이 발생하지 않는 경우에만 집합에 포함
            if (findParent(parent, edge[0]) != findParent(parent, edge[1])) {
                unionParent(parent, edge[0], edge[1]);
                ans += edge[2];
            }
        }

        System.out.println(ans);
    }
    /*
    위상정렬

    방향 그래프의 모든 노드를 방향성에 거스르지 않고 순서대로 나열하는 것.
    위상정렬은 사이클이 존재하지 않는 그래프에서만 적용됩니다.

    1. 진입차수가 0인 노드를 큐에 넣는다.
    2. 큐가 빌때 까지 다음 과정을 반복
    - 큐에서 원소를 꺼내 해당 노드에서 출발하는 간선을 그래프에서 제거
    - 새롭게 진입차수가 0이된 노드를 큐에 삽입
     */

    public static void topologySort(int v) {
        ArrayList<Integer>[] graph = new ArrayList[v + 1];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        int[] indegree = new int[v + 1];
        int[][] inputs = {
            {1, 2}, {1, 5}, {2, 3}, {2, 6},
            {3, 4}, {4, 7}, {5, 6}, {6, 4},
        };

        for (int[] input : inputs) {
            graph[input[0]].add(input[1]);
            indegree[input[1]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i < v + 1; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        while (queue.size() > 0) {
            int now = queue.poll();
            result.add(now);

            for (Integer gp : graph[now]) {
                indegree[gp] -= 1;

                if (indegree[gp] == 0) {
                    queue.add(gp);
                }
            }
        }

        System.out.println(result);
    }
}
