package programmers;

class Solution {
    int[][] b;
    int[][] sum;

    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        b = board;
        sum = new int[b.length+1][b[0].length+1];

        for (int[] sk:skill) {

            int[] st = new int[]{sk[1],sk[2]};
            int[] end = new int[]{sk[3],sk[4]};
            int deg = sk[5];

            //누적합 그리기
            if (sk[0] == 1) {
                //공격
                sum[st[0]][st[1]]-=deg;
                sum[end[0]+1][st[1]]+=deg;

                sum[st[0]][end[1]+1]+=deg;
                sum[end[0]+1][end[1]+1]-=deg;
            } else {
                sum[st[0]][st[1]]+=deg;
                sum[end[0]+1][st[1]]-=deg;

                sum[st[0]][end[1]+1]-=deg;
                sum[end[0]+1][end[1]+1]+=deg;
            }


            /**
             0 0 0 0 0
             0 -2 0 0 2
             0 -2 0 0 2
             0 0 0 0 0
             **/
            //누적합 배열 그리기

        }

        // for (int i=0; i<sum.length; i++) {
        //     for (int j=0; j<sum[0].length; j++) {
        //         System.out.print(sum[i][j]+" , ");
        //     }
        //     System.out.println();
        // }

        //누적합 행별로 나오게 열별로 그리기
        for (int col=0; col<sum[0].length; col++) {
            int cur = 0;
            for (int h = 0; h<sum.length; h++) {
                cur+=sum[h][col];
                sum[h][col]=cur;
            }
        }

//             System.out.println("-----");

//             for (int i=0; i<sum.length; i++) {
//                 for (int j=0; j<sum[0].length; j++) {
//                     System.out.print(sum[i][j]+" , ");
//                 }
//                 System.out.println();
//             }


        //누적합 적용

        for (int i=0; i<b.length; i++) {
            int cur = 0;
            for (int j=0; j<b[0].length; j++) {
                cur+=sum[i][j];
                b[i][j]+=cur;
            }
        }

        for (int i=0; i<b.length; i++) {
            for (int j=0; j<b[0].length; j++) {
                if (b[i][j]>0) {
                    answer++;
                }
            }
        }

        return answer;
    }
}
