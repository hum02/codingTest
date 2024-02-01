package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class boj15686 {
    static int n,m;
    static char[][] map;
    static int house = 0;
    static int ans = Integer.MAX_VALUE;
    static List<int[]> chicks = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s1 = br.readLine().split(" ");
        n = Integer.parseInt(s1[0]);
        m = Integer.parseInt(s1[1]);

        map = new char[n][n];
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().replace(" ", "").toCharArray();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j]=='2') {
                    chicks.add(new int[]{i,j});
                }
                if (map[i][j] == '1') {
                    house++;
                }
            }
        }


        //치킨집 m개 고르는 조합 찾기
        findM(new ArrayList<>(), 0);
        System.out.println(ans);

    }

    static void findM(List<int[]> picked, int depth) {
        if (picked.size() == m) {
            findDist(picked);
            return;
        }
        if (depth>chicks.size()-1) {
            return;
        }

        picked.add(chicks.get(depth));
        findM(picked, depth+1);

        picked.remove(picked.size()-1);
        findM(picked, depth+1);
    }

    static void findDist(List<int[]> picked) {
        //치킨 거리합 - 각 집에서의 최소 치킨거리들 구해서 더하기
        int[] dists = new int[house];
        Arrays.fill(dists, 2*n);

        int houseIdx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (map[i][j] == '1') {
                    for (int k = 0; k < picked.size(); k++) {
                        int[] chick = picked.get(k);
                        int y = chick[0];
                        int x = chick[1];
                        //거리구하기
                        int chickDis = Math.abs(y-i)+Math.abs(x-j);
                        dists[houseIdx]=Math.min(dists[houseIdx], chickDis);

                    }
                    houseIdx++;
                }
            }
        }

        int sum = 0;
        for (int dis:dists) {
            sum+=dis;
//            System.out.print(dis + " ");
        }
        ans = Math.min(ans,sum);
    }
}
//dfs가 필요해보이는데 넘겨야 되는 정보가 클때는 어떡하지?
//dfs탐색끼리의 제약조건이 있으면 어떡하지?