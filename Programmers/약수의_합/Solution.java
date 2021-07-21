package 약수의_합;

public class Solution {
    public int solution(int n) {
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (n %i == 0){
                ans += i;
            }
        }

        return ans;
    }


    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(12));
    }
}


/*

def solution(n):
    ans = []
    for i in range(1, n+1):
        if n % i == 0:
            ans.append(i)

    return sum(ans)

 */