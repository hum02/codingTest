
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        String[] words=new String[n];


        for(int i=0;i<n;i++){
            words[i]= br.readLine();
        }

        Arrays.sort(words);
        Arrays.sort(words,Comparator.comparing(String::length));


        for(int i=0;i<words.length;i++){
            if(i<words.length-1 && words[i].equals(words[i+1])){

                continue;
            }
            else{
                System.out.println(words[i]);
            }
        }
    }
}
