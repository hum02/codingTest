package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj21921 {
    static int N, X;
    static int[] vs;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] ss = br.readLine().split(" ");
        N = Integer.valueOf(ss[0]);
        X = Integer.valueOf(ss[1]);

        String[] ss2 = br.readLine().split(" ");
        vs = new int[N];

        int zeroC = 0;
        for (int i=0; i<N;i++) {
            int n = Integer.valueOf(ss2[i]);
            vs[i] = n;
            if (n==0) {
                zeroC++;
            }
        }

        if (zeroC == N) {
            System.out.println("SAD");
            return;
        }

        int left = 0;
        int right = left+X-1;
        int sum = 0;
        int count = 1;
        for (int i=left; i<=right; i++) {
            sum+=vs[i];
        }
        int max = sum;
        right++;
        while(right < N) {
            sum-=vs[left];
            left++;
            sum+=vs[right];

            if (sum > max) {
                max = sum;
                count = 0;
            }
            if (max == sum) {
                count++;
            }
            right++;
        }

        System.out.println(max);
        System.out.println(count);
    }
}
