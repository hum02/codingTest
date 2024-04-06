package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class boj10814 {

    static List<int[]> ages = new ArrayList<>();
    static Map<Integer, String> names = new HashMap<>();
    static int N = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String[] tmp = br.readLine().split(" ");
            int[] age = new int[] {Integer.parseInt(tmp[0]), i};
            ages.add(age);
            names.put(i, tmp[1]);
        }

        ages.sort((int[] o1, int[] o2) -> {
            int res = o1[0] - o2[0];
            if (res == 0) {
                return o1[1]-o2[1];
            }
            return res;
        });

        for (int i = 0; i < ages.size(); i++) {
            int[] age = ages.get(i);
            System.out.println(age[0] +" "+names.get(age[1]));
        }
    }



}

