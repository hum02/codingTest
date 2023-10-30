package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class boj17413 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringBuilder sb = new StringBuilder();

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            //태그이면 그대로
            if (c == '<') {
                while (!stack.empty()) {
                    sb.append(stack.pop());
                }

                sb.append(c);
                ++i;
                while(str.charAt(i) != '>') {
                    sb.append(str.charAt(i));
                    ++i;
                }
                sb.append('>');
                continue;
            }

            if (c != ' ') {
                stack.push(c);
            }

            //공백이면 뒤집기
            if (c == ' ') {
                while (!stack.empty()) {
                    sb.append(stack.pop());
                }
                sb.append(' ');
            }
        }

        while (!stack.empty()) {
            sb.append(stack.pop());
        }

        System.out.println(sb.toString());
    }
}


// 앞이 공백이냐, 태그이냐에 따라 그 다음 문자열들을 어떠헥 다룰지 결정하는 것
//
