package programmers;

import java.util.*;
import java.io.*;

class Solution {
    static List<Integer>[] map;
    static int[] dist;
    static boolean[] visited;
    static int maxNum = 0;
    static int INF = 99999;

    static class Node {
        int no; // 노드 번호
        int dir; // 거리

        Node(int no, int dir) {
            this.no = no;
            this.dir = dir;
        }

    }

    public int solution(int n, int[][] edge) {
        map = new List[n+1];
        dist = new int[n+1]; // 1로부터 다른 노드까지의 최단 거리
        visited = new boolean[n+1];

        for(int i=0; i<= n; i++) {
            map[i] = new ArrayList<Integer>();
            Arrays.fill(dist, INF); // 최댓값으로 초기화
        }

        for(int i=0; i< edge.length; i++) {
            int a = edge[i][0];
            int b = edge[i][1];
            map[a].add(b); // 양방향 연결
            map[b].add(a);
        }

        dijkstra(1);

        int answer = 0;
        int maxNum = 0;
        for(int i=2; i<=n; i++) {
            maxNum = Math.max(maxNum, dist[i]); // maxNum: 가장 먼 거리
        }
        for(int i=2; i<=n; i++) {
            if(maxNum == dist[i]) answer++; // 가장 먼 거리의 노드 수 세기
        }

        return answer;
    }

    // 다익스트라로 start로부터 다른 노드까지 최단 거리(dirs) 구하기
    private static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2) -> {return o1.dir - o2.dir;});
        pq.offer(new Node(start, 0)); // 나와의 거리는 0
        dist[start] = 0; // 나와의 거리는 0

        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            visited[cur.no] = true;
            for (int next : map[cur.no]) {
                if (dist[next] > dist[cur.no]+1) {
                    dist[next] = dist[cur.no]+1;
                    pq.offer(new Node(next, dist[next]));
                }
            }

        }
    }
}
