class Solution {
    public int[] solution(int brown, int yellow) {
        int[] ans = new int[2];

        int total=brown+yellow;
        for(int len=1;len<total;len++){
            int wid=total/len;
            if(total==wid*len){
                //(가로+세로)*2-4=brown의 개수면 맞다.
                if((wid+len)*2-4==brown){
                    ans[0]=wid;
                    ans[1]=len;
                    break;
                }

            }
        }

        return ans;
    }
}