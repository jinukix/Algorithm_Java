package 기능개발;

import java.util.ArrayList;

class Solution {

    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> list = new ArrayList<>();

        int n = 0;
        int time = 0;

        for (int i = 0; i < progresses.length; i++) {
            int t = (int) Math.ceil((100 - progresses[i]) / (double) speeds[i]);

            if (time < t) {
                if (n != 0) {
                    list.add(n);
                }
                time = t;
                n = 1;
            } else {
                n++;
            }
        }

        list.add(n);

        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};
        sol.solution(progresses, speeds);
    }
}