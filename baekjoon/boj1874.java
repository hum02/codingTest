package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class boj1874 {
    static int N;
    static int[] arr;

    static int num = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Integer> stk = new Stack<>();
        List<String> ans = new ArrayList<>();
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        stk.push(0);

        for (int i = 0; i < N; i++) {
            if (stk.peek() < arr[i]) {
                while(num != arr[i]) {
                    stk.push(num);
                    ans.add("+");
                    num++;
                }
                ans.add("+");
                stk.push(num);
                num++;
            }

            if (stk.peek() == arr[i]) {
                stk.pop();
                ans.add("-");
            }
        }

        if (stk.size() >1) {
            System.out.println("NO");
        }else {
            for (String s:
                 ans) {
                System.out.println(s);
            }
        }
    }


}

/**
 * 1 2 5 7 8
 *
 * 4 3 6
 * **/