package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj2174 {
    static int a,b;
    static int n,m;
    static int[] curD; //nesw 0,1,2,3
    static int[] dx = {0,1,0,-1};  //북,동, 남, 서 // 왼쪽 -1, 오른쪽 +1
    static int[] dy = {1,0,-1,0};
    static int[][] robot;
    static String[] commands;
    static boolean isFinish = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        //로봇 위치 시키기
        //명령 수행 - 벽에 부딪히면 출력
        //        - 로봇끼리 부딪히면 몇 번끼리 충돌인지 출력
        String s= br.readLine();
        String[] sa = s.split(" ");
        a = Integer.parseInt(sa[0]);
        b = Integer.parseInt(sa[1]);

        String s2= br.readLine();
        String[] sa2 = s2.split(" ");
        n = Integer.parseInt(sa2[0]);
        m = Integer.parseInt(sa2[1]);

        robot = new int[n][2];
        curD = new int[n];
        for (int i=0;i<n;i++) {
            String r = br.readLine();
            String[] rs = r.split(" ");

            robot[i] = new int[]{Integer.parseInt(rs[0]) -1, Integer.parseInt(rs[1]) -1};

            int d = 0;
            if (rs[2].equals("N")) {
                d = 0;
            }
            if (rs[2].equals("E")) {
                d = 1;
            }
            if (rs[2].equals("S")) {
                d = 2;
            }
            if (rs[2].equals("W")) {
                d = 3;
            }
            curD[i] = d;
        }

        commands = new String[m];
        for (int i=0;i<m;i++) {
            commands[i] = br.readLine();
        }

        for (int i=0;i<m;i++) {
            String command = commands[i];
            String[] cs = command.split(" ");

            int count = Integer.parseInt(cs[2]);
            for (int j=0; j<count; j++) {
                move(Integer.parseInt(cs[0]) -1, cs[1]);
                if (isFinish) {
                    return;
                }
            }
        }
        System.out.println("OK");
    }

    static void move(int rn, String c) {
        //움직이기
        int dir = 0;
        if (c.equals("L")) {
            dir = -1;
        }
        if (c.equals("R")) {
            dir = 1;
        }


        int direction = curD[rn] + dir;
        if (direction < 0) {
            direction+=4;
        }
        if (direction > 3) {
            direction-=4;
        }
        curD[rn] = direction;

        if (c.equals("F")) {
            int x = robot[rn][0] + dx[direction];
            int y = robot[rn][1] + dy[direction];

            if (x <0 || y <0 || x>=a|| y>=b) {
                System.out.println("Robot " + (rn+1) + " crashes into the wall");
                isFinish = true;
                return;
            }
            robot[rn][0] = x;
            robot[rn][1] = y;

            for (int i=0;i <n;i++) {
                if (i==rn) {continue;}
                if (robot[rn][0] == robot[i][0] && robot[rn][1] == robot[i][1]) {
                    System.out.println("Robot " + (rn+1) + " crashes into robot " + (i+1));
                    isFinish = true;
                    return;
                }
            }
        }

    }

}
//sout할 때 숫자 연산은 괄호로 묶자 , 아니면 이상하게 출력됨
//방향 전환만 하는 건지, 이동은 따로 하는건지 문제  제대로 파악하자
//