import java.util.*;

public class FindPath {

    public static void main(String[] args4) {
        dijkstra(6);
        floydWarshall(6);
    }

    /*
    다익스트라

    그래프에서 여러 개의 노드가 있을때
    특정 노드에서 다른 노드로 가는 각각의 최단 경로를 구하는 알고리즘
    음의 간선이 존재하지 않아야합니다.
    다익스트라는 그리디, DP의 한 유형이라고도 볼 수 있음.

    1. 출발 노드 설정 및 최단 거리 테이블 초기화.
    2. 방문하지 않은 노드 중 최단 거리가 가장 짧은 노드 선택
    3. 해당 노드를 거쳐 다른 노드로 가는 비용을 계산 해 테이블 갱신.
    4. 2~3 반복
     */
    public static void dijkstra(int n) {
        class Node {

            final int distance;
            final int now;

            Node(int distance, int now) {
                this.distance = distance;
                this.now = now;
            }
        }

        HashMap<Integer, ArrayList<Integer[]>> map = new HashMap();

        for (int i = 0; i < n + 1; i++) {
            map.put(i, new ArrayList<>());
        }

        //     start                end cost
        map.get(1).add(new Integer[]{2, 2});
        map.get(1).add(new Integer[]{3, 5});
        map.get(1).add(new Integer[]{4, 1});
        map.get(2).add(new Integer[]{3, 3});
        map.get(2).add(new Integer[]{4, 2});
        map.get(3).add(new Integer[]{2, 3});
        map.get(3).add(new Integer[]{6, 5});
        map.get(4).add(new Integer[]{3, 3});
        map.get(4).add(new Integer[]{5, 1});
        map.get(5).add(new Integer[]{3, 1});
        map.get(5).add(new Integer[]{6, 2});

        int[] distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(
            Comparator.comparingInt((Node node) -> node.distance)
        );

        int start = 1;
        priorityQueue.add(new Node(0, start));
        distance[start] = 0;

        while (priorityQueue.size() > 0) {
            Node node = priorityQueue.poll();
            if (distance[node.now] < node.distance) {
                continue;
            }

            for (Integer[] arr : map.get(node.now)) {
                int cost = node.distance + arr[1];

                if (cost < distance[arr[0]]) {
                    distance[arr[0]] = cost;
                    priorityQueue.add(new Node(cost, arr[0]));
                }
            }
        }

        System.out.println(Arrays.toString(distance));
    }

    /*
    플로이드 워셜

    모든 지점에서 다른 모든 지점까지의 최단 경로를 구하는 알고리즘.
    다익스트라는 단계마다 최단 거리를 가지는 노드를 하나씩 반복적으로 선택해, 해당 노드를 거쳐 가는 경로를 확인하며,
    테이블을 갱신하는 방식으로 동작한다, 플로이드 워셜 알고리즘 또한 단계마다 '거쳐 가는 노드'를 기준으로 알고리즘을 수행한다.
    하지만 매번 방문하지 않은 노드 중에서 최단 거리를 갖는 노드를 찾을 필요가 없다는 점에서 차이가 있다.
     */
    public static void floydWarshall(int n) {
        int max = Integer.MAX_VALUE;
        long[][] graph = new long[n][n];

        for (int i = 1; i < n; i++) {
            Arrays.fill(graph[i], max);
            graph[i][i] = 0;
        }

        // i -> j 비용 k
        graph[1][2] = 4;
        graph[1][4] = 6;
        graph[2][1] = 3;
        graph[2][3] = 7;
        graph[3][1] = 5;
        graph[3][4] = 4;
        graph[4][3] = 2;

        for (int k = 1; k < n; k++) {
            for (int i = 1; i < n; i++) {
                for (int j = 1; j < n; j++) {
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if (graph[i][j] == max) {
                    System.out.print("INF ");
                } else {
                    System.out.print(graph[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}

