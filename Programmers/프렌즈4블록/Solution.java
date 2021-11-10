package 프렌즈4블록;

import java.util.ArrayList;

class Solution {

    public int solution(int m, int n, String[] board) {
        ArrayList<Integer[]> list = new ArrayList<>();

        int result = 0;
        do {
            result += boomBlock(list, board);
            downBlock(board);

            for (int y = 0; y < m - 1; y++) {
                for (int x = 0; x < n - 1; x++) {
                    if (board[y].charAt(x) != '#') {
                        checkBlock(list, board, y, x);
                    }
                }
            }
        } while (!list.isEmpty());

        return result;
    }

    public void checkBlock(ArrayList<Integer[]> list, String[] board, int y, int x) {
        int[][] arr = {{y, x}, {y, x + 1}, {y + 1, x}, {y + 1, x + 1}};
        for (int i = 1; i < arr.length; i++) {
            if (board[y].charAt(x) != board[arr[i][0]].charAt(arr[i][1])) {
                return;
            }
        }

        for (int[] ints : arr) {
            list.add(new Integer[]{ints[0], ints[1]});
        }
    }

    public int boomBlock(ArrayList<Integer[]> list, String[] board) {
        int count = 0;
        for (Integer[] integers : list) {
            if (board[integers[0]].charAt(integers[1]) == '#') {
                continue;
            }

            char[] chars = board[integers[0]].toCharArray();
            chars[integers[1]] = '#';
            board[integers[0]] = String.valueOf(chars);
            count++;
        }
        list.clear();
        return count;
    }

    public void downBlock(String[] board) {
        for (int x = 0; x < board[0].length(); x++) {

            loop1:
            for (int y = board.length - 1; y > 0; y--) {
                if (board[y].charAt(x) == '#') {

                    for (int k = y - 1; k >= -1; k--) {
                        if (k == -1) {
                            break loop1;
                        }

                        if (board[k].charAt(x) != '#') {
                            char[] chars1 = board[k].toCharArray();
                            char[] chars2 = board[y].toCharArray();

                            char temp = chars1[x];
                            chars1[x] = chars2[x];
                            chars2[x] = temp;

                            board[k] = String.valueOf(chars1);
                            board[y] = String.valueOf(chars2);
                            break;
                        }
                    }
                }
            }
        }
    }
}