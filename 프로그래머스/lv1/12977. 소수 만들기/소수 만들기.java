class Solution {

    boolean isNum(int n){
        boolean isNum = true;
        int cnt= 0;
        for (int i = 1; i <= n; i++) {
            if(n%i == 0){
                cnt++;
            }
        }
        if(cnt == 2){
            isNum = true;
        }else {
            isNum = false;
        }
        return isNum;
    }

    public int solution(int[] nums) {
        int answer = 0;


        for(int i = 0; i<nums.length; i++){
            for (int j = i+1; j < nums.length; j++) {
                for (int k = j+1; k < nums.length; k++) {
                    if(isNum(nums[k]+nums[j]+nums[i])){
                        answer++;
                    }
                }
            }
        }

        return answer;
    }
}