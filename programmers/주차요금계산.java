package programmers;

import java.util.*;


class Solution {

    String[][] infos;
    Set<String> nums = new HashSet<>();
    Map<String, Integer> times = new HashMap<>();
    String[][] prices;

    public int[] solution(int[] fees, String[] records) {
        infos = new String[records.length][3];
        int idx = 0;
        for (String rec:records) {
            infos[idx] = rec.split(" ");
            nums.add(infos[idx][1]);
            idx++;
        }


        for (String num:nums) {
            String in =" ";
            //차량번호별 시간계산
            for (String[] info:infos) {
                if (info[1].equals(num)) {
                    if (info[2].equals("IN")) {
                        in = info[0];
                    }
                    else if(info[2].equals("OUT")) {
                        int time = calculTime(in, info[0]);
                        in = " ";
                        int curT = times.getOrDefault(num, 0);
                        times.put(num, curT+time);
                    }
                }

            }
            if (!in.equals(" ")){
                int time = calculTime(in, "23:59");
                int curT = times.getOrDefault(num, 0);
                times.put(num, curT+time);
            }
        }

        prices = new String[times.entrySet().size()][2];
        //요금계산
        idx = 0;
        for (Map.Entry<String, Integer> ent:times.entrySet()) {
            int time = ent.getValue();
            int price = fees[1];
            if (time>fees[0]) {
                int t2 = (time-fees[0])/fees[2];
                if ((time-fees[0])%fees[2] != 0) {
                    t2++;
                }
                price+=t2*fees[3];
            }
            prices[idx]=new String[]{ent.getKey(), String.valueOf(price)};
            idx++;
        }


        Arrays.sort(prices, (String[] s1, String[] s2) ->{return s1[0].compareTo(s2[0]);} );
        int[] answer = new int[prices.length];

        for (int i=0; i<prices.length; i++) {
            answer[i] = Integer.parseInt(prices[i][1]);
        }


        return answer;
    }

    int calculTime(String in, String out) {
        int v1=0;int v2 = 0;
        String[] ts1 = in.split(":");
        String[] ts2 = out.split(":");
        v1 = Integer.parseInt(ts1[0])*60+Integer.parseInt(ts1[1]);
        v2 = Integer.parseInt(ts2[0])*60+Integer.parseInt(ts2[1]);
        return v2-v1;
    }
}

/**


 **/
