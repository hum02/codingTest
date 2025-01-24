package programmers;

class Solution {
    int[] seq;
    long max = 0L;

    int[] startM;
    int[] startP;
    public long solution(int[] sequence) {

        seq = sequence;
        startM = new int[seq.length];
        startP = new int[seq.length];


        for (int i=0; i<seq.length;i++) {
            if (i%2 ==0) {
                startM[i] = seq[i];
            } else {
                startM[i] = -seq[i];
            }

            max = Math.max(max,startM[i]);
        }

        for (int i=0; i<seq.length;i++) {
            if (i%2 ==0) {
                startP[i] = -seq[i];
            } else {
                startP[i] = seq[i];
            }
            max = Math.max(max,startP[i]);
        }

        long sum = 0L;
        for (int i=0; i<startM.length; i++) {
            sum+=startM[i];
            max = Math.max(max,sum);
            if (sum<0) {
                sum = 0;
            }
        }

        sum = 0L;
        for (int i=0; i<startM.length; i++) {
            sum+=startP[i];
            max = Math.max(max,sum);
            if (sum<0) {
                sum = 0;
            }
        }

//         for (int len =2; len<=seq.length; len++) {
//             long sumM = 0L;
//             long sumP = 0L;

//             int i = 0;
//             for (; i<len; i++) {
//                 sumM+=startM[i];
//                 sumP+=startP[i];
//                 max = Math.max(max, sumP);
//                 max = Math.max(max, sumM);
//             }

//             int end = len;
//             int start = 0;
//             for (; end<startM.length; ) {
//                 sumM+=startM[end];
//                 sumM-=startM[start];
//                 max = Math.max(max, sumM);

//                 sumP+=startP[end++];
//                 sumP-=startP[start++];
//                 max = Math.max(max, sumP);
//             }

        //인덱스 하나씩 옮겨가며 합을 구해 최댓값과 비교



        return max;
    }


}
/**
 부분수열 구하기 -> 1시작/-1시작 펄스 해서 합 구해보기

 **/
