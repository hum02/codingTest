/*
class Solution {
    int answer=0;
    int[] nums;
    int target;

    public void dfs(int idx,int sum){
        if(idx==nums.length){
            if(sum==target){
                ++answer;
            }
            return;
        }

        dfs(idx+1,sum-nums[idx]);
        dfs(idx+1,sum+nums[idx]);
    }

    public int solution(int[] numbers, int target) {
        nums=numbers;
        this.target=target;

        dfs(0,0);

        return answer;
    }
}
*/
