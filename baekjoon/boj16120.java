package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj16120 {
    static String s;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        s = br.readLine();

        int len = s.length();

        int pc = 0;
        for (int i = 0; i < len;i++) {
            char c = s.charAt(i);
            if (c == 'P') {
                pc++;
                continue;
            }
            if (c == 'A') {
                if(pc >=2 && i+1<len && s.charAt(i+1) == 'P') {
                    pc-=1;
                    ++i;
                } else {
                    System.out.println("NP");
                    return;
                }
            }
        }

        if (pc != 1) {
            System.out.println("NP");
            return;
        }
        System.out.println("PPAP");


    }
}

