package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj2468 {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0, 0, 1, -1};
    static int n = 0;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        int max = 0;
        for (int i=0;i< n;i++) {
            String s = br.readLine();
            String[] line = s.split(" ");
            for (int j = 0;j<line.length;j++) {
                map[i][j] = Integer.parseInt(line[j]);
                if (max < map[i][j]) {
                    max = map[i][j];
                }
            }
        }

        int maxCount = 0;
        for (int i = 0; i < max; i++) {
            int count = checkArea(i);
            if (count > maxCount) {
                maxCount = count;
            }
        }

        System.out.println(maxCount);
    }

    public static int checkArea(int max) {
        int[][] check = new int[n][n];
        for (int i = 0; i < n; i++) {
            for(int j=0; j< n; j++) {
                if (map[i][j] > max) {
                    check[i][j] = map[i][j];
                } else {
                    check[i][j] = -1;
                }
            }
        }

       return getAreaNum(check);
    }

    public static int getAreaNum(int[][] check) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j=0; j<n;j++) {
                if (check[i][j] != -1) {
                    count++;
                    dfs(i,j,check);
                }
            }
        }
        return count;
    }

    public static void dfs(int i, int j, int[][] check) {
        if (check[i][j] != -1) {
            check[i][j] = -1;

            for (int k = 0; k < 4; k++) {
                int y = i+dy[k];
                int x = j+dx[k];
                if (x<0 || y<0 || x>=n || y>=n) {
                    continue;
                }
                dfs(y,x,check);
            }
        }
    }
}
