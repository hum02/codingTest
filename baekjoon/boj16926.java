package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj16926 {
    static int N, M, R;
    static int[][] arr;
    static int[][] ans;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        R = Integer.parseInt(s[2]);
        arr = new int[N][M];
        ans = new int[N][M];

        for (int i = 0; i < N; i++) {
            String[] s2 = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(s2[j]);
            }
        }

        //회전
        int roop = Math.min(N, M) / 2;
        for (int i = 0; i < roop; i++) {
            rot(i, i, R);
        }
        arr = ans;


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void rot(int x, int y, int r) {

        int cx = x;
        int cy = y;

        int wid = M - (2 * y);
        int len = N - (2 * x);

        int tmp = arr[y][x];

        for (int i = 0; i < wid - 1; i++) {
            cx++;
            ans[y][x] = arr[cy][cx];
//            System.out.println(x+", "+y);
            x++;
        }

        for (int i = 0; i < len - 1; i++) {
            cy++;
            ans[y][x] = arr[cy][cx];
//            System.out.println(x+", "+y);
            y++;
        }

        for (int i = 0; i < wid - 1; i++) {
            cx--;
            ans[y][x] = arr[cy][cx];
//            System.out.println(x+", "+y);
            x--;
        }

        for (int i = 0; i < len - 2; i++) {
            cy--;
            ans[y][x] = arr[cy][cx];

//            System.out.println(x+", "+y);
            y--;
        }

        ans[y][x] = tmp;
//        System.out.println(x+", "+y);

    }
}


/**
 * 개선의 여지가 있다.
 * rot할떄 하나식 ++하는 게 아니라 R만큼 한번에 이동하면 개선 가능하다.
 * 이를 위해 각 뎁스의 배열들을 하나의 배열로 만들고 순회할 수 있다.
 **/