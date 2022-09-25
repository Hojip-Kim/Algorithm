

class Solution {


    private long price(int price, int count){ // 3, 4

        long answer = 0;

        for(int i = 1; i<=count; i++){
            answer += price * i;
        }

        return answer;
    }
    public long solution(int price, int money, int count) {
        long answer = 0;

        if(money <= price(price, count)){
            answer = (long)(price(price, count) - money);
        }

        return answer;
    }
}