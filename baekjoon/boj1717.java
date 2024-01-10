package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj1717 {

    private static int n, m;
    private static int[] parent;
    private static List<String> ans = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); //n : 집합의 최대
        m = Integer.parseInt(st.nextToken()); //m :연산의 수

        parent = new int[n + 1];
        //배열 초기화
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            //결과 출력
            if (a == 1) {
                boolean equals = check(b, c);
                if (equals == true) ans.add("YES");
                else ans.add("NO");
                //a == 0 : 집합 합침
            } else {
                union(b, c);
            }
        }

        for (int i = 0; i < ans.size(); i++) {
            System.out.println(ans.get(i));
        }
        br.close();
    }

    static boolean check(int a, int b) {
        return findParent(a) == findParent(b);
    }

    static void union(int a, int b) {
        //각 수가 최종적으로 속한 집합의 대장
        int x = findParent(a);
        int y = findParent(b);

        if (y>x) {
            parent[x] = y;
        } else {
            parent[y] = x;
        }

    }

    static int findParent(int a) {
        if (parent[a] == a) {
            return a;
        }
        return findParent(parent[a]);
    }
}
