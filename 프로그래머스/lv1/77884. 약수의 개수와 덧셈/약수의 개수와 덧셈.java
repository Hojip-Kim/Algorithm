

import java.util.ArrayList;

class Solution {


    private int isOdd(int num){
        int answer = 0;
        int cnt = 0;

        for(int i = 1; i<=num; i++){
            if(num%i == 0){
                cnt++;
            }else{
                continue;
            }
        }
        if(cnt % 2 == 0){
            answer = num;
        }else{
            num *= -1;
            answer = num;
        }

        return answer;
    }
    public int solution(int left, int right) {
        int answer = 0;


        for(int i = left; i<=right; i++){
            answer += isOdd(i);
        }

        return answer;
    }
}