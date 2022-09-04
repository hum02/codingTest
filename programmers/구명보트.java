import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        int ans= 0;
        Arrays.sort(people);
        int min=0;
        int max=people.length-1;

        while(min<=max){
            if(people[min]+people[max]<=limit){
                ++ans;
                ++min;
                --max;
            }
            else{
                --max;
                ++ans;
            }

            if(min==max){++ans; break;}
        }
        return ans;
    }
}