package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class boj14500 {
    static int[] dx = new int[]{1,-1,0,0};
    static int[] dy = new int[]{0,0,1,-1};

    static int[][] ndx = new int[][]{{0,1,1,2},{0,1,1,2},{0,1,1,1},{0,0,0,1}};
    static int[][] ndy = new int[][]{{0,0,-1,0},{0,0,1,0},{0,0,1,-1},{0,1,-1,0}};

//    static int[] dx2 = new int[]{0,1,1,2};
//    static int[] dy2 = new int[]{0,0,-1,0};
//
//    static int[] dx3 = new int[]{0,1,1,2};
//    static int[] dy3 = new int[]{0,0,1,0};
//
//    static int[] dx4 = new int[]{0,1,1,1};
//    static int[] dy4 = new int[]{0,0,1,-1};
//
//    static int[] dx5 = new int[]{0,0,0,1};
//    static int[] dy5 = new int[]{0,1,-1,0};

    static int N,M = 0;
    static int[][] map;
    static boolean[][] visit;
    static int maxSum = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] ss1 = br.readLine().split(" ");
        N = Integer.parseInt(ss1[0]);
        M = Integer.parseInt(ss1[1]);
        map = new int[N][M];
        visit = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String[] ss2 = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(ss2[j]);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visit[i][j] = true;
                findSum(i,j, 1,map[i][j]);
                visit[i][j] = false;
            }
        }

        System.out.println(maxSum);
    }

    static void findSum(int y, int x, int count, int sum) {
        if (count == 4) {

            maxSum = Math.max(maxSum, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int[] nnx = ndx[i];
            int[] nny = ndy[i];
            int tmp = 0;
            for (int j = 0; j < 4; j++) {
                int nx = x+nnx[j];
                int ny = y+nny[j];

                if (nx<0 || ny <0 || ny>=N||nx>=M) {
                    break;
                }
                tmp+=map[ny][nx];
            }
            maxSum = Math.max(maxSum, tmp);
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx<0 || ny <0 || ny>=N||nx>=M) {
                continue;
            }

            if (visit[ny][nx] == true) {
                continue;
            } else {visit[ny][nx] = true;}

            findSum(ny,nx,count+1,sum+map[ny][nx]);
            visit[ny][nx] = false;
        }

    }
}
//숫자가 써 있는 사각형에
//가리는 수의 합이 최대가 되도록하는 도형 구하기
//회전,대칭 가능

//visit처리 생각하기

//모양중에 한점에서 두방향으로 가는 모양이 있다!!!
//이걸 풀이 단계에서부터 어떻게 캐치하지??
