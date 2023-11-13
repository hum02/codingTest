package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class boj1213 {
    static char[] name;
    static char[] ans;
    static int left ,right;
    static List<Character> remain = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        name = s.toCharArray();
        Arrays.sort(name);
        ans = new char[name.length];
        left = 0;
        right = name.length-1;


        for (int i = 0; i < name.length; i++) {
            if (i == name.length-1) {

                remain.add(name[i]);
                continue;
            }
            if (name[i] == name[i+1]) {
                ans[left] = name[i];
                left++;
                ++i;
                ans[right] = name[i];
                right--;
//                if (left >= right) {
//                    break;
//                }
            } else {
                remain.add(name[i]);
            }
        }

//        System.out.println(Character.toString(remain.get(0)));

        if (remain.size() == 1) {
            ans[(name.length/2)] = remain.get(0);
            String a = "";
            for (Character c : ans) {
                a+=Character.toString(c);
            }
            System.out.println(a);
            return;
        }
        else if (remain.size() ==0) {
            String a = "";
            for (Character c : ans) {
                a+=Character.toString(c);
            }
            System.out.println(a);
            return;
        }
        System.out.println("I'm Sorry Hansoo");


        //정렬하기
        //앞에서부터 양끝 배치하기 , 홀수이면 하나 남기기
        //홀수인 거 또 생기면 실패



    }
}
