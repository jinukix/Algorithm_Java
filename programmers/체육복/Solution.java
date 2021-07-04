package 체육복;

import java.util.Arrays;

public class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] students = new int[n];
        Arrays.fill(students, 1);
        int ans = 0;

        for (int i : lost) {
            students[i-1]--;
        }

        for (int i : reserve) {
            students[i-1]++;
        }

        for (int i = 0; i < n; i++) {
            if (students[i] == 0) {
                if(i!=0 && students[i-1]==2) {
                    students[i]++;
                    students[i-1]--;
                } else if (i!=n-1 && students[i+1]==2) {
                    students[i]++;
                    students[i+1]--;
                }
            }

            if (students[i] != 0) {
                ans++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] lost = {1, 3, 5};
        int[] reverse = {2,4};

        Solution sol = new Solution();
        int ans = sol.solution(5, lost, reverse);
        System.out.println(ans);
    }
}


/*

Arrays.fill(students, 1);

def solution(n, lost, reserve):
    for i in range(n):
        if student[i] == 0:

            if i != 0 and student[i-1] == 2:
                student[i] += 1
                student[i-1] -= 1
            elif i != n-1 and student[i+1] == 2:
                student[i] += 1
                student[i+1] -= 1

        # print(student)

        if student[i] != 0:
            answer += 1

    return answer


 */