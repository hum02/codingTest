package programmers;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = skill_trees.length;

        char[] sk = skill.toCharArray();
        for (String sk_tree :skill_trees) {
            int idx = 0;
            char[] tree_arr = sk_tree.toCharArray();
            boolean fail = false;

            for (char cur_sk :tree_arr) {
                int cur_pos = skill.indexOf(cur_sk);
                if (cur_pos == -1) {
                    continue;
                }
                if (cur_pos == idx) {
                    idx++;
                    continue;
                } else {
                    fail = true;
                    answer--;
                    break;
                }
            }

            if (fail) {continue;}

        }

        return answer;
    }
}


