package baekjoon;

import java.util.Scanner;
public class boj3584 {
    static int[] parent;
    static int[] ans;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 0;
        int t = Integer.parseInt(sc.nextLine());
        ans = new int[t];
        parent = new int[n];
        int[] toGet = new int[2];

        for (int i = 0; i < t; i++) {
            n =  Integer.parseInt(sc.nextLine());
            parent = new int[n+1];
            for (int j = 0; j < n-1; j++) {
                String link = sc.nextLine();
                String[] l = link.split(" ");
                parent[Integer.parseInt(l[1])] = Integer.parseInt(l[0]);
            }
            String[] s = sc.nextLine().split(" ");
            toGet[0] = Integer.parseInt(s[0]);
            toGet[1] = Integer.parseInt(s[1]);

            boolean visited[] = new boolean[n + 1];
            dfs_allPath(toGet[0], visited, i);
            dfs_allPath(toGet[1], visited, i);
        }

        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }

    }

    public static void dfs_allPath(int v,  boolean[] visited, int cur) {


        if (visited[v] == true) {
            ans[cur] = v;
            return;
        }

        if(parent[v] == 0) { // 루트 노드에 왔다면
            visited[v] = true;
            return;
        }


        visited[v] = true;

        dfs_allPath(parent[v], visited, cur);

    }

}

//공통조상이 루트 노드일 경우를 생각해 ans검사를 루트 노드의 return보다 앞에서 했어야함