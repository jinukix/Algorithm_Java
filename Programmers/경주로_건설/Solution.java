package 경주로_건설;

import java.util.PriorityQueue;

class Node implements Comparable<Node> {
    int y;
    int x;
    int cnt;
    boolean isVertical;

    Node (int y, int x, int cnt, boolean isVertical) {
        this.y = y;
        this.x = x;
        this.cnt = cnt;
        this.isVertical = isVertical;
    }

    @Override
    public int compareTo(Node o) {
        return cnt - o.cnt;
    }
}

class Solution {
    int[][] dir = {{0,1}, {0,-1}, {1,0}, {-1,0}};

    public int solution(int[][] board) {
        int result = Integer.MAX_VALUE;
        int r = board.length;

        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(new Node(0, 0, 0, false));

        boolean[][][] visited = new boolean[r][r][2];
        visited[0][0][0] = true;
        visited[0][0][1] = true;

        while (priorityQueue.size() > 0) {
            Node start = priorityQueue.poll();
            for (int i = 0; i < 4; i++) {
                int dy = start.y + dir[i][0];
                int dx = start.x + dir[i][1];

                if (0 <= dy && dy < r && 0 <= dx && dx < r && board[dy][dx] != 1) {
                    int cnt = start.cnt + 100;
                    boolean isVertical = i < 2;

                    if (isVertical != start.isVertical && !(start.y == 0 && start.x == 0)) {
                        cnt += 500;
                    }

                    if (board[dy][dx] != 0 & board[dy][dx] < cnt && visited[dy][dx][i/2]) {
                        continue;
                    }

                    if (dy == r-1 && dx == r-1) {
                        result = Math.min(result, cnt);
                    }

                    board[dy][dx] = cnt;
                    visited[dy][dx][i/2] = true;
                    priorityQueue.add(new Node(dy, dx, cnt, isVertical));
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(new int[][] {
                {0,0,1,0},{0,0,0,0},{0,1,0,1},{1,0,0,0}
        }));
    }
}