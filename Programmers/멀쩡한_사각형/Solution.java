package 멀쩡한_사각형;

class Solution {
    public long solution(int w, int h) {
        return (long) w * h - (w + h - gcx(w, h));
    }

    public int gcx(int w, int h) {
        while (h > 0) {
            int temp = w % h;
            w = h;
            h = temp;
        }
        return w;
    }
}