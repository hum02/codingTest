package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class boj1260 {
    static int N,M,V;
    static List<Integer>[] map;
    static boolean[] visited;
    static List<Integer> ans = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] ss = br.readLine().split(" ");
        N = Integer.parseInt(ss[0]);
        M = Integer.parseInt(ss[1]);
        V = Integer.parseInt(ss[2]);
        visited = new boolean[N+1];

        map = new List[N+1];
        for (int i = 0; i < N+1; i++) {
            map[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            String[] s2 = br.readLine().split(" ");
            int n1 = Integer.parseInt(s2[0]);
            int n2 = Integer.parseInt(s2[1]);

            map[n1].add(n2);
            map[n2].add(n1);
        }

        for (int i = 0; i < N+1; i++) {
            List<Integer> tmp =  map[i];
            Collections.sort(tmp);
            map[i] = tmp;
        }

        dfs(V);

        System.out.println();
        visited = new boolean[N+1];
        ans = new ArrayList<>();


        bfs(V);

    }

    static void dfs(int cur) {
        visited[cur] = true;
        ans.add(cur);
        System.out.print(cur+" ");

        for (int i = 0; i < map[cur].size(); i++) {
            int next = map[cur].get(i);
            if (visited[next] == false) {
                dfs(next);
            }
        }
    }

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;

        while(!q.isEmpty()) {
            int cur = q.poll();
            ans.add(cur);
            System.out.print(cur +" ");

            for (int i = 0; i < map[cur].size(); i++) {
                int next = map[cur].get(i);
                if (visited[next] == false) {
                    q.add(next);
                    visited[next] = true;
                }
            }
        }
    }
}
