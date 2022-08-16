import java.util.Queue;
import java.util.LinkedList;


class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        int[] w=truck_weights;
        int in_w=0;
        int truck_idx=0;
        //bridge length길이의 큐, 합해서 weight이하라면 큐에 넣음.
        //1초에 1 lenght만큼 전진.

        Queue<Integer> q= new LinkedList<>();
        q.add(w[truck_idx]);
        ++time;
        in_w+=w[truck_idx];
        ++truck_idx;
        int polled=0;

        while(!q.isEmpty()){

            if(q.size()>=bridge_length){
                in_w-=q.peek();
                //마지막 트럭이 지나감
                if(truck_idx==w.length && q.peek()==w[truck_idx-1] && polled==w.length-1 ){
                    ++time;
                    break;
                }
                if(q.peek()!=0){++polled;}
                q.poll();

            }

            if( (truck_idx<w.length) && (in_w+w[truck_idx]<=weight) ){
                q.add(w[truck_idx]);
                System.out.println(w[truck_idx]);
                in_w+=w[truck_idx];
                ++truck_idx;
            }
            else{
                q.add(0);
            }

            ++time;
        }

        return time;
    }
}