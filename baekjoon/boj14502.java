package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class boj14502 {
    static int n;
    static int m;
    static int[][] map;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {-1,0,1,0};
    static List<Node> virus = new ArrayList<>();
    static int[][] map2;
    static Queue<Node> q = new LinkedList<>();
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s1 = br.readLine();
        String[] sa1 = s1.split(" ");
        n = Integer.parseInt(sa1[0]);
        m = Integer.parseInt(sa1[1]);

        map = new int[n][m];
        for (int i=0; i< n; i++) {
            String s = br.readLine();
            String[] line = s.split(" ");
            for (int j=0; j<m; j++) {
                map[i][j] = Integer.parseInt(line[j]);
                if (map[i][j] == 2) {
                    virus.add(new Node(j,i));
                }
            }
        }

        dfsWall(0);
        System.out.println(max);

    }

    public static void dfsWall(int wallCount) {
        if (wallCount == 3) {
            int[][] vmap = new int[n][m];
            for (int i=0; i< n; i++) {
                for (int j=0; j< m; j++) {
                    vmap[i][j] = map[i][j];
                }
            }
            map2 = vmap;

            for (int i = 0; i< virus.size(); i++) {
                Node v = virus.get(i);
                q.add(v);
                bfsVirus();
            }

            int c = 0;
            for (int i=0; i<n; i++) {
                for (int j=0; j< m; j++) {
                   if ( vmap[i][j] == 0 ) {
                       c++;
                   }
                }
            }

            if (c > max) {
                max = c;
            }
            return;
        }

        for (int i=0; i < n; i++) {
            for (int j=0; j < m; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    dfsWall(wallCount+1);
                    map[i][j] = 0;
                }
            }
        }
    }

    public static void bfsVirus() {
        while (!q.isEmpty()) {
            Node v = q.poll();
            int i = v.y;
            int j = v.x;

            if (map2[i][j] == 2) {

                for (int k = 0; k < 4; k++) {
                    int y = i + dy[k];
                    int x = j + dx[k];
                    if (x < 0 || y < 0 || y >= n || x >= m) {
                        continue;
                    }
                    if (map2[y][x] == 0) {
                        map2[y][x] = 2;
                        q.add(new Node(x, y));
                    }
                }
            }
        }
    }

    public static class Node {
        public int x;
        public int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

//node꼭 써야 하나
//무한 루프 걸릴 수도 있는 지점들 - map2수정 안해주고 바이러스 퍼뜨림. 이미 퍼뜨렸거나, 큐에 들어가 있는 거 또 들어가지 않게
//map에 대한 복사를 꼭 해야하나
//벽 세우는 경우의 수 구현 방법 - dfs, node로 다 가지고 있기