package programmers;

import java.util.*;

class Solution {
    static int[][] map = new int[103][103];
    static boolean[][] visit = new boolean[101][101];
    static int ans;
    static int[][] rec;
    static int[] dx = new int[]{1,0,0,-1};
    static int[] dy = new int[]{0,1,-1,0};

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        rec = rectangle;

        for (int i=0; i<rec.length; i++) {
            int[] box = rec[i];
            setBox(box[0]*2, box[1]*2, box[2]*2, box[3]*2);
        }

        find(characterX*2, characterY*2, itemX*2, itemY*2);

//         for (int i = 0;i<10; i++) {
//             for (int j = 0; j<10; j++) {
//                 System.out.print(map[i][j]+" ");
//             }
//             System.out.println();
//         }

        return ans/2;
    }

    public void setBox(int x1, int y1, int x2, int y2) {
        for (int y = y1; y<=y2; y++) {
            for (int x = x1; x<=x2; x++) {
                if (x == x1 || x == x2 || y == y2 || y == y1) {
                    if (map[y][x] == 2) {
                        continue;
                    }
                    map[y][x] = 1;//경로선
                } else {
                    map[y][x] = 2;
                }
            }
        }
    }

    public void find(int stx, int sty, int dstx, int dsty) {
        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{stx, sty,0});
        visit[sty][stx] = true;

        while(!q.isEmpty()) {
            int[] cur = q.poll();

            if (cur[0] == dstx && cur[1] == dsty) {
                ans = cur[2];
                return;
            }

            for (int i=0; i<4; i++) {
                int nx = cur[0]+dx[i];
                int ny = cur[1] + dy[i];
                if (nx < 0||ny<0 || nx>101 || ny>101) {
                    continue;
                }
                if (map[ny][nx] == 1 && visit[ny][nx] == false) {
                    visit[ny][nx] = true;
                    q.offer(new int[]{nx,ny,cur[2]+1});
                }
            }
        }
    }
}
