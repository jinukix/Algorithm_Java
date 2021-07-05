package 실패율;

import java.util.Arrays;
import java.util.Comparator;

class Node {
    int index;
    double failRate;

    public Node(int index, double failRate){
        this.index = index;
        this.failRate = failRate;
    }
}

class Solution {
    public int[] solution(int n, int[] stages) {
        Node[] nodes = new Node[n];
        int[] arr = new int[n+2];
        Arrays.fill(arr, 0);
        for (int i = 0; i < stages.length; i++) {
            arr[stages[i]-1]++;
        }

        int total = stages.length;
        for (int i = 0; i < n; i++) {
            if (total!=0){
                nodes[i] = new Node(i+1, (double)arr[i] / total);
                total -= arr[i];
            } else {
                nodes[i] = new Node(i+1, 0);
            }
        }

        Comparator<Node> f = new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if(o1.failRate == o2.failRate) {
                    return Integer.compare(o1.index, o2.index);
                }
                return -Double.compare(o1.failRate, o2.failRate);
            }
        };

        Arrays.sort(nodes, f);

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = nodes[i].index;
        }

        return ans;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] stages = {2,1,2,6,2,4,3,3};
        System.out.println(Arrays.toString(sol.solution(5, stages)));
    }
}
