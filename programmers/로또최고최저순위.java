package programmers;

public class 로또최고최저순위 {
    public int[] solution(int[] lottos, int[] win_nums) {
        int sameCnt=0;
        int zeroCnt=0;

        //lottos에서 0이 아닌 것 win_nums의 포함개수
        for(int i=0;i<lottos.length;i++){
            if(lottos[i]==0 ){
                zeroCnt++;
                continue;
            }
            else{

                for(int j=0;j<win_nums.length;j++){
                    if(lottos[i]==win_nums[j]){
                        sameCnt++;
                        break;
                    }
                }

            }
        }

        int maxRank=7-(sameCnt+zeroCnt);
        if(maxRank>=6){maxRank=6;}
        int minRank=7-sameCnt;
        if(minRank>=6){minRank=6;}


        return new int[]{maxRank,minRank};
    }
}
