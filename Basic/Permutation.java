import java.util.Arrays;

// 순열
public class Permutation {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        int[] output = new int[arr.length];
        boolean[] visited = new boolean[arr.length];

        permutation(arr, output, visited, 0, arr.length, 3);
    }

    static void permutation(int[] arr, int[] output, boolean[] visited, int depth, int n, int r) {
        if (depth == r) {
            System.out.println(Arrays.toString(output));
            return;
        }

        // 방법1. visited
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[depth] = arr[i];
                permutation(arr, output, visited, depth + 1, n, r);
                output[depth] = 0; // 없어도 되긴 함.
                visited[i] = false;
            }
        }

        // 방법2. swap
//        for (int i = depth; i<n; i++) {
//            swap(arr, depth, i);
//            permutation(arr, visited, depth + 1, n, r);
//            swap(arr, depth, i);
//        }
    }
}

/*
[1, 2, 3]
[1, 3, 2]
[2, 1, 3]
[2, 3, 1]
[3, 1, 2]
[3, 2, 1]
 */