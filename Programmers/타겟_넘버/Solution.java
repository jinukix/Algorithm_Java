package 타겟_넘버;

class Solution {

    int result = 0;

    public void dfs(int[] numbers, int target, int value, int idx) {
        if (numbers.length == idx) {
            if (value == target) {
                result++;
            }
            return;
        }

        dfs(numbers, target, value + numbers[idx], idx + 1);
        dfs(numbers, target, value - numbers[idx], idx + 1);
    }

    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);
        return result;
    }
}