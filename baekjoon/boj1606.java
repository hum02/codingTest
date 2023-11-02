package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj1606 {
    static int[] coord;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        String[] sa = s.split(" ");
        coord = new int[] {Integer.parseInt(sa[0]), Integer.parseInt(sa[1])};

        long res = 1;
        long floor = coord[0] + coord[1]; //둘 다 양수 -> 이전 계층 시작점부터 세기
        if (coord[1] ==0) {floor = floor+1;} // 계층의 시작점
        for (long i=0; i< floor; i++) {
            res+=6*i;
        }

        System.out.println(res+coord[1]);
    }
}
