package 스티커_모으기2;

class Solution {
    public int solution(int[] sticker) {
        if (sticker.length == 1) return sticker[0];
        if (sticker.length == 2) return Integer.max(sticker[0], sticker[1]);

        int[] startDP = new int[sticker.length-1];
        int[] endDP = new int[sticker.length-1];

        startDP[0] = sticker[0];
        endDP[0] = sticker[1];


        startDP[1] = Integer.max(sticker[0], sticker[1]);
        endDP[1] = Integer.max(sticker[1], sticker[2]);

        for (int i = 2; i < sticker.length-1; i++) {
            startDP[i] = Integer.max(sticker[i]+startDP[i-2], startDP[i-1]);
            endDP[i] = Integer.max(sticker[i+1]+endDP[i-2], endDP[i-1]);
        }

        return Integer.max(startDP[sticker.length-2], endDP[sticker.length-2]);
    }
}
