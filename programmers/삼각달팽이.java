class 삼각달팽이 {

    static int[][] nums;
    static int N;
    static int count = 0;

    public int[] solution(int n) {
        N = n;
        nums = new int[n][n];


        if (n ==0) {
            return new int[0];
        }
        int x=0,y=0;
        int num = 2;
        nums[0][0]=1;
        count++;

        while(true) {
            if (count == n*(n+1)/2) {
                break;
            }
            boolean allPass = true;

            while(true) {
                if (y+1 >= n || nums[y+1][x] != 0) {
                    break;
                }
                allPass = false;
                nums[++y][x] = num++;
                count++;
            }

            while (true) {
                if (x+1 >= n || nums[y][x+1] !=0) {
                    break;
                }
                allPass = false;
                nums[y][++x] = num++;
                count++;
            }

            while (true) {
                if (y-1 <0 || x-1<0 || nums[y-1][x-1] != 0 ) {
                    break;
                }
                allPass = false;
                nums[--y][--x] = num++;
                count++;
            }

            if (allPass) {
                break;
            }
        }

        //행 순서대로 배열에 넣기
        int[] ans = new int[count];
        int idx = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (nums[i][j] == 0) {
                    break;
                }
                ans[idx++] = nums[i][j];
            }
        }

        return ans;
    }
}
