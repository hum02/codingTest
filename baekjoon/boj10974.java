package baekjoon;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj10974 {
    static int[] num;
    static int n;
    static int[] arr;
    static int[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        num = new int[n];
        visited = new int[n];
        arr = new int[n];
        for (int i=1; i<= n; i++) {
            num[i-1] = i;
        }

        dfs(0);

    }

    public static void dfs(int depth) {
        if (depth == n) {
            for(int i=0;i<n;i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i=0;i<n;i++) {
            if (visited[i] == 1) {
                continue;
            }

            visited[i] = 1;
            arr[depth] = num[i];
            dfs(depth+1);
            visited[i] = 0;
        }

    }
}

