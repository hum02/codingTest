package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class boj9663 {

    static int N;
    static int[] picked;
    static int ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        picked = new int[N+1];

        nq(0);

        System.out.println(ans);
    }

    static void nq(int dep) {
        if (dep == N) {
            ans++;
            return;
        }

        for (int i = 1; i < N+1; i++) {
            if (possible(i, dep)) {
                picked[dep] = i;
                nq(dep+1);
                picked[dep] = 0;
            }
        }

    }

    static boolean possible(int next, int dep) {
        if (picked.length == 0) {
            return true;
        }

        for (int i = 0; i < N; i++) {
            if (picked[i] == 0) {
                continue;
            }
            if (picked[i] == next) {
                return false;
            }

            if (dep - i == Math.abs(next - picked[i])) {
                return false;
            }
        }

        return true;

    }
}
