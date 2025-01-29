package programmers;

import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer = {};
        List<Integer> ans = new ArrayList<>();
        Map<String , Integer> typeTime = new HashMap<>();
        for (String t:terms) {
            String[] t2 = t.split(" ");
            typeTime.put(t2[0], Integer.parseInt(t2[1]));
        }


        for (int i =0; i<privacies.length;i++) {
            String cur = privacies[i];

            String[] info = cur.split(" ");
            String type = info[1];
            String start = info[0];

            //타입에 따라 끝나는 날짜 계산, 현재 날짜보다 작으면 파기하기
            String fDate = finishDate(start, typeTime.get(type));
            if (isSmallDate(fDate, today)) {//만료일이 오늘보다 이른날짜인가
                ans.add(i+1);
            }
        }


        return ans.stream().mapToInt((Integer i)-> {return i;}).toArray();
    }
    String finishDate(String start, int month) {
        String[] ss = start.split("\\.");

        int curM = Integer.parseInt(ss[1]);
        int nextM = curM+month;
        if (nextM>12) {
            //년도,월 갱신
            return
                    String.valueOf( Integer.parseInt(ss[0])+(nextM-1)/12 ) +"."
                            + String.valueOf((nextM-1)%12+1) +"."
                            + ss[2];

        } else {
            //월만 갱신
            return ss[0]+"."+String.valueOf(nextM)+"."+ss[2];
        }

    }

    boolean isSmallDate(String fin, String today) {
        String[] fs = fin.split("\\.");
        String[] ts = today.split("\\.");
        if (Integer.parseInt(fs[0]) < Integer.parseInt(ts[0]) ) {
            return true;
        } else if (Integer.parseInt(fs[0]) > Integer.parseInt(ts[0])) {
            return false;
        }
        if (Integer.parseInt(fs[1]) < Integer.parseInt(ts[1]) ) {
            return true;
        } else if (Integer.parseInt(fs[1]) > Integer.parseInt(ts[1])) {
            return false;
        }

        if (Integer.parseInt(fs[2]) <= Integer.parseInt(ts[2]) ) {
            return true;
        }

        return false;
    }
}
/**
 달은 28일까지
 유효기간이 지난 정보인지 지금 날짜와 비교해 판단하기
 **/
