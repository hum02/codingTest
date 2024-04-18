package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class boj14889 {
    static int N;
    static int[][] S;
    static boolean[] picked;
    static int ans = 999999;
    public static void main(String[] args) throws IOException {
        //팀원을 반으로 나누는 조합 구하기
        //팀원들 중 2명씩 뽑아 시너지 합 계산

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        S = new int[N][N];
        picked = new boolean[N];

        for (int i = 0; i < N; i++) {
            S[i] = new int[N];
            String[] ss = br.readLine().split(" ");
            for (int j = 0; j < ss.length; j++) {
                S[i][j] = Integer.parseInt(ss[j]);
            }
        }

        int[] team = new int[N/2];
        team[0] = 0;
        picked[0] = true;
        makeTeam(team, 1,1);
        System.out.println(ans);
    }

    static void makeTeam(int[] team, int count, int start) {
        if (count == N/2) {
           int[] others = new int[N/2];
           int cur= 0;
            for (int i = 0; i < N; i++) {
                if (picked[i] == false) {
                    others[cur] = i;
                    cur++;
                }
            }

            int s1 = calculScore(team);
            int s2 = calculScore(others);
//            for (int n:team) {
//                System.out.print(n +", ");
//            }
//            System.out.println();

            int dif = Math.abs(s1- s2);
            if (dif < ans) {
                ans = dif;
            }

            return;
        }

        for (int i = start; i < N; i++) {
            if (picked[i] == false) {
                team[count] = i;
                picked[i] = true;
                makeTeam(team, count+1, i);
                picked[i] = false;
            }
        }
    }

    static int calculScore(int[] team) {
        int score = 0;
        int[] picked = new int[2];
        for (int i = 0; i < team.length; i++) {
            picked[0] = team[i];
            for (int j = i+1; j < team.length; j++) {
                picked[1] = team[j];
                score+=(S[picked[0]][picked[1]]+S[picked[1]][picked[0]]);
            }
        }

//        System.out.println(score);
        return score;
    }
}
