package 수식_최대화;

import java.util.ArrayList;

class Solution {
    public long cal(long a, long b, char op){
        if (op == '+')
            return a + b;
        else if(op == '-')
            return a - b;
        else
            return a * b;
    }

    public void calc(ArrayList<Long> nums, ArrayList<Character> ops, char op){
        for(int i = 0; i < ops.size(); i++){
            if (ops.get(i) == op){
                long num1 = nums.get(i);
                long num2 = nums.get(i + 1);
                long result = cal(num1, num2, op);
                nums.remove(i);
                nums.remove(i);
                nums.add(i, result);
                ops.remove(i);
                i--;
            }
        }
    }

    public long operation(ArrayList<Long> numbers, ArrayList<Character> operators, String operation){
        ArrayList<Long> nums = new ArrayList<>(numbers);
        ArrayList<Character> ops = new ArrayList<>(operators);

        for (int i = 0; i < operation.length(); i++) {
            calc(nums, ops, operation.charAt(i));
        }

        return nums.get(0);
    }

    public long solution(String expression) {
        ArrayList<Long> numbers = new ArrayList<>();
        ArrayList<Character> operators = new ArrayList<>();
        String num = "";

        for (int i = 0; i < expression.length(); i++){
            if (expression.charAt(i) == '-' || expression.charAt(i) == '+' || expression.charAt(i) == '*'){
                operators.add(expression.charAt(i));
                numbers.add(Long.parseLong(num));
                num = "";
            } else {
                num += expression.charAt(i);
            }
        }
        numbers.add(Long.parseLong(num));

        String[] doOperations= {"+-*", "+*-", "-*+", "-+*", "*-+", "*+-"};

        long result = 0;
        for (String operation : doOperations) {
            result = Math.max(result, Math.abs(operation(numbers, operators, operation)));
        }

        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.solution("1+2-3*4-5+6-7*8");
    }
}