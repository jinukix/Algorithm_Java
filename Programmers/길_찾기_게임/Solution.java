package 길_찾기_게임;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Node implements Comparable<Node>{
    Node left;
    Node right;
    int value;
    int y;
    int x;

    Node(int value, int y, int x) {
        this.value = value;
        this.y = y;
        this.x = x;
    }

    @Override
    public int compareTo(Node o) {
        return o.y - this.y;
    }
}

public class Solution {
    int index = 0;
    public int[][] solution(int[][] nodeinfo) {
        ArrayList<Node> nodeList = new ArrayList<>();
        for (int i = 0; i < nodeinfo.length; i++) {
            nodeList.add(new Node(i+1, nodeinfo[i][1], nodeinfo[i][0]));
        }

        Collections.sort(nodeList);
        Node root = nodeList.get(0);

        for (int i = 1; i < nodeList.size(); i++) {
            Node child = nodeList.get(i);
            connectNode(root, child);
        }

        int[][] result = new int[2][nodeinfo.length];

        preOrder(result, root);
        index = 0;
        postOrder(result, root);

        return result;
    }

    public void connectNode(Node parent, Node child) {
        if (child.x < parent.x) {
            if (parent.left == null) {
                parent.left = child;
            } else {
                connectNode(parent.left, child);
            }
        } else {
            if (parent.right == null) {
                parent.right = child;
            } else {
                connectNode(parent.right, child);
            }
        }
    }

    public void preOrder(int[][] arr, Node node) {
        if (node != null) {
            arr[0][index++] = node.value;
            if (node.left != null) preOrder(arr, node.left);
            if (node.right != null) preOrder(arr, node.right);
        }
    }

    public void postOrder(int[][] arr, Node node) {
        if (node != null) {
            if (node.left != null) postOrder(arr, node.left);
            if (node.right != null) postOrder(arr, node.right);
            arr[1][index++] = node.value;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(Arrays.deepToString(sol.solution(new int[][]{
                {5, 3}, {11, 5}, {13, 3}, {3, 5}, {6, 1}, {1, 3}, {8, 6}, {7, 2}, {2, 2}
        })));
    }
}
