package programmers;

import java.util.*;

class Solution {
    int[] sum;
    boolean[][] visit;
    List<int[]> cur = new ArrayList<>();
    int[] dx = {1,0,-1,0};
    int[] dy = {0,-1,0,1};
    int[][] land;

    public int solution(int[][] land) {
        int answer = 0;
        this.land = land;
        sum = new int[land[0].length];
        visit = new boolean[land.length][land[0].length];

        //land의 뭉텅이 수를, 각 콜롬별로 1곳에만 써놓기
        //각 뭉텅이 크기 구하기
        for (int i=0; i<land.length; i++) {
            for (int j=0; j<land[0].length; j++) {
                if (visit[i][j] == false && land[i][j] == 1) {
                    dfs(i,j);
                    //크기 구해서, 열별로 카운트
                    int amount = cur.size();
                    Set<Integer> cols = new HashSet<>();
                    for (int[] block:cur) {
                        cols.add(block[0]);
                    }

                    for (int col:cols) {
                        sum[col]+=amount;
                    }
                    // System.out.println(cur);

                    cur = new ArrayList<>();
                }
            }
        }

        int max = 0;
        for (int i=0; i<sum.length;i++) {
            max = Math.max(max, sum[i]);
        }

        return max;
    }

    void dfs(int h, int col) {
        cur.add(new int[]{col,h});
        visit[h][col] = true;

        //더 갈 곳이 없으면 끝
        for (int i=0; i<4; i++) {
            int nx = col+dx[i];
            int ny = h+dy[i];
            if (nx<0 || ny<0 || nx>=land[0].length || ny>=land.length) {
                continue;
            }
            if (visit[ny][nx]) {continue;}

            if (land[ny][nx] == 1) {
                dfs(ny, nx);
            }

        }

    }
}
