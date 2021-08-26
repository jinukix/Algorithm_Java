package 기지국_설치;

public class Solution {
    public int solution(int n, int[] stations, int w) {
        int result = 0;
        int location = 1;
        int stationIdx = 0;

        while (location <= n) {
            if (stations.length > stationIdx && stations[stationIdx]-w <= location) {
                location = stations[stationIdx++]+w+1;
            } else {
                location += 2 * w + 1;
                result++;
            }
        }

        return result;
    }
}
