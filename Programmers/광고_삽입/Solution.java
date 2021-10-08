package 광고_삽입;

class Solution {
    public int convert(String time) {
        String[] times = time.split(":");
        return (Integer.parseInt(times[0]) * 3600) + (Integer.parseInt(times[1]) * 60) + (Integer.parseInt(times[2]));
    }

    public String convert(int time) {
        String t = (time / 3600) + "";
        time%=3600;

        String m = (time / 60) + "";
        String s = (time % 60) + "";

        if (t.length() == 1) t = "0" + t;
        if (m.length() == 1) m = "0" + m;
        if (s.length() == 1) s = "0" + s;

        return String.join(":", t,m,s);
    }

    public String solution(String play_time, String adv_time, String[] logs) {
        int playTime = convert(play_time);
        int advTime = convert(adv_time);
        int[] counts = new int[playTime+1];

        for (String log: logs) {
            String[] splits = log.split("-");
            int startViewTime = convert(splits[0]);
            int endViewTime = convert(splits[1]);

            for (int i = startViewTime; i < endViewTime; i++) {
                counts[i]++;
            }
        }

        int startTime = 0;
        int endTime = advTime;
        long sum = 0;
        for (int i = startTime; i < endTime; i++) {
            sum += counts[i];
        }

        long max = sum;
        int maxStartTime = 0;
        while (endTime < playTime) {
            sum -= counts[startTime];
            sum += counts[endTime];

            if (sum > max) {
                max = sum;
                maxStartTime = startTime+1;
            }

            startTime++;
            endTime++;
        }

        return convert(maxStartTime);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(
                "02:03:55", "00:14:15", new String[] {
                    "01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29", "01:37:44-02:02:30"
                }
        ));
    }
}