
class Solution {

    public int divisorNum(int number){
        int answer = 0;

        for (int i = 1; i <= Math.sqrt(number); i++) {
            if(number % i == 0){
                if(i*i == number){
                    answer++;
                }else{
                    answer += 2;
                }
                
            }
        }
        return answer;
    }

    public int solution(int number, int limit, int power) {
        int answer = 0;

        for (int i = 1; i <= number; i++) {
            if(divisorNum(i) <= limit){
                answer += divisorNum(i);
            }else{
                answer += power;
            }
        }

        return answer;
    }
}