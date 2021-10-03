package 불량_사용자;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.regex.Pattern;

class Solution {
    ArrayList<ArrayList<String>> list;
    HashSet<HashSet<String>> resultSet;
    HashSet<String> set;

    public int solution(String[] user_id, String[] banned_id) {
        list = new ArrayList<>();
        resultSet = new HashSet<>();
        set = new HashSet<>();

        for (String banUser : banned_id) {
            ArrayList<String> l = new ArrayList<String>();
            String regex = banUser.replace("*", "[a-zA-Z0-9]");
            for (String user : user_id) {
                if (Pattern.matches(regex, user)) {
                    l.add(user);
                }
            }
            list.add(l);
        }

        dfs(0);
        return resultSet.size();
    }

    public void dfs(int index) {
        if (index == list.size()) {
            resultSet.add(new HashSet<>(set));
            return;
        }

        ArrayList<String> l = list.get(index);
        for (String s : l) {
            if (!set.contains(s)) {
                set.add(s);
                dfs(index + 1);
                set.remove(s);
            }
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(new String[] {"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[] {"fr*d*", "*rodo", "******", "******"}));
    }
}
