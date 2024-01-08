package programmers;

import java.util.*;

class Solution {
    String[] ord;
    Map<String, Integer> combiD = new HashMap<>();
    int[] maxs = new int[23];

    public String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        List<String> ans = new ArrayList<>();
        ord = new String[orders.length];

        int idx = 0;
        for (String order : orders) {
            char[] chars = order.toCharArray();
            Arrays.sort(chars);

            ord[idx] = String.valueOf(chars);
            idx++;
        }
        //orders돌며 2,3,4..개 조합 개수 세기

        for (int len : course) {
            for (String s:ord) {
                checkCombi(s,len, "");
            }
        }

        for (Map.Entry<String, Integer> ent:combiD.entrySet()) {
            if (maxs[ent.getKey().length()] == ent.getValue() && ent.getValue() >=2) {
                ans.add(ent.getKey());
            }
            answer = new String[ans.size()];
            int idx2 = 0;
            for (String s:ans) {
                answer[idx2] = s;
                idx2++;
            }
            Arrays.sort(answer);
        }



        return answer;
    }

    void checkCombi(String s, int len, String pick) {
        //s의 len길이의 조합들 개수 알아내기
        if (pick.length() == len) {
            int num = combiD.getOrDefault(pick, 0);
            combiD.put(pick, num+1);
            if (num+1 >=2 && num+1 > maxs[len] ) {
                maxs[len] = num+1;
            }
        }

        for (int i=0; i<s.length(); i++) {
            //뽑았던 거보다 큰거만 뽑기
            int plen = pick.length();
            if (plen > 0 && pick.charAt(plen-1) >= s.charAt(i)) {
                continue;
            }
            checkCombi(s, len, pick+s.charAt(i));
        }

    }
}

//조합 구하기 = 최소 2개, 2명이상이 주문
//배열에 2번 이상 나타난 n개의 조합 구하기
