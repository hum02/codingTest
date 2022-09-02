package  baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        int[] answer=new int[T];

        for(int i=0;i<T;i++){
            String[] l1=br.readLine().split(" ");
            String[] l2=br.readLine().split(" ");
            int fileNum=Integer.parseInt(l1[0]);
            int idx=Integer.parseInt(l1[1]);

            Map<Integer,Integer> map= new HashMap<>();
            Queue<Integer> q= new LinkedList<>();
            for(int j=0;j< fileNum;j++){
                map.put(j,Integer.parseInt(l2[j]));
                q.add(j);
            }

            //문서들 우선순위 중 최댓값 알기 위해 int[] arr저장
            int[] arr=new int[l2.length];
            for(int j=0;j<l2.length;j++){
                arr[j]=Integer.parseInt(l2[j]);
            }
            Arrays.sort(arr);

            //q의 peek가 우선순위 가장 높은 것일 때 뽑으면서 순회
            int pollNum=0;
            for(int max_idx=arr.length-1;max_idx>=0;max_idx--){

                while(map.get( q.peek() )!=arr[max_idx]){
                    q.add(q.poll());
                }

                //q peek의 우선순위가 가장 높은 상태
                //순서 알기 원하던 값이 print되었으면
                if( q.peek()==idx ){
                    ++pollNum;
                    answer[i]=pollNum;
                    break;
                }
                //원한 문서 말고 다른 문서가 print됨
                q.poll();
                ++pollNum;
            }
        }
        for(int i=0;i<answer.length;i++){
            System.out.println(answer[i]);
        }
    }
}
