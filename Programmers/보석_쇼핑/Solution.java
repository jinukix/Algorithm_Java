package 보석_쇼핑;

import java.util.*;

public class Solution {
    public int[] solution(String[] gems) {
        HashSet<String> set = new HashSet<>(Arrays.asList(gems));
        HashMap<String, Integer> map = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        int startPoint = 0;
        int start = 0;
        int min = Integer.MAX_VALUE;

        for (String gem : gems) {
            if (!map.containsKey(gem)) {
                map.put(gem, 1);
            } else {
                map.put(gem, map.get(gem) + 1);
            }

            queue.add(gem);
            while (true) {
                String temp = queue.peek();
                if (map.get(temp) > 1) {
                    map.put(temp, map.get(temp) - 1);
                    queue.poll();
                    startPoint++;
                } else {
                    break;
                }
            }

            if (map.size() == set.size() && queue.size() < min) {
                min = queue.size();
                start = startPoint;
            }
        }

        return new int[] {start+1, start+min};
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.solution(new String[]{
                "B","A","C","A","D"
        })));
    }
}
