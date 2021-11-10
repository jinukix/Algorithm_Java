package 추석_트래픽;

import java.util.ArrayList;

class Time {

    int start;
    int end;

    Time(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

class Solution {

    public int solution(String[] lines) {
        ArrayList<Time> list = new ArrayList<>();

        for (String line : lines) {
            String[] logs = line.split(" ");
            if (!logs[0].equals("2016-09-15")) {
                continue;
            }

            String[] times = logs[1].split(":");
            int end = Integer.parseInt(times[0]) * 3600000 + Integer.parseInt(times[1]) * 60000;
            String second = times[2].replace(".", "");
            end += Integer.parseInt(second);

            String t = logs[2].replace(".", "").replace("s", "");
            t += "0".repeat(4 - t.length());
            int start = end - Integer.parseInt(t) + 1;

            list.add(new Time(start, end));
        }

        list.sort((o1, o2) -> {
            return o1.end - o2.end;
        });

        int result = 0;
        for (int i = 0; i < list.size(); i++) {
            int cnt = 1;
            int left = list.get(i).end + 1000;

            for (int j = i + 1; j < list.size(); j++) {
                int right = list.get(j).start;
                if (right < left) {
                    cnt++;
                }
            }

            result = Math.max(result, cnt);
        }

        return result;
    }
}