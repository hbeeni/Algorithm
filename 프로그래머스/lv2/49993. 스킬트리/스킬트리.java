import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < skill.length(); i++) {
            set.add(skill.charAt(i));
        }

        int answer = 0;
        for (String skillTree : skill_trees) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < skillTree.length(); i++) {
                if (set.contains(skillTree.charAt(i))) {
                    sb.append(skillTree.charAt(i));
                }
            }

            String str = sb.toString();
            if (str.equals("") || str.startsWith(String.valueOf(skill.charAt(0))) && skill.contains(str)) {
                answer++;
            }
        }

        return answer;
    }
}