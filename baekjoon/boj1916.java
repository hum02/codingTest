package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class boj1916 {

    static int N,M;
    static List<int[]>[] nodes;
    static int[] dp;
    static int ans = 0;
    static boolean[] visit = new boolean[1001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        dp = new int[N+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        nodes = new List[N+1];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            String[] slink = br.readLine().split(" ");
            int start = Integer.parseInt(slink[0]);
            int dest = Integer.parseInt(slink[1]);
            int len = Integer.parseInt(slink[2]);

            nodes[start].add(new int[]{dest,len});
        }

        String[] goal = br.readLine().split(" ");
        int start = Integer.parseInt(goal[0]);
        int dest = Integer.parseInt(goal[1]);
        Queue<int[]> q = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        //초기화
        q.add(new int[]{start, 0});
        dp[start] = 0;q

        while(!q.isEmpty()) {
            int[] curNode = q.poll();
            int cur = curNode[0];
//            System.out.println(cur);

            if (visit[cur] == true) {
                continue;
            }

            visit[cur] = true;
            //dp갱신
            for (int[] link: nodes[cur]) {
//                System.out.println("Add" + link[0]);
                if (visit[link[0]] == false && dp[cur] + link[1] < dp[link[0]]) {
                    dp[link[0]] = dp[cur] + link[1];
                    q.add(new int[]{link[0], dp[link[0]]});
                }
            }
        }

        System.out.println(dp[dest]);

    }
}
