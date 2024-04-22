package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class boj2606 {
    static int comn, linkn = 0;
    static List<Integer>[] maps;
    static boolean[] visited;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));

        comn = Integer.parseInt(br.readLine());
        linkn = Integer.parseInt(br.readLine());

        visited = new boolean[comn+1];
        maps = new List[comn+1];

        for (int i = 0; i < comn+1; i++) {
            maps[i] = new ArrayList<>();
        }


        for (int i = 0; i < linkn; i++) {
           String[] ss = br.readLine().split(" ");
           int l1 = Integer.parseInt(ss[0]);
            int l2 = Integer.parseInt(ss[1]);
           maps[l1].add(l2);
           maps[l2].add(l1);
        }

        bfs(1);

        System.out.println(count);
        
    }
    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        visited[start] = true;
        q.add(start);

        while(!q.isEmpty()) {
            int cur = q.poll();
            List<Integer> links = maps[cur];

            for (int i = 0; i < links.size(); i++) {
                int next = links.get(i);
                if (visited[next] == false) {
                    q.add(next);
                    visited[next] = true;
                    count++;
                }
            }
        }


    }
}
