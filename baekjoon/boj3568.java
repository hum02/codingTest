package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj3568 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        String[] split = s.replace(",","")
                .replace(";","")
                .split(" ");
        String basic = split[0];

        StringBuilder sb = new StringBuilder();
        for(int i =1; i< split.length; i++) {
            String s2 = split[i];
            char[] ca = s2.toCharArray();

            String name = "";
            for(int j=ca.length-1; j>=0; j--) {

                if (!(ca[j] == '*'|| ca[j] == '[' || ca[j] == ']' || ca[j] == '&')) {
                    name = s2.substring(0,j+1);
                    break;
                }
                if (ca[j] ==']') {
                    ca[j] = '[';
                }
                else if (ca[j] =='[') {
                    ca[j] = ']';
                }
                sb.append(ca[j]);
            }
            System.out.println(basic + sb.toString() + " " + name+";");
            sb = new StringBuilder();
        }

    }
}
