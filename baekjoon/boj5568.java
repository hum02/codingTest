package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.HashSet;

import java.util.Set;

public class boj5568 {
    static int n,k;
    static String[] nums;
    static Set<String> ans = new HashSet<>();
    static String[] picked;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        picked =  new String[k];
        visited = new boolean[n];

        nums = new String[n];
        for (int i = 0; i < n; i++) {
            nums[i] = br.readLine();
        }

        //n개 중 k개 뽑아 나열해 set에 넣기
        combi( 0, "");

        System.out.println(ans.size());
    }

    static void combi(int count, String s) {
        if (count == k) {
            ans.add(s);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i] == false) {
                visited[i] = true;
                picked[count] = nums[i];
                combi(count+1, s+nums[i]);
                visited[i] = false;
            }
        }
    }
}
