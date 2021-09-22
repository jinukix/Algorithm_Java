package 여행경로;

import java.util.*;

class Solution {
    String result;
    boolean[] visited;

    public void dfs(String[][] tickets, String start, String ans, int depth) {
        if (depth == tickets.length) {
            if (result == null || result.compareTo(ans) > 0) {
                result = ans;
            }
        }

        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && tickets[i][0].equals(start)) {
                visited[i] = true;
                dfs(tickets, tickets[i][1], ans + " " + tickets[i][1],depth+1);
                visited[i] = false;
            }
        }
    }

    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        dfs(tickets, "ICN", "ICN", 0);
        return result.split(" ");
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.solution(
                new String[][] {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}}
        )));
    }
}