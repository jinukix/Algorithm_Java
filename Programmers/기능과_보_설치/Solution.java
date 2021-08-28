package 기능과_보_설치;

import java.util.LinkedList;
import java.util.Objects;

class Build {
    int x;
    int y;
    int isFloor;

    Build (int x, int y, int isFloor) {
        this.x = x;
        this.y = y;
        this.isFloor = isFloor;
    }

    Build (int[] frame) {
        this(frame[0], frame[1], frame[2]);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Build build = (Build) o;
        return x == build.x && y == build.y && isFloor == build.isFloor;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, isFloor);
    }

    public int[] toArray() {
        return new int[]{this.x, this.y, this.isFloor};
    }
}

class Solution {
    LinkedList<Build> list = new LinkedList<>();

    public void removeBuild(Build build, int n) {
        list.remove(build);

        for (int i = 0; i < list.size(); i++) {
            if (!isInstallAvailable(list.get(i), n)) {
                list.addFirst(build);
                break;
            }
        }
    }

    public boolean isInstallAvailable(Build build, int n) {
        if (build.isFloor == 1) {
            if (0 <= build.y && build.y <= n && 0 <= build.x && build.x < n) {
                Build build1 = new Build(build.x, build.y-1,0);
                Build build2 = new Build(build.x+1, build.y-1,0);

                if (list.contains(build1) || list.contains(build2)) return true;

                build1 = new Build(build.x-1, build.y,1);
                build2 = new Build(build.x+1, build.y,1);

                return (list.contains(build1) && list.contains(build2));
            }
        } else {
            if (0 <= build.y && build.y < n && 0 <= build.x && build.x <= n) {
                if (build.y == 0) return true;

                Build build1 = new Build(build.x-1, build.y,1);
                Build build2 = new Build(build.x, build.y,1);
                if (list.contains(build1) || list.contains(build2)) return true;

                build1 = new Build(build.x, build.y-1,0);
                return list.contains(build1);
            }
        }

        return false;
    }

    public int[][] solution(int n, int[][] buildFrame) {
        for (int[] frame : buildFrame) {
            Build build = new Build(frame);

            if (frame[3] == 0) {
                removeBuild(build, n);
            } else if (isInstallAvailable(build, n)) {
                list.addFirst(build);
            }
        }

        list.sort((o1, o2) -> {
            if (o1.x == o2.x) {
                if (o1.y == o2.y) {
                    return o1.isFloor - o2.isFloor;
                }
                return o1.y - o2.y;
            }
            return o1.x - o2.x;
        });

        int l = list.size();
        int[][] result = new int[l][];
        for (int i = 0; i < l; i++) {
            Build build = list.pollFirst();
            if (build != null) {
                result[i] = build.toArray();
            }
        }

        return result;
    }
}