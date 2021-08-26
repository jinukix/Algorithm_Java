package 자물쇠와_열쇠;

import java.util.ArrayList;
import java.util.Arrays;

class Block {
    int[][] pieces;
    int count;
    int h;
    int w;

    Block(int[][] peaces, int count, int h, int w) {
        this.pieces = peaces;
        this.count = count;
        this.h = h;
        this.w = w;
    }

    public void rotate() {
        int[][] newPieces = new int[w][h];

        for (int y = 0; y < w; y++) {
            for (int x = 0; x < h; x++) {
                newPieces[y][x] = pieces[h-1-x][y];
            }
        }

        int temp = w;
        w = h;
        h = temp;
        pieces = newPieces;
    }
}

class Solution {
    public Block getLockBlock(int[][] lock) {
        int minY = lock.length;
        int minX = lock.length;
        int maxY = 0;
        int maxX = 0;

        ArrayList<int[]> list = new ArrayList<>();
        boolean isEmpty = true;

        for (int y = 0; y < lock.length; y++) {
            for (int x = 0; x < lock.length; x++) {
                if (lock[y][x] == 0) {
                    isEmpty = false;
                    list.add(new int[] {y, x});

                    if (y<minY) minY = y;
                    if (x<minX) minX = x;
                    if (y>maxY) maxY = y;
                    if (x>maxX) maxX = x;
                }
            }
        }

        if (isEmpty) return null;

        int w = maxX-minX+1;
        int h = maxY-minY+1;
        int[][] pieces = new int[h][w];

        for (int i = 0; i < pieces.length; i++) {
            Arrays.fill(pieces[i], 1);
        }

        for (int[] pos: list) {
            pos[0] -= minY;
            pos[1] -= minX;
            pieces[pos[0]][pos[1]] = 0;
        }

        return new Block(pieces, list.size(),maxY-minY+1, maxX-minX+1);
    }

    public Block findBlock(int targetBlockH, int targetBlockW, int targetBlockCount, int[][] key, int startY, int startX) {
        int[][] pieces = new int[targetBlockH][targetBlockW];
        int count = 0;
        for (int y = 0; y < targetBlockH; y++) {
            for (int x = 0; x < targetBlockW; x++) {
                if (key[startY+y][startX+x] == 1) count++;
                pieces[y][x] = key[startY+y][startX+x] == 1 ? 0 : 1;
            }
        }

        if (count != targetBlockCount) {
            return null;
        } else {
            return new Block(pieces, count, targetBlockH, targetBlockW);
        }
    }

    public boolean checkBlock(Block lockBlock, Block keyBlock) {
        if (keyBlock == null) return false;
        for (int j = 0; j < 4; j++) {
            keyBlock.rotate();
            if (Arrays.deepEquals(keyBlock.pieces, lockBlock.pieces)) {
                return true;
            }
        }
        return false;
    }

    public boolean solution(int[][] key, int[][] lock) {
        Block lockBlock = getLockBlock(lock);

        if (lockBlock == null) return true;
        if (key.length < lockBlock.h || key.length < lockBlock.w) return false;

        for (int y = 0; y < key.length; y++) {
            for (int x = 0; x < key.length; x++) {
                if (y + lockBlock.h <= key.length && x + lockBlock.w <= key.length) {
                    Block keyBlock = findBlock(lockBlock.h, lockBlock.w, lockBlock.count, key, y, x);
                    if (checkBlock(lockBlock, keyBlock)) return true;
                }

                if (y + lockBlock.w <= key.length && x + lockBlock.h <= key.length) {
                    Block keyBlock = findBlock(lockBlock.w, lockBlock.h, lockBlock.count, key, y, x);
                    if (checkBlock(lockBlock, keyBlock)) return true;
                }
            }
        }
        return false;
    }
}
