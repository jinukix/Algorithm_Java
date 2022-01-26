package 양궁대회;

import java.util.ArrayList;
import java.util.Arrays;

class Solution {

    int max = 0;
    ArrayList<int[]> resultList = new ArrayList<>();

    public void dfs(int[] info, int[] myInfo, int cnt, int idx, int score, int targetScore) {
        if (cnt < 0 || 10 < idx) {
            return;
        }

        if (targetScore < score && max <= (score - targetScore)) {
            if (max < score - targetScore) {
                resultList.clear();
            }
            this.max = score - targetScore;

            if (cnt != 0) {
                int[] copy = myInfo.clone();
                for (int i = 10; i >= 0; i--) {
                    if (copy[i] == 0) {
                        copy[i] = cnt;
                        break;
                    }
                }
            } else {
                resultList.add(myInfo);
            }
        }

        // win
        if (info[idx] + 1 <= cnt) {
            int[] copy = myInfo.clone();
            copy[idx] = info[idx] + 1;

            if (info[idx] == 0) {
                dfs(info, copy, cnt - info[idx] - 1, idx + 1, score + (10 - idx),
                    targetScore);
            } else {
                dfs(info, copy, cnt - info[idx] - 1, idx + 1, score + (10 - idx),
                    targetScore - (10 - idx));
            }
        }

        // lose
        dfs(info, myInfo, cnt, idx + 1, score, targetScore);
    }

    public int[] solution(int n, int[] info) {
        int targetScore = 0;
        for (int i = 0; i < info.length; i++) {
            if (0 < info[i]) {
                targetScore += (10 - i);
            }
        }
        int[] myInfo = new int[info.length];
        dfs(info, myInfo, n, 0, 0, targetScore);

        if (resultList.isEmpty()) {
            return new int[]{-1};
        }

        resultList.sort((o1, o2) -> {
            for (int i = 10; i >= 0; i--) {
                if (o1[i] != o2[i]) {
                    return o2[i] - o1[i];
                }
            }
            return 0;
        });

        return resultList.get(0);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(
            Arrays.toString(sol.solution(1, new int[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0})));
    }
}