class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        int idx=0;

        for(;idx<prices.length;idx++){
            int sec=0;
            for(int i=idx+1;i<prices.length;i++){
                ++sec;
                if(prices[idx]>prices[i]){
                    break;
                }
            }

            answer[idx]=sec;
        }

        return answer;
    }
}