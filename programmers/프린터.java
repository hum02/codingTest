/*
import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int[] a=priorities;
        int answer = 0;
        Queue<Integer[]> q=new LinkedList<>();

        for(int i=0;i<a.length;i++){
            Integer[] tmp={a[i],i};
            q.add(tmp);
        }

        //배열 정렬
        Arrays.sort(a);

        int max_idx=a.length-1;
        while(!q.isEmpty()){
            if(q.peek()[0]!=a[max_idx]){
                q.add(q.peek());
                q.poll();
            }
            else if( q.peek()[1]==location){
                //최우선 중요도의 문서이며 원하는 idx
                ++answer;
                break;
            }
            else{
                q.poll();
                --max_idx;
                ++answer;
            }
        }
        return answer;
    }
}*/
