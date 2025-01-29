package programmers;

import java.util.*;

class Solution {

    Map<String, Set<String>> attack = new HashMap<>();
    Map<String, Integer> userIdx = new HashMap<>();
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        //id별 인덱스 기록
        for (int i=0; i<id_list.length;i++) {
            userIdx.put(id_list[i], i);
        }

        //신고받은 아이디들 종합
        for (String r:report) {
            String[] r2 = r.split(" ");
            String victim = r2[1];
            Set<String> attackers = attack.getOrDefault(victim, new HashSet<>());
            attackers.add(r2[0]);
            attack.put(victim, attackers);
        }

        //k회 이상 신고받은 것들 돌면서, 메일 개수 종합
        for (Map.Entry<String, Set<String>> at:attack.entrySet()) {
            String s1 = at.getKey();
            Set<String> attackers = at.getValue();
            if (attackers.size() >= k) {
                for (String atUser :attackers) {
                    int idx = userIdx.getOrDefault(atUser,-1);
                    answer[idx]++;
                }
            }
        }

        return answer;
    }
}
/**
 2번 신고당하면, 해당 신고를 한 유저에게 메일을 보냄. 각 유저가 받은 메일 회수는?
 **/
