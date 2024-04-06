package baekjoon;

public class 신한23_1 {
    public static void main(String[] args) {
        System.out.println(findK(-5, 0));

    }

    static int findK(int min, int max) {
        int k = 1;
        if (min <0) {
            int reverseMin = -min;
            if (reverseMin != -1){
                int num=1;
                for(;num<reverseMin;) {
                    num*=2;
                    ++k;
                }
                if (max > num-1) {
                    for (;max>num-1;) {
                        num*=2;
                        ++k;
                    }
                }

                return k;
            }
            return k;

        }
        else {//min>=0
            int num=2;
            for(;max>num-1;) {
                num*=2;
                ++k;
            }
            return k;
        }
    }
}

/**
 * 배열에 대한 최소 k를 구하기
 *
 * **/