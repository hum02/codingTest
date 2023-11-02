package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class boj11559 {
    static char[][] map = new char[12][6];
    static int ans = 0;
    static int[] dx = {0,-1,0,1};  //남,서,북,동
    static int[] dy = {-1,0,1,0};
    static boolean isFinish = false;
    static int[][] visitArr = new int[12][6];

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        //같은 색 뿌요 4개 이상이 연결이면 없어지면 1연쇄
        // 없어지면 중력에 따라 위의 뿌요가 내려옴
        // 또 연결이면 연쇄+
        //여러 그룹이 터질 수 있다면 동시에 터져야 함 그리고 연쇄+

        //map구성
        //터뜨리기 , 여러 개 있다면 동시에 연쇄 수 세기
        //터지면 내리기, 터트릴 거 생기면 도 하기
        for (int i=0; i<12; i++) {
            String s= br.readLine();
            map[i] = s.toCharArray();
        }

        while(!isFinish) {
            isFinish = true;
            for (int i=0; i<12; i++) {
                for (int j=0; j<6; j++) {
                    if (map[i][j] != '.' && visitArr[i][j]!=-1) {
                        bfs(j,i);
                    }
                }
            }
            ans++;
            if (isFinish == true) {
                ans--;
                break;
            }
//            for (int i=0; i<12; i++) {
//                for (int j=0; j<6; j++) {
//                    System.out.print(map[i][j]);
//                }
//                System.out.println();
//            }
            //내리기
            down();
            //더 터뜨릴거 없으면 finish
//            for (int i=0; i<12; i++) {
//                for (int j=0; j<6; j++) {
//                    System.out.print(map[i][j]);
//                }
//                System.out.println();
//            }
//            System.out.println();
//            System.out.println();
//            System.out.println();

        }
        System.out.println(ans);
    }

    public static void bfs(int a, int b) {
        Queue<int[]> q = new LinkedList<>();
        List<int[]> visited = new ArrayList<>();
        q.add(new int[]{a,b});
        char c = map[b][a];

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int i=0; i<4; i++) {
                int x = cur[0] + dx[i];
                int y = cur[1] + dy[i];
                if (x<0 || y<0||x>=6||y>=12) {
                    continue;
                }
                int[] node = new int[]{x,y};
                if (map[y][x] == c && visitArr[y][x] != -1) {
                    q.add(node);
                    visited.add(node);
                    visitArr[y][x] = -1;
                }
            }
        }

        if (visited.size() >=4) {
            for (int i=0; i< visited.size(); i++) {
                int[] node = visited.get(i);
                map[node[1]][node[0]] = '.';
//                System.out.println(node[0] +","+node[1] +"  bomb");
            }
            isFinish = false;
        }
    }

    public static void down() {
        for (int j=0; j<6; j++) {
            Queue<Character> q = new LinkedList<>();

            for (int i=11; i>=0; i--) {
                char cur = map[i][j];
                if (cur != '.') {
                    q.add(cur);
                }
            }
            for (int i=11; i>=0; i--) {
                if (q.isEmpty()) {
                    map[i][j] = '.';
                    continue;
                }
                map[i][j] = q.poll();
            }
        }

        visitArr = new int[12][6];
    }
}
//한꺼번에 터지면 1번 연쇄로 세는 거다!!!!!!!!!
//중력 내리는 거 어케 구현했을까
//bfs로 했어야 했을까