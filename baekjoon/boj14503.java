package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj14503 {

    static int[] dx = {0,1,0,-1};
    static int[] dy = {-1,0,1,0};
    static int[][] map;
    static int clean = 0;
    static int n,m,r,c,d;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s1 = br.readLine();
        String[] sa = s1.split(" ");
        n = Integer.parseInt(sa[0]);
        m = Integer.parseInt(sa[1]);

        String s2 = br.readLine();
        String[] sa2 = s2.split(" ");
        r = Integer.parseInt(sa2[0]);
        c = Integer.parseInt(sa2[1]);
        d = Integer.parseInt(sa2[2]);

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            String[] arr = s.split(" ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(arr[j]);
            }
        }

        start(r,c, d);
        System.out.println(clean);
    }

    public static void start(int r, int c, int d) {
        if (map[r][c] == 0) {
            clean++;
            map[r][c] = -1;
        }

        for (int i=1; i<5; i++) {
            int nowd = d - i;
            if (nowd < 0) {nowd = nowd + 4;}

            int y = r+ dy[nowd];
            int x = c + dx[nowd];
            if (y < 0 || x < 0 || y > n || x >m) {
                continue;
            }
            if (map[y][x] == 0) {
                start(y,x,nowd);
                return;
            }
        }

        //4방향 다 없음
        int y = r - dy[d];
        int x = c - dx[d];
        if (y < 0 || x < 0 || y > n || x >m) {
            return;
        }
        if (map[y][x] != 1) {
            start(y,x,d);
        }
    }
}
