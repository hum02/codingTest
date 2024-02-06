package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class boj2696 {
    static int t;
    static int[] m;
    static String[][] ms;
//
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        m = new int[t];
        ms = new String[t][];

        for (int i = 0; i < t; i++) {
            m[i] = Integer.parseInt(br.readLine());
            int c = m[i]%10 == 0? m[i]/10:((m[i]/10)+1);
            String lines = "";
            for (int j = 0; j < c; j++) {
                lines+=br.readLine().replace(System.lineSeparator(), "");
                lines+=" ";
            }
            ms[i] = lines.split(" ");
        }

        for (int i = 0; i < t; i++) {
            printMid(i);
        }

    }

    static void printMid(int tn) {
        String[] nums = ms[tn];
        List<Integer> sorted = new ArrayList<>();

        System.out.println(((m[tn]/2) + (m[tn]%2)));

        int p = 0;
        for (int i = 0; i < nums.length; i++) {
            sorted.add(Integer.parseInt(nums[i]));
            Collections.sort(sorted);
            int size = sorted.size();
            if (size%2 == 1) {
                System.out.print(sorted.get(size/2)+" ");
                ++p;
                if (p%10==0) {
                    System.out.print(System.lineSeparator());
                }
            }

        }
        System.out.println();
    }
}
//t 1000개 수열 9999개
// 1000 00000
//