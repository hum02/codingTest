import java.util.Arrays;

class Solution {
    boolean[] visited;
    int node_num=0;
    int[][] graph;

    public int solution(int n, int[][] wires) {
        int answer = 100;
        visited=new boolean[n+1];
        graph= new int[n+1][n+1];

        for(int i=0;i<wires.length;i++){
            graph[wires[i][0]][wires[i][1]]=1;
            graph[wires[i][1]][wires[i][0]]=1;
        }

        for(int i=0;i<wires.length;i++){
            int dif_node;

            graph[wires[i][0]][wires[i][1]]=0;
            graph[wires[i][1]][wires[i][0]]=0;

            for(int j=1;j<n+1;j++){
                dfs(j,n);
                if(node_num!=0){
                    dif_node=Math.abs(node_num-(n-node_num));
                    if(dif_node<answer){answer=dif_node;}
                    break;
                }

            }
            node_num=0;

            graph[wires[i][0]][wires[i][1]]=1;
            graph[wires[i][1]][wires[i][0]]=1;

            Arrays.fill(visited,false);
        }

        return answer;
    }

    private void dfs(int start,int n){
        if(!visited[start]){
            ++node_num;
            visited[start]=true;
        }

        for(int i=1;i<n+1;i++){
            if((!visited[i]) && graph[start][i]==1){
                visited[i]=true;
                ++node_num;
                dfs(i,n);
            }
        }
    }
}