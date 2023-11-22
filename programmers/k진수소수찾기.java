import java.util.*;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        //n을 k진수로 변환

        // int c = 0;
        // int number = 1;
        // while (number < n) {
        //     number *=k;
        //     c++;
        // }
        //k진수는 c+1자리의 수

        ArrayList<Integer> ret = new ArrayList();
        while(n > 0){
            ret.add(n % k);
            n /= k;
        }
        Collections.reverse(ret);

//        int tmpn = n;
//        int[] karr = new int[c];
//        int idx = 0;
        // for (int i=c-1; i>=0; i--) {
        //     int curN = (int)Math.pow(k,i);
        //     if (curN <= tmpn) {
        //         karr[idx] = tmpn/curN;
        //     }
        //     tmpn-=curN*karr[idx];
        //     idx++;
        // }
//        for (int i = c - 1; i >= 0; i--) {
//            int curN = (int)Math.pow(k, i);
//            if (curN <= tmpn) {
//                karr[idx] = tmpn / curN;
//                tmpn -= curN * karr[idx];
//            }
//            idx++;
//        }

        // for (int i=0; i<karr.length; i++) {
        //     System.out.print(karr[i]);
        // }
        // System.out.println();

        //0혹은 끝에서부터 하나씩 이동하며 쌓아가다 0이나 끝 발견하면 소수인지 검사
        Queue<Integer> num = new LinkedList<>();
        for (int i = 0; i < ret.size(); i++) {

            if (i == ret.size()-1) {

                if (ret.get(i) != 0) {
                    num.add(ret.get(i));
                }
                if (isPrime(num)) {
                    answer++;
                }
                break;
            }

            //0이면 쌓아온 거 소수 검사하고 비우기
            if (ret.get(i) == 0) {
                if (isPrime(num)) {
                    answer++;
                }
                num.clear();
                continue;
            }

            num.add(ret.get(i));
        }
        return answer;
    }

    boolean isPrime(Queue<Integer> num) {
        StringBuilder sb = new StringBuilder();
        for (int n :num) {
            sb.append(n);
        }
        if (sb.toString().isEmpty()) {return false;}
        long candi = Long.valueOf(sb.toString());

        if (candi == 2) {return true;}
        if (candi <= 1) {return false;}
        for (long i=2; i*i<=candi; i++) {
            if (candi%i == 0) {
                return false;
            }
        }

        return true;
    }
}