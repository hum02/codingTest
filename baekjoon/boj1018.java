package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj1018 {

    static int n, m = 0;
    static char[][] board;
    static int min = 64;

    public static void main(String[] args) throws Exception {
        //입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s1 = br.readLine().split(" ");
        n = Integer.parseInt(s1[0]);
        m = Integer.parseInt(s1[1]);

        board = new char[n][m];

        for (int i = 0; i < n; i++) {
            board[i] = br.readLine().toCharArray();
        }

        //8*8을 브루트포스로 검사
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i + 8 > n || j + 8 > m) {
                    continue;
                }
                chess(i, j, 'W');
                chess(i, j, 'B');
            }
        }

        System.out.println(min);

    }

    public static void chess(int a, int b, char color) {

        //각 판의 시작이 검정/흰색일 경우의 칠하기 숫자 구해서 최소값 갱신
        //검정 시작

        int bc = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ((i+j)%2 ==0) {
                    if (board[a+i][b+j] != color) {
                        bc++;
                    }
                } else {
                    if (board[a+i][b+j] == color) {
                        bc++;
                    }
                }
            }
        }

        min = Math.min(bc, min);
    }

}



