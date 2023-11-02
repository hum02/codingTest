package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class boj3053 {
    static double pie = Math.PI;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        double a = (double)Integer.valueOf(sc.nextLine());

        //유클리드
        System.out.printf("%-20.6f %n", a*a*pie);

        //택시
        System.out.printf("%.6f%n", a*a*2);

    }
}
