package programmers;

import java.util.*;

class Solution {
    static int[] ord;
    static Stack<Integer> stk = new Stack<>();
    static int conv = 1;
    static int ans = 0;

    public int solution(int[] order) {
        ord = order;
        stk.push(0);

        for (int i=0; i<ord.length; i++) {

            if (ord[i] != conv) {

                if (ord[i] == stk.peek()) {
                    ans++;
                    stk.pop();
                    continue;
                }

                if (ord[i] > conv) {
                    //보조 벨트에 넣기
                    while (conv != ord[i]) {
                        stk.push(conv);
                        conv++;
                    }
                    ans++;
                    conv++;
                    continue;
                }
                return ans;

            } else {
                ans++;
                conv++;
            }

        }

        return ans;
    }
}

/**
 5/25분 시작
 1....n의 상자

 이를 택배 배달 순서대로 싣기

 보조 컨테이너 벨트 - 가장 마지막에 놨던 상자부터 꺼냄

 보조 컨테이너 벨트이용해도 순서대로 못하면, 상자 싣지 않음


 4,3,1,2,5
 **/