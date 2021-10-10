package 다단계_칫솔_판매;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

class Employee {
    Employee parent;
    ArrayList<Employee> child;
    String name;
    int money;

    Employee(String name) {
        this.name = name;
        child = new ArrayList<>();
    }
}

public class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        HashMap<String, Employee> map = new HashMap<>();
        Employee root = new Employee("ROOT");

        for (int i = 0; i < enroll.length; i++) {
            Employee newEmployee = new Employee(enroll[i]);
            map.put(enroll[i], newEmployee);

            if (referral[i].equals("-")) {
                newEmployee.parent = root;
                root.child.add(newEmployee);
            } else {
                Employee parent = map.get(referral[i]);
                newEmployee.parent = parent;
                parent.child.add(newEmployee);
            }
        }

        for (int i = 0; i < seller.length; i++) {
            Employee employee = map.get(seller[i]);
            int interest = amount[i] * 100;
            int total;

            while (employee.parent != null) {
                total = interest;
                interest = total/10;
                employee.money += (total - interest);
                employee = employee.parent;
            }
        }

        int[] result = new int[enroll.length];
        for (int i = 0; i < enroll.length; i++) {
            result[i] = map.get(enroll[i]).money;
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(
                new String[]{"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"},
                new String[]{"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"},
                new String[]{"young", "john", "tod", "emily", "mary"},
                new int[] {12,4,2,5,10}
        )));
    }
}
