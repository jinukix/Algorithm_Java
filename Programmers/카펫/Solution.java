package 카펫;

class Solution {

    public int[] solution(int brown, int yellow) {
        int area = brown + yellow;

        for (int x = 3; x < area / 3 + 1; x++) {
            for (int y = 3; y <= x; y++) {
                if (area == y * x && (brown == (y * 2) + (x - 2) * 2) && (yellow == (x - 2) * (y
                    - 2))) {
                    return new int[]{x, y};
                }
            }
        }

        return null;
    }
}