package programmers;

import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        long left = 0, right = ((long)n)*times[times.length-1];
        long mid = 0;

        while (left<=right) {

            mid = (left+right)/2;

            long fin = 0;
            for (int i=0; i<times.length; i++) {
                fin+=mid/times[i];
            }

            if (fin < n) {
                left = mid+1;
            }
            else {
                answer = mid;
                right = mid-1;
            }

        }

        return answer;
    }
}


