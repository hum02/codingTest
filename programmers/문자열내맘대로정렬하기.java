package programmers;

import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        String[] answer = new String[strings.length];
        Map<Character, List<Integer>> infos = new HashMap<>();
        List<Character> cs = new ArrayList<>();

        for(int i=0; i<strings.length; i++) {
            char c = strings[i].charAt(n);
            if (!cs.contains(c)) {
                cs.add(c);
            }

            List<Integer> idxs = infos.getOrDefault(c,new ArrayList<>());
            idxs.add(i);
            infos.put(c, idxs);

        }

        Collections.sort(cs);

        int cnt = 0;
        for(int i=0; i<cs.size(); i++) {
            List<Integer> idxs = infos.get(cs.get(i));
            if (idxs.size() ==1) {
                answer[cnt] = strings[idxs.get(0)];
                cnt++;
            }
            else {
                List<String> ss = new ArrayList<>();
                for(int idx:idxs) {
                    ss.add(strings[idx]);
                }
                Collections.sort(ss);
                for(String s:ss) {
                    answer[cnt] = s;
                    cnt++;
                }
            }

        }


        return answer;
    }
}
