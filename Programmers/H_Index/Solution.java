package H_Index;

public class Solution {
    public int solution(int[] citations) {
        int result = 0;
        for (result = citations.length; result >= 0; result--) {
            int downCount = 0;
            int upCount = 0;

            for (int i = 0; i < citations.length; i++) {
                if (citations[i] >= result) upCount++;
                else downCount++;
            }

            if (upCount >= result && result >= downCount) break;
        }

        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] citations = {6,6,6,6,6,1};
        System.out.println(sol.solution(citations));
    }
}
