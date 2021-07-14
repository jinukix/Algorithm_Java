package 스킬트리;

public class Solution {
    public int solution(String skill, String[] skillTrees) {
        int ans = skillTrees.length;

        for (String skillTree: skillTrees) {
            int cnt = 0;

            for (int i = 0; i < skillTree.length(); i++) {
                int idx = skill.indexOf(skillTree.charAt(i));
                if (idx == -1 || idx == cnt++) continue;

                ans--;
                break;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String skill = "CBD";
        String[] skillTrees = {"BACDE", "CBADF", "AECB", "BDA"};
        System.out.println(sol.solution(skill, skillTrees));
    }
}
