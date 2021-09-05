package 블록_이동하기;

import java.util.*;

class Node {
    int y1, x1;
    int y2, x2;
    int cnt;

    Node (int y1, int x1, int y2, int x2, int cnt) {
        this.y1 = y1;
        this.x1 = x1;
        this.y2 = y2;
        this.x2 = x2;
        this.cnt = cnt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;

        if (y1 == node.y1 && x1 == node.x1 && y2 == node.y2 && x2 == node.x2) {
            return true;
        }

        return y1 == node.y2 && x1 == node.x2 && y2 == node.y1 && x2 == node.x1;
    }

    @Override
    public int hashCode() {
        return Objects.hash(y1, x1, y2, x2) + Objects.hash(y2, x2, y1, x1);
    }
}

class Solution {
    int[][] dir = {
        {1,0}, {-1,0}, {0,1}, {0, -1}
    };

    public int bfs(int[][] board) {
        int l = board.length;
        Queue<Node> queue = new LinkedList<>();
        HashSet<Node> set = new HashSet<>();
        ArrayList<Node> list = new ArrayList<>();

        Node node = new Node(0,0,0,1, 0);
        queue.add(node);
        set.add(node);
        
        while (!queue.isEmpty()) {
            node = queue.poll();
            for (int i = 0; i < 4; i++) {
                int dy1 = node.y1 + dir[i][0];
                int dx1 = node.x1 + dir[i][1];
                int dy2 = node.y2 + dir[i][0];
                int dx2 = node.x2 + dir[i][1];

                if (0<=dy1 && dy1<l && 0<=dx1 && dx1<l && 0<=dy2 && dy2<l && 0<=dx2 && dx2<l) {
                    list.add(new Node(dy1, dx1, dy2, dx2, node.cnt-1));
                }
            }

            boolean isVertical = node.x1 == node.x2;
            if (isVertical) { // 세로
                if (node.x1 > 0) {
                    // 위쪽 고정
                    if (board[node.y2][node.x2-1] != 1) {
                        list.add(new Node(node.y1, node.x1, node.y1, node.x2-1, node.cnt-1));
                    }
                    // 아래쪽 고정
                    if (board[node.y1][node.x2-1] != 1) {
                        list.add(new Node(node.y2, node.x1-1, node.y2, node.x2, node.cnt-1));
                    }
                }

                if (node.x2 < l-1) {
                    // 위쪽 고정
                    if (board[node.y2][node.x2+1] != 1) {
                        list.add(new Node(node.y1, node.x1, node.y1, node.x2+1, node.cnt-1));
                    }
                    // 아래쪽 고정
                    if (board[node.y1][node.x2+1] != 1) {
                        list.add(new Node(node.y2, node.x1+1, node.y2, node.x2, node.cnt-1));
                    }
                }
            } else {
                if (node.y1 > 0) { // 위로
                    // 왼쪽 고정
                    if (board[node.y1-1][node.x2] != 1) {
                        list.add(new Node(node.y1, node.x1, node.y1-1, node.x1, node.cnt-1));
                    }

                    // 오른쪽 고정
                    if (board[node.y1-1][node.x1] != 1) {
                        list.add(new Node(node.y1-1, node.x2, node.y2, node.x2, node.cnt-1));
                    }
                }

                if (node.y1 < l-1) { // 아래로
                    // 왼쪽 고정
                    if (board[node.y1+1][node.x2] != 1) {
                        list.add(new Node(node.y1, node.x1, node.y1+1, node.x1, node.cnt-1));
                    }

                    // 오른쪽 고정
                    if (board[node.y1+1][node.x1] != 1) {
                        list.add(new Node(node.y1+1, node.x2, node.y2, node.x2, node.cnt-1));
                    }
                }
            }

            for (Node nd: list) {
                if (board[nd.y1][nd.x1] == 1 || board[nd.y2][nd.x2] == 1) continue;
                if (!set.contains(nd)) {
                    if ((nd.y2 == board.length-1 && nd.x2 == board.length-1) || (nd.y1 == board.length-1 && nd.x1 == board.length-1)) {
                        return -nd.cnt;
                    }
                    set.add(nd);
                    queue.add(nd);
                }
            }

            list.clear();
        }

        return -1;
    }

    public int solution(int[][] board) {
        return bfs(board);
    }
}