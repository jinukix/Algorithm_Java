package 방금_그곡;

public class Solution {
    private String editMelody(String str) {
        str = str.replaceAll("C#", "c");
        str = str.replaceAll("D#", "d");
        str = str.replaceAll("F#", "f");
        str = str.replaceAll("G#", "g");
        str = str.replaceAll("A#", "a");
        return str;
    }
    public String solution(String m, String[] musicinfos) {
        String ans = "(None)";
        int maxLength = 0;

        m = editMelody(m);
        for (String str: musicinfos) {
            String[] strs = str.split(",");

            String[] startStr = strs[0].split(":");
            String[] endStr = strs[1].split(":");

            int time = (Integer.parseInt(endStr[0]) - Integer.parseInt(startStr[0]) * 60)
                    + Integer.parseInt(endStr[1]) - Integer.parseInt(startStr[1]);

            strs[3] = editMelody(strs[3]);
            String melody = strs[3].repeat(time / strs[3].length()) + strs[3].substring(0, time%strs[3].length());

            if (melody.contains(m) && melody.length() > maxLength) {
                maxLength = melody.length();
                ans = strs[2];
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        String m = "CC#BCC#BCC#BCC#B";
        String[] musicinfos = {"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"};

        Solution solution = new Solution();
        System.out.println(solution.solution(m, musicinfos));
    }
}
