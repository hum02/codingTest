import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String,Integer> map=new HashMap<>();
        HashSet<String> set=new HashSet<>();

        for(String[] cloth:clothes){
            map.put(cloth[1],map.getOrDefault(cloth[1],0)+1);
            set.add(cloth[1]);
        }

        for(String kind:set){
            answer=answer*(map.get(kind)+1);
        }

        return answer-1;
    }
}