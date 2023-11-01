package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class boj2178 {
    static int n,m;
    static int[][] map;
    static int ans = 0;
    static int[] dx = {0,1, -1,0};
    static int[] dy = {1, 0, 0, -1};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s1 = br.readLine();
        String[] sa = s1.split(" ");
        n = Integer.parseInt(sa[0]);
        m = Integer.parseInt(sa[1]);

        map = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i< n; i++) {
            String s = br.readLine();
            for (int j=0; j<m;j++) {
                map[i][j] =  Character.getNumericValue(s.charAt(j));
            }
        }

        //bfs로 이동, 이동한 칸수 저장.
        bfs(0,0);

        System.out.println(ans);

    }

    public static void bfs(int a, int b) {

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {a,b});
        map[b][a] = 1;

        while(!q.isEmpty()) {
            int[] v = q.poll();

            for (int i = 0; i< 4; i++) {
                int y = v[1] + dy[i];
                int x = v[0] + dx[i];
                if (y < 0 || x < 0 || y >= n || x >= m) {
                    continue;
                }

                if (map[y][x] == 1) {
                    if (y == n-1 && x == m-1) {
                        ans = map[v[1]][v[0]] + 1;
                        return;
                    }
                    if (visited[y][x] == false) {
                        visited[y][x] = true;
                        q.add(new int[] {x,y});
                        map[y][x] = map[v[1]][v[0]] + 1;
                    }
                }
            }
        }

    }

//    public static class Node {
//        public int x;
//        public int y;
//        public int count;
//
//        public Node(int x, int y, int count) {
//            this.x = x;
//            this.y = y;
//            this.count = count;
//        }
//
//    }

}
//문제 파악 잘못 - 처으부터 1임
//목표 지점 인덱스 잘못 설정, -1했어야 함.
//이미 들렀던 거 검사하는 방법 visited배열을 따로 만들기로, 이 정보를 node에 저장하면 메모리 초과
//최단거리-bfs에서는 visited를 다른 경로에서 이미 들렀을 경우 또 들르려고 안해도 된다. 이미 들른 게 최단거리이기 때문에