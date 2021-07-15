package 스킬트리;

public class Solution {
    public int solution(String skill, String[] skillTrees) {
        int ans = skillTrees.length;

        for (String skillTree: skillTrees) {
            int cnt = 0;

            for (int i = 0; i < skillTree.length(); i++) {
                int idx = skill.indexOf(skillTree.charAt(i));
                if (idx == -1 || idx == cnt++) continue;
                else ans--; break;
            }
        }
        return ans;
    }
}
