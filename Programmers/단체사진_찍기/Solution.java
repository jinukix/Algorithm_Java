package 단체사진_찍기;

import java.util.ArrayList;

class Solution {
    ArrayList<Character> output = new ArrayList<>();
    char[] friends = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    int result = 0;

    public int solution(int n, String[] data) {
        dfs(data);
        return result;
    }

    public void dfs(String[] data) {
        if (output.size() == friends.length) {
            for (String d: data) {
                int l = Math.abs(output.indexOf(d.charAt(0)) - output.indexOf(d.charAt(2)))-1;

                if (d.charAt(3) == '=') {
                    if (l != d.charAt(4)-48) return;
                } else if (d.charAt(3) == '>') {
                    if (l <= d.charAt(4)-48) return;
                } else if (d.charAt(3) == '<') {
                    if (l >= d.charAt(4)-48) return;
                }
            }

            result++;
        }

        for (int i = 0; i < friends.length; i++) {
            if (!output.contains(friends[i])) {
                output.add(friends[i]);
                dfs(data);
                output.remove((Character) friends[i]);
            }
        }
    }
}