package programmers;

import java.util.*;

class Solution {
    static int[] dp;
    static int[] visited;
    public int solution(int N, int[][] road, int K) {
        int ans = 0;

        dp = new int[N+1];
        visited = new int[N+1];
        for (int i=0; i<dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        bfs(1, K, road);

        for (int i=1; i<dp.length; i++) {
            if (dp[i] <= K) {
                ans++;
            }
        }

        return ans;
    }

    public void bfs(int start, int maxTime, int[][] road) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        dp[start] = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();
            // System.out.println(cur);
            visited[cur] = 1;

            for (int i=0; i<road.length; i++) {
                if (road[i][0] == cur || road[i][1] == cur) {
                    int next = road[i][0] == cur? road[i][1] : road[i][0];
                    if (dp[next] > dp[cur] + road[i][2]) {
                        dp[next] = dp[cur] + road[i][2];
                        q.add(next);
                    }
                }
            }
        }
    }
}
