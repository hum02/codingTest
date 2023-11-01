package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class boj3190 {
    static int n;
    static int k;
    static int l;
    static int[][] apple;
    static int[][] change;
    static int[][] map;
    static int ans = 0;
    static Queue<int[]> snake = new LinkedList<>();

    static int d = 0; //0,1,2,3 -> 동, 북, 남, 서
    static int[] dx = {1,0,0,-1};
    static int[] dy = {0,-1, 1,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        k = Integer.parseInt(br.readLine());

        apple = new int[k][2];
        for (int i=0; i<k; i++) {
            String s = br.readLine();
            String[] sa = s.split(" ");
            apple[i] = new int[]{Integer.parseInt(sa[0]), Integer.parseInt(sa[1])};
        }

        l = Integer.parseInt(br.readLine());
        change = new int[l][2];
        for (int i=0; i<l; i++) {
            String s = br.readLine();
            String[] sa = s.split(" ");

            //L = 0, D = 1
            int dir = -1;
            if (sa[1].equals("L")) {dir = 0;}
            if (sa[1].equals("D")) {dir = 1;}
            change[i] = new int[]{Integer.parseInt(sa[0]), dir};
        }

        //벽이나 자신 몸 부딪혀 종료
        //다음 칸 위치 - 사과 있음
        //다음칸 위치 - 사과 없음

        move(0,0,0);

        System.out.println(ans);

    }

    public static void move(int a, int b, int time) {
        if (a<0||b<0||a>=n||b>=n) {
            ans = time;
            return;
        }
        if (map[b][a] == 2) {
            ans = time;
            return;
        } else {
            map[b][a] = 2;
            snake.add(new int[]{a,b});
        }

        int x = a+dx[d];
        int y = b+dy[d];

        for (int i = 0; i< change.length; i++) {
            if (change[i][0] == time) {
                //dir = 방향마다 left,right일 경우 어느 방향으로 이동할 지
                int[] dir = new int[2];
                int lorr =  change[i][1];

                //0,1,2,3 -> 동 북 남 서
                if (d == 0){dir[0] = 1; dir[1] = 2; }
                else if (d == 1){dir[0] = 3; dir[1] = 0;}
                else if (d == 2){dir[0] = 0; dir[1] = 3;}
                else if (d == 3){ dir[0] = 2; dir[1] = 1;}
                d = dir[lorr];
//                System.out.println("change to" + d);

                //다음 방향
                x = a + dx[dir[lorr]];
                y = b + dy[dir[lorr]];

                break;
            }
        }

        boolean isApple = false;
        for (int i=0; i <apple.length; i++) {
            //사과 먹음
            if (apple[i][0] == b+1 && apple[i][1] == a+1) {
//                System.out.println("eat apple!");
                isApple = true;
                apple[i][0] = -1; apple[i][1] = -1;
                break;
            }
        }

        //자신의 몸 방문처리
        if (!isApple && time != 0) {
            int[] tail = snake.poll();
            map[tail[1]][tail[0]] = 0;
        }
//        System.out.println(a +","+b);

        move(x,y, time+1);

    }
}

//사과 먹으면 개수 늘릴때, 첫 시작때부터 길이는 1인거

//벽이나 자신 몸 부딪혀 종료
//방향 바꾸기 -> 현재 방향에 따라 왼쪽,오른쪽이 어느 방향인지 달라지는 거  구현
// -> -1,1로 했으면 더 편했을 듯
//다음 칸 위치 - 사과 있음
//다음칸 위치 - 사과 없음
//위치를 +1해줘야 할때 인지하기 아니면 애초에 map에 사과를 그려놓든지

