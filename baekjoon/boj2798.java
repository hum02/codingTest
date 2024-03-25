package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj2798 {
    static int N,M;
    static int[] nums;
    static int ans =0;
    static int[] picked = new int[3];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        nums = new int[N];

        String[] s2 = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(s2[i]);
        }

        perm(0,0);
        System.out.println(ans);
    }

    static void perm(int count, int start) {
        if (count == 3) {
            int sum = 0;
            for (int i = 0; i < 3; i++) {
                sum+=picked[i];
            }
            if (sum > M) {
                return;
            }
            if ( M - sum < M - ans) {
                ans = sum;
            }
            return;
        }

        for (int i = start; i <N; i++) {
            picked[count] = nums[i];
            perm(count+1, i+1);
        }
    }
}
