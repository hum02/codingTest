package programmers;

class Solution {
    int[] buy;
    int answer = 0;

    public int solution(String[] want, int[] number, String[] discount) {

        buy = new int[number.length];

        int day = 0;
        for (int i=day; i<day+10; i++) {
            for (int j=0; j<want.length;j ++) {
                if(want[j].equals(discount[i])) {
                    buy[j]++;
                }
            }
        }
        comp(number);

        day++;
        for (; day+9<=discount.length-1;day++) {
            //예전거 빼고, 새로운 거 더하기
            for (int i=0; i<want.length; i++) {
                if (discount[day-1].equals(want[i])) {
                    buy[i]--;
                }
                if (discount[day+9].equals(want[i])) {
                    buy[i]++;
                }
            }

            comp(number);
        }

        return answer;
    }

    void comp(int[] number) {
        boolean cor = true;

        for (int i=0; i< buy.length; i++) {
            if (buy[i]<number[i]) {
                cor = false;
                break;
            }
        }

        if (cor) {
            answer++;
        }
    }
}

/**

 디스카운트 품목을 원하는 만큼 살 수 있는 날짜의 개수

 슬라이딩 하며 buy갱신.
 buy가 만족하면 anwer++;

 **/
