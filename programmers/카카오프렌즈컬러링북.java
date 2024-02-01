package programmers;



class Solution {
    boolean[][] visited;
    int[] answer = new int[2];
    int[][] pic;
    int[] dy = new int[]{0,0,1,-1};
    int[] dx = new int[]{1,-1,0,0};
    int m,n;
    int curCount;

    public int[] solution(int m, int n, int[][] picture) {
        this.m = m;
        this.n=n;
        visited = new boolean[m][n];
        pic = picture;

        for (int i=0; i<m; i++) {
            for (int j=0; j<n;j++) {
                if (visited[i][j] == false && pic[i][j]!=0) {
                    curCount = 0;
                    answer[0] = answer[0]+1;
                    dfs(i,j,pic[i][j]);
                }
            }
        }

        return answer;
    }

    void dfs(int y, int x, int color) {
        if (y<0||y>=m||x<0||x>=n) {
            return;
        }
        if (pic[y][x]!=color || visited[y][x] == true) {
            return;
        }

        ++curCount;
        visited[y][x] = true;
        answer[1] = Math.max(curCount, answer[1]);

        for (int i=0; i<4;i++) {
            int ny = y+dy[i];
            int nx = x+dx[i];
            dfs(ny,nx,color);
        }
    }
}


/**
 1110
 1220
 1001
 0001
 0003
 0003

 **/
