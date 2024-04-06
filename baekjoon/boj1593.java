package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj1593 {
    static int g,s;
    static String W,S;
    static int[] ws;
    static int[] curs;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        int ans = 0;

        g = Integer.parseInt(in[0]);
        s = Integer.parseInt(in[1]);
        W = br.readLine();
        S = br.readLine();
        ws = new int[125];
        curs = new int[125];

        for (int i = 0; i < g; i++) {
            ws[W.charAt(i)]++;
            curs[S.charAt(i)]++;
        }

        if (isSame()) {
            ans++;
        }
        for (int i = g; i < s; i++) {
            curs[S.charAt(i-g)]--;
            curs[S.charAt(i)]++;

            if (isSame()) {
                ans++;
            }
        }

        System.out.println(ans);
    }

    static boolean isSame() {
        for (int i = 64; i < 125; i++) {
            if (ws[i] != curs[i]) {
                return false;
            }
        }
        return true;
    }

}
/**
 *
 * 1. W의 경우의 수 다 구해서 coantins로 검사 -> 메모리 초과
 * 2. S의 char하나씩 검사해 W길이만큼일치하면 인정 -> 중복글자까지 인정하는 거라 안됨.
 * **/