package programmers;

import java.util.*;

class Solution {
    int[][] b;
    int[][] dp;
    int e;

    class Point {
        int num,count;
        Point(int num, int count) {
            this.num = num;
            this.count = count;
        }
    }

    public int[] solution(int e, int[] starts) {
        int[] answer = new int[starts.length];
        Point[] ps = new Point[e+1];

        for (int i=0; i<=e; i++) {
            ps[i] = new Point(i, 0);
        }

        for (int i=1; i<=e; i++) {
            for (int j = i; j<=e; j+=i) { //j의 배수 체크하기
                ps[j].count++;
            }
        }

        //point를 count 많은 순, 숫자가 작은 순으로 정렬
        Arrays.sort(ps, (Point p1, Point p2) -> {
            if (p1.count == p2.count) {
                return p1.num-p2.num;
            }
            return p2.count-p1.count;
        });

        for(int i=0; i<starts.length; i++) {
            int start = starts[i];
            for (Point p:ps) {
                if (p.num>=start) {
                    answer[i] = p.num;
                    break;
                }
            }
        }

        return answer;
    }


}

/**

 **/
