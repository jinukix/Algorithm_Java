package 크레인_인형뽑기_게임;

import java.util.Stack;

class Solution {
    public int solution(int[][] board, int[] moves) {
        Stack<Integer> stack = new Stack<Integer>();
        int length = board.length;
        int ans = 0;
        for (int move: moves) {
            for (int i = 0; i < length; i++) {
                if (board[i][move-1] != 0) {
                    if (stack.size() != 0 && stack.peek() == board[i][move-1]) {
                        ans += 2;
                        stack.pop();
                    } else {
                        stack.add(board[i][move-1]);
                    }
                    board[i][move-1] = 0;
                    break;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] board = {
                {0,0,0,0,0},
                {0,0,1,0,3},
                {0,2,5,0,1},
                {4,2,4,4,2},
                {3,5,1,3,1}
        };
        int[] moves = {1,5,3,5,1,2,1,4};
        Solution sol = new Solution();
        System.out.println(sol.solution(board, moves));
    }

}