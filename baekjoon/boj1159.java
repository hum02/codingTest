package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj1159 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String input=br.readLine().toUpperCase();
        char[] str=input.toCharArray();

        //알파벳 별로 cnt저장
        int[] cnt=new int[27];
        int max_idx=(int)str[0]-65;

        for(int i=0;i<str.length;i++) {
            int idx = (int) str[i] - 65;
            cnt[idx]++;
            if (cnt[max_idx] < cnt[idx]) {
                max_idx = idx;
            }
        }

        Arrays.sort(cnt);
        if(cnt[cnt.length-1]==cnt[cnt.length-2]){
            System.out.println("?");
        }else{
            System.out.println( (char)(max_idx+65) );
        }


    }
}
