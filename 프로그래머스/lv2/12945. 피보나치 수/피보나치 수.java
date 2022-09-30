class Solution {

    int fibo(int num){ // 0 1 1 2 3 5 8 13 21
        int first = 0;
        int second = 1;
        int third;
        if(num <2){
            return num;
        }else{
            for(int i = 2; i<=num; i++){
                third = (second + first) % 1234567;
                first = second; // 1
                second = third; // 1
            }
        }
        return second;
    }


    public int solution(int n) {
        int answer = 0;

        answer = fibo(n);

        return answer;
    }
}