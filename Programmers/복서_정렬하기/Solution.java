package 복서_정렬하기;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;

class Player implements Comparable<Player> {
    int idx;
    int weight;
    Float winRate;
    int heavierWinCnt;

    Player (int idx, int weight, float winRate, int heavierWinCnt) {
        this.idx = idx;
        this.weight = weight;
        this.winRate = winRate;
        this.heavierWinCnt = heavierWinCnt;
    }

    @Override
    public int compareTo(Player o) {
        if (Objects.equals(winRate, o.winRate)) {
            if (heavierWinCnt == o.heavierWinCnt) {
                if (weight == o.weight) {
                    return idx - o.idx;
                }
                return o.weight - weight;
            }
            return o.heavierWinCnt - heavierWinCnt;
        }
        return o.winRate.compareTo(winRate);
    }
}

class Solution {
    public int[] solution(int[] weights, String[] head2head) {
        ArrayList<Player> playes = new ArrayList<>();
        for (int i = 0; i < weights.length; i++) {
            int winCnt = 0;
            int totalCnt = 0;
            int heavierWinCnt = 0;

            char[] charArr = head2head[i].toCharArray();
            for (int j = 0; j < charArr.length; j++) {
                char ch = charArr[j];

                if (ch != 'N') totalCnt++;
                if (ch == 'W') {
                    winCnt++;
                    if (weights[i] < weights[j]) {
                        heavierWinCnt++;
                    }
                }
            }

            float winRate;
            if (totalCnt == 0) {
                winRate = 0f;
            } else {
                winRate = (float) winCnt / totalCnt;
            }

            playes.add(new Player(i+1, weights[i], winRate, heavierWinCnt));
        }
        Collections.sort(playes);

        int[] result = new int[playes.size()];
        for (int i = 0; i < playes.size(); i++) {
            result[i] = playes.get(i).idx;
        }

        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.solution(new int[]{50, 82, 75, 120}, new String[]{"NLWL", "WNLL", "LWNW", "WWLN"})));
    }
}