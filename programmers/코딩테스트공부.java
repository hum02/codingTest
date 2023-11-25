package programmers;

import java.util.*;

class Solution {
    int alp;
    int cop;
    int maxalp = 0;
    int maxcop = 0;
    int[][] problems;
    int[][] dp;
    static int INF = 400;

    public int solution(int alp, int cop, int[][] problems) {

        //알고력, 코딩력을 시간을 투자해 높이고 -> 문제가 요구하는 시간 투자해 문제풀면 알고,코딩력 증가
        //모든 문제를 풀 수 있는 알고력, 코딩력을 얻는 최소시간
        //알고, 코딩, 문제풀기를 해서 모든 문제 풀 수 있는 알고,코딩력 최소시간으로 획득.
        this.alp = alp;
        this.cop = cop;
        this.problems = problems;

        for (int i=0; i<problems.length; i++) {
            maxalp = Math.max(maxalp, problems[i][0]);
            maxcop = Math.max(maxcop, problems[i][1]);
        }
        this.dp = new int[180][180];

        alp = Math.min(alp, maxalp);
        cop = Math.min(cop, maxcop);
        for (int i=0; i<dp.length; i++ ) {
            Arrays.fill(dp[i], INF);
        }
        dp[alp][cop] = 0;

        for (int i=alp; i<=maxalp; i++ ) {
            for (int j=cop; j<=maxcop; j++) {
                //알고공부
                dp[i+1][j] = Math.min(dp[i][j]+1, dp[i+1][j]);
                //코딩 공부
                dp[i][j+1] = Math.min(dp[i][j+1], dp[i][j]+1);

                //문제 풀기
                for (int k=0; k<problems.length; k++) {
                    if (i < problems[k][0] || j<problems[k][1]){
                        continue;
                    }
                    //문제를 풀었을 경우 최소시간이라면 갱신
                    int nextalp = Math.min(maxalp, i+problems[k][2]);
                    int nextcop = Math.min(maxcop, j+problems[k][3]);
                    dp[nextalp][nextcop] = Math.min(dp[i][j]+problems[k][4],dp[nextalp][nextcop]);

                }
            }
        }

        return dp[maxalp][maxcop];
    }

}

//깊이가 깊을 거 같을 때, 해결책을 모름.
//브루트, bfs, dfs , 그리디 ,dp, 투 포인터



