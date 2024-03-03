package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj10164 {

    static boolean[][] map;
    static long[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] ss = br.readLine().split(" ");
        int N = Integer.parseInt(ss[0]);
        int M = Integer.parseInt(ss[1]);
        long must = Long.parseLong(ss[2]);

        //must의 인덱스 찾아내기
        map = new boolean[N][M];
        dp = new long[N][M];

        int mustX = 0, mustY = 0;
        long cnt = 1;

        if (must != 0) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {

                    if (cnt == must) {
                        mustX = j;
                        mustY = i;
                        break;
                    }
                    cnt++;
                }
                if (mustX != 0) {
                    break;
                }
            }
        }



        for (int i = 0; i <= mustY; i++) {
            for (int j = 0; j <= mustX; j++) {
                if (i == 0 || j == 0) dp[i][j] = 1;
                else dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        long goal = dp[mustY][mustX];


        for (int i = mustY; i < N; i++) {
            for (int j = mustX; j < M; j++) {
                if (i == mustY || j == mustX) dp[i][j] = 1;
                else dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        System.out.println(goal * dp[N-1][M-1]);

//        System.out.println(dp[N-1][M-1]);
    }



}
