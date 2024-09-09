package programmers;

import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        List<Stage> failR = new ArrayList<>();

        //n번 스테이지
        for (int n = 1; n<=N; n++) {
            int total = 0;
            int stop = 0;
            //각 사용자 위치
            for (int i = 0; i<stages.length; i++) {
                if (stages[i]>n) {
                    total++;
                }
                if (stages[i] == n) {
                    total++;
                    stop++;
                }
            }
            if (total ==0) {
                failR.add(new Stage(n, 0));
            } else {

                failR.add(new Stage(n,(double)stop/total));
            }
        }

        Collections.sort(failR, (Stage a, Stage b) -> {
            // {1,1,8}
            // {5,0,1}

            int dif = Double.compare(b.failure, a.failure);
            if (dif == 0) {
                return a.stage-b.stage;
            }else {
                return dif;
            }
        });

        int idx =0;
        for (int i=0; i<failR.size(); i++) {
            Stage st =failR.get(i);
            answer[idx++] = st.stage;
        }

        return answer;
    }
}

class Stage {
    public int stage;
    public double failure;

    public Stage(int stage, double failure) {
        this.stage = stage;
        this.failure = failure;
    }
}

/**

 - 스테이지별 실패율 구하기 - 어렵지 않다.
 - 실패율이 높은 순으로 스테이지 번호를 정렬
 소수점의 비교. double로 캐스팅 해야 한다.
 <클래스>컬렉션에 대해서도 sort()의 비교함수를 정의할 수 있다. 다만 리턴값을 COmpare()함수를 써서 만드는게 좋겠다.
 **/
