package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class boj1759 {
    static int L,C;
    static char[] cs;
    static int[] picked;
    static List<Character> ms = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String ss[] = br.readLine().split(" ");

        L = Integer.parseInt(ss[0]);
        C = Integer.parseInt(ss[1]);

        //문자열 입력받아 정렬
        picked = new int[C];
        cs = new char[C];
        String[] s2 = br.readLine().split(" ");
        for (int i = 0; i < s2.length; i++) {
            cs[i] = s2[i].charAt(0);
        }
        Arrays.sort(cs);

        ms.add('a');;ms.add('e');ms.add('i');ms.add('o');ms.add('u');

        //L개 만큼, 이미 뽑것보다 뒤의 것중에서 뽑기.
        //1개 이상의 모음, 2개 이상의 자음검사
        pickN(-1,0);

    }

    static void pickN(int prev, int depth) {
        if (prev > C-1) {
            return;
        }

        if (depth == L) {
            //자음, 모음개수 검사하기
            int jaC = 0;
            int moC = 0;
            for (int i = 0; i < L; i++) {
                int idx = picked[i];
                if (ms.contains(cs[idx])) {
                    moC++;
                } else {
                    jaC++;
                }
            }
            if (moC<1 || jaC <2) {
                return;
            }

            //출력하기
            for (int i = 0; i < L; i++) {
                System.out.print(cs[picked[i]]);
            }
            System.out.println();
            return;
        }

        for (int i = prev+1; i < C; i++) {
            picked[depth] = i;
            pickN(i, depth+1);
        }
    }
}
