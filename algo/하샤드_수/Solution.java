package 하샤드_수;

class Solution {
    public boolean solution(int x) {
        String str = Integer.toString(x);
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            sum += Integer.parseInt(String.valueOf(str.charAt(i)));
        }

        return x % sum == 0;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        boolean ans = sol.solution(123456789);
        System.out.println(ans);

    }


}

/*

def solution(x):
    str_x= str(x)

    a = sum([int(str_x[i]) for i in range(len(str_x))])

    if x % a == 0:
        return True
    return False

 */