class Solution {
    int answer = 0;
    boolean[] visit;

    public int solution(int k, int[][] dungeons) {
        visit= new boolean[dungeons.length];

        dfs(0, k, dungeons);

        return answer;
    }

    private void dfs(int depth, int k, int[][] dungeons) {
        for (int i = 0; i < dungeons.length; i++) {
            if (!visit[i] && k >= dungeons[i][0] ) {
                visit[i] = true;
                dfs(depth + 1, k - dungeons[i][1], dungeons);
                visit[i] = false;
            }
        }

        if(answer<depth){ answer=depth;}
    }
}