package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class boj2667 {

    static int N;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {1,0,0,-1};
    static int[] dy = {0,1,-1,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int cluC = 0;
        List<Integer> cluSizes = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == '1' && visited[i][j] == false) {
                    cluC++;
                    cluSizes.add(bfs(j, i));
                }
            }
        }

        Collections.sort(cluSizes);
        System.out.println(cluC);
        for (int n:cluSizes) {
            System.out.println(n);
        }
    }

    static int bfs(int x, int y) {
        visited[y][x] = true;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x,y});
        int count = 1;

        while(!q.isEmpty()) {
            int[] cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur[0]+dx[i];
                int ny = cur[1]+dy[i];
                if (nx<0 || nx >= map.length || ny<0 || ny>=map.length) {
                    continue;
                }

                if (map[ny][nx] == '1' && visited[ny][nx] == false) {
                    q.add(new int[]{nx,ny});
                    visited[ny][nx] = true;
                    count++;
                }
            }
        }

        return count;

    }
}
