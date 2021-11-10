package 퍼즐_조각_채우기;

import java.util.*;

class Block {

    int count;
    int h;
    int w;
    int[][] pieces;

    Block(int[][] piece, int w, int h, int count) {
        this.pieces = piece;
        this.w = w;
        this.h = h;
        this.count = count;
    }

    public void rotate() {
        int[][] newPieces = new int[w][h];

        for (int y = 0; y < w; y++) {
            for (int x = 0; x < h; x++) {
                newPieces[y][x] = pieces[h - 1 - x][y];
            }
        }

        int temp = w;
        w = h;
        h = temp;
        pieces = newPieces;
    }
}

class Solution {

    ArrayList<Block> blockList = new ArrayList<>();
    int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public Block findBlock(int[][] table, int y, int x, int findNum) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{y, x});
        table[y][x] = 2;

        int minY = y;
        int maxY = y;
        int minX = x;
        int maxX = x;
        int count = 1;

        while (!queue.isEmpty()) {
            int[] start = queue.poll();

            for (int i = 0; i < 4; i++) {
                int dy = start[0] + dir[i][0];
                int dx = start[1] + dir[i][1];

                if (0 <= dy && dy < table.length && 0 <= dx && dx < table.length
                    && table[dy][dx] == findNum) {
                    queue.add(new int[]{dy, dx});
                    table[dy][dx] = 2;
                    count++;

                    if (minY > dy) {
                        minY = dy;
                    }
                    if (minX > dx) {
                        minX = dx;
                    }
                    if (maxX < dx) {
                        maxX = dx;
                    }
                    if (maxY < dy) {
                        maxY = dy;
                    }
                }
            }
        }

        int h = maxY - minY + 1;
        int w = maxX - minX + 1;

        int[][] block = new int[h][w];

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (table[minY + i][minX + j] == 2) {
                    block[i][j] = 1;
                } else {
                    block[i][j] = 0;
                }
            }
        }

        return new Block(block, w, h, count);
    }

    public int solution(int[][] game_board, int[][] table) {
        int result = 0;
        for (int y = 0; y < table.length; y++) {
            for (int x = 0; x < table[y].length; x++) {
                if (table[y][x] == 1) {
                    blockList.add(findBlock(table, y, x, 1));
                }
            }
        }

        for (int y = 0; y < game_board.length; y++) {
            for (int x = 0; x < game_board[y].length; x++) {
                if (game_board[y][x] == 0) {
                    Block boardBlock = findBlock(game_board, y, x, 0);
                    loop:
                    for (Block tableBlock : blockList) {
                        if ((boardBlock.count != tableBlock.count) ||
                            !(boardBlock.w == tableBlock.w && boardBlock.h == tableBlock.h ||
                                boardBlock.w == tableBlock.h && boardBlock.h == tableBlock.w)) {
                            continue;
                        }

                        for (int i = 0; i < 4; i++) {
                            if (boardBlock.w == tableBlock.w && boardBlock.h == tableBlock.h) {
                                boolean isEquals = true;

                                loop2:
                                for (int yy = 0; yy < boardBlock.h; yy++) {
                                    for (int xx = 0; xx < boardBlock.w; xx++) {
                                        if (boardBlock.pieces[yy][xx]
                                            != tableBlock.pieces[yy][xx]) {
                                            isEquals = false;
                                            break loop2;
                                        }
                                    }
                                }

                                if (isEquals) {
                                    result += boardBlock.count;
                                    blockList.remove(tableBlock);
                                    break loop;
                                }
                            }

                            tableBlock.rotate();
                        }
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] game_board = {
            {1, 1, 0, 0, 1, 0},
            {0, 0, 1, 0, 1, 0},
            {0, 1, 1, 0, 0, 1},
            {1, 1, 0, 1, 1, 1},
            {1, 0, 0, 0, 1, 0},
            {0, 1, 1, 1, 0, 0}
        };
        int[][] table = {
            {1, 0, 0, 1, 1, 0},
            {1, 0, 1, 0, 1, 0},
            {0, 1, 1, 0, 1, 1},
            {0, 0, 1, 0, 0, 0},
            {1, 1, 0, 1, 1, 0},
            {0, 1, 0, 0, 0, 0}
        };
        sol.solution(game_board, table);
    }
}