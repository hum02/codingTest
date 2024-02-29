package programmers;

public class 합승택시요금 {
    class Solution {

        int[][] dist;

        public int solution(int n, int s, int a, int b, int[][] fares) {
            int ans = 99999999;
            dist = new int[n+1][n+1];

            for (int i = 0; i < n+1; i++) {
                for (int j = 0; j < n+1; j++) {
                    if (i == j) {
                        dist[i][j] = 0;
                        continue;
                    }
                    dist[i][j] = 9999999;
                }
            }


            for (int i = 0; i < fares.length; i++) {
                int x = fares[i][0];
                int y = fares[i][1];
                int cost = fares[i][2];

                dist[x][y] = Math.min(dist[x][y], cost);
                dist[y][x] = Math.min(dist[y][x], cost);
            }

            for (int k = 1; k < n+1; k++) {
                // 노드 i에서 j로 가는 경우.
                for (int i = 1; i < n+1; i++) {
                    for (int j = 1; j < n+1; j++) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }

            // // 출력
            // for (int i = 1; i < n+1; i++) {
            // 	for (int j = 1; j < n+1; j++) {
            // 		if (dist[i][j] >= 999999) {
            // 			System.out.print("INF ");
            // 		} else {
            // 			System.out.print(dist[i][j] + " ");
            // 		}
            // 	}
            // 	System.out.println();
            // }

            int share = 0;
            ans = dist[s][a] + dist[s][b];
            for (int i=1; i<n+1; i++) {
                share = i;

                int cur = dist[s][share] + dist[share][a] + dist[share][b];
                System.out.println(cur);
                if (cur < ans) {
                    ans = cur;
                }

            }

            return ans;
        }
    }

/**
 합승 지점 브루트 포스
 n<=200
 그리디 ,dp, dfs,백트래킹

 플로이드로 각 점에서 a,b까지의 거리 구하기

 모든 c를 돌며
 s-> a + s-> b
 보다 s -> c  + c-> a + c-> b 가 더 싸면 갱신
 **/
}
