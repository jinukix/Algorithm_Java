package 셔틀버스;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    public int getSecond(String time) {
        String[] times = time.split(":");
        return Integer.parseInt(times[0]) * 60 + Integer.parseInt(times[1]);
    }

    public String getTime(int time) {
        String min = time / 60 + "";
        String sec = time % 60 + "";

        if (min.length() == 1) min = "0" + min;
        if (sec.length() == 1) sec = "0" + sec;

        return min + ":" + sec;
    }

    public String solution(int n, int t, int m, String[] timetable) {
        List<List<Integer>> buses = new ArrayList<>();
        for (int i = 0 ; i < n; i++) {
            buses.add(new ArrayList<>());
        }

        PriorityQueue<Integer> crews = new PriorityQueue<>();
        for (String time : timetable) {
            crews.offer(getSecond(time));
        }

        int result = 0;
        int start = 540;
        for (int i = 0; i < n; i++) {
            while (!crews.isEmpty()) {
                int crew = crews.poll();
                if (crew <= start && buses.get(i).size() < m) {
                    buses.get(i).add(crew);
                    result = crew - 1;
                } else {
                    crews.offer(crew);
                    break;
                }
            }
            start += t;
        }

        if (buses.get(n - 1).size() < m) {
            result = start - t;
        }
        return getTime(result);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(10,60,45, new String[] {
                "23:59","23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59"
        }));
    }
}